package com.javier.bestindex;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class BestIndexTest {

    private static final String INPUT_PATH = "C:\\Users\\Javier_Riva\\IdeaProjects\\java_8_exercises\\src\\test\\" +
            "java\\com\\javier\\bestindex\\input.txt";
    private static final int RESULT = 19;

    @Test
    public void testCalculateBestIndex() throws FileNotFoundException {
        var file = new File(INPUT_PATH);
        var scanner = new Scanner(file);
        var index = BestIndex.calculateBestIndex(scanner);
        Assert.assertEquals(RESULT, index);
    }
}
