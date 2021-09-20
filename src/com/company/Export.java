package com.company;

import java.util.*;
import java.io.*;

public class Export {
    public static void printList(ArrayList<Integer> balls) {
        FileWriter f;
        try {
            f = new FileWriter(new File("Bingo.txt"));
            for (int i = 0; i < balls.size(); i++) {
                f.println(Integer.toString(balls.get(i)));
            }
            f.close();
        } catch (Exception E) {
            return;
        }


    }

    public static void printCards(CardSt)
}
