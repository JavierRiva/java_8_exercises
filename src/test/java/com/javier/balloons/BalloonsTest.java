package com.javier.balloons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class BalloonsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String INPUT_PATH = "C:\\Users\\Javier_Riva\\IdeaProjects\\java_8_exercises\\src\\test\\" +
            "java\\com\\javier\\balloons\\input.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\Javier_Riva\\IdeaProjects\\java_8_exercises\\src\\test\\" +
            "java\\com\\javier\\balloons\\output.txt";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void calculate() throws IOException {
        InputStream streamIn = new FileInputStream(INPUT_PATH);
        InputStream streamOut = new FileInputStream(OUTPUT_PATH);
        Balloons.calculate(streamIn);
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = streamOut.read()) != -1; ) {
            sb.append((char) ch);
        }
        String result = sb.toString().trim();
        Assert.assertEquals(result, outContent.toString().trim());
    }
}
