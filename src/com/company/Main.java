package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FirstImage image = new FirstImage("Bingo");
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Input seed");

        int seed = sc.nextInt();

         */
        BingoPanel b = new BingoPanel(123);
        image.add(b);

    }
}
