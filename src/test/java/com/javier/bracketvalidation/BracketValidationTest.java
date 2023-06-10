package com.javier.bracketvalidation;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BracketValidationTest {

    private static final String BRACKETS_OK = "{ [] () }";
    private static final String BRACKETS_WRONG_1 = "{{ [] () }";
    private static final String BRACKETS_WRONG_2 = "{ [ (]) }";

    private static final List<String> BRACKETS_LIST = List.of("[({})(())]", "(({()})))[[",
            "({(){}()})()({(){}()})(){()}{}((()))", "{}()))(()()({}}{}", "}}}}", "))))", "{{{", "(((",
            "{}(){()}((())){{{}}}{()()}{{}{}}", "{{{{{{{)))))))))))))))))))", "{}{}(", "{}}}{}", "()()()())))",
            "(((((()()()", "(){}{{}}()(()){{()()}}", "{}{{{}}}{{{((()))}}}", "((()))[]", "{{}}(()[])");
    private static final List<Boolean> RESULTS_LIST = List.of(true, false, true, false, false, false, false, false,
            true, false, false, false, false, false, true, true, true, true);

    @Test
    public void validateTrue() {
        var validation = BracketValidation.validate(BRACKETS_OK);
        Assert.assertTrue(validation);
    }

    @Test
    public void validateFalse1() {
        var validation = BracketValidation.validate(BRACKETS_WRONG_1);
        Assert.assertFalse(validation);
    }

    @Test
    public void validateFalse2() {
        var validation = BracketValidation.validate(BRACKETS_WRONG_2);
        Assert.assertFalse(validation);
    }

    @Test
    public void validateSeveralCases() {
        int i = 0;
        for (var brks : BRACKETS_LIST) {
            var validation = BracketValidation.validate(brks);
            Assert.assertEquals(validation, RESULTS_LIST.get(i));
            i++;
        }
    }
}
