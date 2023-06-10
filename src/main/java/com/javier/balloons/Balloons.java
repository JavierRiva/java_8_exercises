package com.javier.balloons;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Balloons {

    private Balloons() {
    }

    public static void calculate(InputStream stream) throws IOException {
        List<String> lines = generateDataLines(stream);
        int elementIterator = 0;
        int testsNumber = Integer.parseInt(lines.get(elementIterator));
        elementIterator++;
        for(int i = 1; i <= testsNumber; i++) {
            List<Integer> balloons = generateIntegerList(lines, elementIterator);
            elementIterator++;
            int participantsNumber = Integer.parseInt(lines.get(elementIterator));
            elementIterator++;
            int minimumCost = calculateMinimumCost(lines, balloons, participantsNumber, elementIterator);
            elementIterator += participantsNumber;
            System.out.println(minimumCost);
        }
    }

    private static List<String> generateDataLines(InputStream stream) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    private static int calculateMinimumCost(List<String> lines,
                                            List<Integer> balloons,
                                            int participantsNumber,
                                            int elementIterator) {
        int problemOneOk = 0;
        int problemTwoOk = 0;
        for(int j = 0; j < participantsNumber; j++) {
            List<Integer> problemResults = generateIntegerList(lines, elementIterator);
            problemOneOk = problemOneOk + problemResults.get(0);
            problemTwoOk = problemTwoOk + problemResults.get(1);
            elementIterator++;
        }
        int costOne = (balloons.get(0) * problemOneOk) + (balloons.get(1) * problemTwoOk);
        int costTwo = (balloons.get(1) * problemOneOk) + (balloons.get(0) * problemTwoOk);
        return Math.min(costOne, costTwo);
    }

    private static List<Integer> generateIntegerList(List<String> lines, int elementIterator) {
        return Arrays
                .stream(lines.get(elementIterator).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
