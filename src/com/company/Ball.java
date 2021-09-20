package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Ball {
    private ArrayList<Integer> existingNumbers = new ArrayList<>();
    private static Random rand = new Random();

    public int generate() {
        int n;
        n = rand.nextInt(75);
        while (existingNumbers.contains(n)) {
            n = rand.nextInt(75);
        }

        existingNumbers.add(n);
        return n;
    }
}
