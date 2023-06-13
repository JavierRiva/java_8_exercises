package com.javier.bestindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BestIndex {

    public static int calculateBestIndex(Scanner scanner) {
        var n = scanner.nextInt();
        scanner.nextLine();
        var st = scanner.nextLine().trim();
        var array = Arrays
                .stream(st.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        var results = new ArrayList<Integer>();
        for (var i = 0; i < array.length; i++) {
            var r = 0;
            var k = 1;
            var i2 = 0;
            for (var j = 2; k <= n; j++) {
                while (i2 < k) {
                    r = r + array[i + i2];
                    i2++;
                }
                k = k + j;
            }
            n--;
            results.add(r);
        }
        return Collections.max(results);
    }
}
