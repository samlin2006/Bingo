package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Card {

    private final Random rand;
    private final Tile[][] ray;

    public Card(long seed) {
        rand = new Random(seed);

        ray = new Tile[5][5];

        for (int r = 0; r < 5; r++) {
            ArrayList<Integer> nums = new ArrayList<>();
            int n;
            for (int c = 0; c < 5; c++) {
                Tile tile = new Tile();
                ray[r][c] = tile;
                if (r == 2 && c == 2) {
                    tile.setNumber(-1);
                    tile.setCrossed(true);
                }


                n = generateNumbers(r);
                while (nums.contains(n)) {
                    n = generateNumbers(r);
                }
                nums.add(n);
                tile.setNumber(n);
            }
        }
    }

    public void clearCard(){
        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                ray[r][c].setCrossed(false);
            }
        }
    }

    private int generateNumbers(int row) {
        return rand.nextInt(15) + 15 * row + 1;
    }

    public Tile getTile(int r, int c) {
        return ray[r][c];
    }

    public boolean isBingo(){
        //row
        if(ray[0][0].isCrossed() && ray[0][1].isCrossed() && ray[0][2].isCrossed() && ray[0][3].isCrossed() && ray[0][4].isCrossed()){
            return true;
        }
        if(ray[1][0].isCrossed() && ray[1][1].isCrossed() && ray[1][2].isCrossed() && ray[1][3].isCrossed() && ray[1][4].isCrossed()){
            return true;
        }
        if(ray[2][0].isCrossed() && ray[2][1].isCrossed() && ray[2][2].isCrossed() && ray[2][3].isCrossed() && ray[2][4].isCrossed()){
            return true;
        }
        if(ray[3][0].isCrossed() && ray[3][1].isCrossed() && ray[3][2].isCrossed() && ray[3][3].isCrossed() && ray[3][4].isCrossed()){
            return true;
        }
        if(ray[4][0].isCrossed() && ray[4][1].isCrossed() && ray[4][2].isCrossed() && ray[4][3].isCrossed() && ray[4][4].isCrossed()){
            return true;
        }
        //column
        if(ray[0][0].isCrossed() && ray[1][0].isCrossed() && ray[2][0].isCrossed() && ray[3][0].isCrossed() && ray[4][0].isCrossed()){
            return true;
        }
        if(ray[0][1].isCrossed() && ray[1][1].isCrossed() && ray[2][1].isCrossed() && ray[3][1].isCrossed() && ray[4][1].isCrossed()){
            return true;
        }
        if(ray[0][2].isCrossed() && ray[1][2].isCrossed() && ray[2][2].isCrossed() && ray[3][2].isCrossed() && ray[4][2].isCrossed()){
            return true;
        }
        if(ray[0][3].isCrossed() && ray[1][3].isCrossed() && ray[2][3].isCrossed() && ray[3][3].isCrossed() && ray[4][3].isCrossed()){
            return true;
        }
        if(ray[0][4].isCrossed() && ray[1][4].isCrossed() && ray[2][4].isCrossed() && ray[3][4].isCrossed() && ray[4][4].isCrossed()){
            return true;
        }

        //diagnals
        if(ray[0][0].isCrossed() && ray[1][1].isCrossed() && ray[3][3].isCrossed() && ray[4][4].isCrossed()){
            return true;
        }
        if(ray[0][4].isCrossed() && ray[1][3].isCrossed() && ray[3][1].isCrossed() && ray[4][0].isCrossed()){
            return true;
        }
        return false;
    }

}
