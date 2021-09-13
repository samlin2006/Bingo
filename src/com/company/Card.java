package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Card {

    private final Random rand;
    private final Tile[][] ray;

    public Card(long seed){
        rand = new Random(seed);

        ray = new Tile[5][5];

        for(int r = 0; r < 5; r++){
            ArrayList<Integer> nums = new ArrayList<>();
            int n;
            for(int c = 0; c < 5; c++){
                Tile tile = new Tile();
                ray[r][c] = tile;
                if(r == 2 && c == 2){
                    tile.setNumber(-1);
                    tile.setCrossed(true);
                    continue;
                }
                n = generateNumbers(r);
                while(nums.contains(n)){
                    n = generateNumbers(r);
                }
                nums.add(n);
                tile.setNumber(n);
            }
        }
    }
    private int generateNumbers(int row){
        return rand.nextInt(15) + 15 * row + 1;
    }
    public Tile getTile(int r, int c){
        return ray[r][c];
    }

    @Override
    public String toString() {
        return "Card{" +
                ", ray=" + Arrays.toString(ray) +
                '}';
    }
}
