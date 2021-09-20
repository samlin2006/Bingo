package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CardStack {
    private ArrayList<Card> cards = new ArrayList<>();
    private Random rand;
    private int numWinners;



    public CardStack(int numCards, int seed, int numWinners){
        rand = new Random(seed);
        for(int i = 0; i < numCards; i++){
            cards.add(new Card(seed + rand.nextInt()));
        }
        this.numWinners = numWinners;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public Card getCard(int index){
        return cards.get(index);
    }


    public boolean gameOver(){
        int winnersCount = 0;
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).isBingo()){
                winnersCount++;
            }
        }
        if(winnersCount >= numWinners){
            return true;
        }
        return false;
    }

    public int getNumDraws(){
        int drawNumber = 0;
        while(!gameOver()){
            drawNumber++;
        }
    }




    private ArrayList<Integer> existingNumbers = new ArrayList<>();
}
