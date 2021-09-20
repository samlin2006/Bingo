package com.company;

import javax.swing.*;

public class BingoFrame extends JFrame {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 960;

    private static int days, seed, winners, bingoCards;

    public BingoFrame(String title){
        super(title);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        seed = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter seed number"));
        days = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of days"));
        winners = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of winners"));
        bingoCards = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of cards"));


        BingoPanel bp = new BingoPanel(seed, days, winners, bingoCards);
        add(bp);
        setVisible(true);

    }


}