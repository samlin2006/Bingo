package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CardStack {
    private ArrayList<Card> cards = new ArrayList<>();
    private Random rand;
    private int numWinners;
    private int days;



    public CardStack(int numCards, int seed, int numWinners, int days){
        rand = new Random(seed);
        for(int i = 0; i < numCards; i++){
            int nextRand = generate();
            cards.add(new Card(seed + nextRand));

        }
        this.numWinners = numWinners;
        this.days = days;
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


    public ArrayList<Integer> getWinnersIndexList(){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < cards.size();i++){
            if(cards.get(i).isBingo()){
                list.add(i);
            }
        }
        return list;
    }

    public int getCurrentWinnersCount() {
        int count = 0;
        for(Card c : cards){
            if(c.isBingo()){
                count++;
            }
        }
        return count;
    }

    private int generate(){
        int nextRand = rand.nextInt();
        while(existingNumbers2.contains(nextRand)){
            nextRand = rand.nextInt();
        }
        existingNumbers2.add(nextRand);
        return nextRand;
    }
    private ArrayList<Integer> existingNumbers2 = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }
    public Card getCard(int index){
        return cards.get(index);
    }

}
