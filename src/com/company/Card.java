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

    private int generateNumbers(int row) {
        return rand.nextInt(15) + 15 * row + 1;
    }

    public Tile getTile(int r, int c) {
        return ray[r][c];
    }

    public boolean isBingo() {
        boolean rowBingo = true;
        boolean columnBingo = true;
        boolean diagnalBingo = true;
        boolean diagnalBingo2 = true;
        for (int r = 0; r < ray.length; r++) {
            if (!rowBingo(ray[r])) {
                rowBingo = false;
            }
        }
        for(int c = 0; c < ray.length; c++){
            Tile [] temp2 = getColumn(ray, c);
            if(!rowBingo(temp2)){
                columnBingo =  false;
            }
        }
        for(int i = 0; i < 5; i++){
            if(!ray[i][i].isCrossed()){
                diagnalBingo = false;
            }
        }

        for(int r = 0; r < 5; r++){
            int c = 4;
            if(!ray[r][c].isCrossed()){
                diagnalBingo2 = false;
            }
            c--;
        }
        return (rowBingo || columnBingo || diagnalBingo || diagnalBingo2);
    }

    public boolean rowBingo(Tile[] tiles) {
        boolean temp = true;
        for (int i = 0; i < tiles.length; i++) {
            if (!tiles[i].isCrossed()) {
                return false;
            }
        }
        return true;
    }

    public Tile [] getColumn(Tile [][] t, int c){
        Tile column [] = new Tile[5]
        for(int i = 0; i < t[0].length; i++){
            column [i] = t[i][c];
        }
        return column;
    }

    @Override
    public String toString() {
        return "Card{" +
                ", ray=" + Arrays.toString(ray) +
                '}';
    }
}
