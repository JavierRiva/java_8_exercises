package com.javier.bracketvalidation;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BracketValidation {

    private BracketValidation() {
    }

    //    private static final Map<String, String> USED_BRACKETS = Map.of("{", "}", "[", "]", "(", ")");
    private static final List<Character> OPEN_BRACKETS = List.of('[', '{', '(');
    private static final List<Character> CLOSE_BRACKETS = List.of(']', '}', ')');

    public static boolean validate(String bracketsStr) {
//        var brackets = bracketsStr.split("");
//        var auxList = new ArrayList<String>();
//        for (var brk : brackets) {
//            for (var entry : USED_BRACKETS.entrySet()) {
//                if (entry.getKey().equals(brk)) {
//                    auxList.add(entry.getKey());
//                } else if (entry.getValue().equals(brk)) {
//                    if (auxList.get(auxList.size() - 1).equals(entry.getKey())) {
//                        auxList.remove(auxList.size() - 1);
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        return auxList.isEmpty();

        var stk = new Stack<Character>();
        boolean b = true;
        var brackets = bracketsStr.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        for (var brk : brackets) {
            int j = 0;
            for (var openCh : OPEN_BRACKETS) {
                if (brk.equals(openCh)) {
                    stk.push(brk);
                } else if (brk.equals(CLOSE_BRACKETS.get(j))) {
                    if (!stk.isEmpty() && stk.peek().equals(openCh)) {
                        stk.pop();
                    } else {
                        b = false;
                    }
                }
                j++;
            }
        }
        return b && stk.isEmpty();
    }
}
