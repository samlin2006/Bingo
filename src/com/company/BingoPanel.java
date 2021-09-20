package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class BingoPanel extends JPanel implements MouseListener {

    private BufferedImage BingoCard;
    private CardStack cards;
    private static int cardIndex = 0;
    private int numCards;
    private ArrayList<Integer> ballsRolled = new ArrayList<>();
    private int numDays;

    public BingoPanel(int seed, int days, int numWinners, int numCards) {

        super();
        addMouseListener(this);

        numDays = days;

        try {
            BingoCard = ImageIO.read(new File("src\\bingocardimage.jpg"));
        } catch (Exception E) {
            System.out.println("Exception Error");
            return;
        }

        cards = new CardStack(numCards, seed, numWinners);
        this.numCards = numCards;
        repaint();



    }


    public void paint(Graphics g) {
        g.drawImage(BingoCard, 0, 0, 320, 400, null);
        g.setFont(new Font("Ariel", Font.PLAIN, 15));
        g.setColor(Color.white);
        g.fillRect(480, 480, 100, 100);


        g.setColor(Color.black);
        g.fillRect(660,0, 200, 200);
        g.setColor(Color.white);
        g.drawString("Export", 700, 100);


        //switch between cards
        g.setColor(Color.red);
        g.fillRect(321, 0, 166, 64);
        g.setColor(Color.white);
        g.drawString("Next Card", 360, 50);

        g.setColor(Color.blue);
        g.fillRect(321, 64, 166, 64);
        g.setColor(Color.white);
        g.drawString("Previous Card", 360, 100);

        g.setColor(Color.orange);
        g.fillRect(321, 128, 166, 64);
        g.setColor(Color.white);
        g.drawString("Card Index: "  + (1 + cardIndex),360, 150);


        g.setColor(Color.green);
        g.fillRect(321 + 166, 0, 166, 64);
        g.setColor(Color.white);
        g.drawString("Roll ball", 530, 50);


        //drawing bingo card with filled in red
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {

                if (r == 2 && c == 2) {
                } else if (!cards.getCard(cardIndex).getTile(r, c).isCrossed()) {
                    g.setColor(Color.black);
                    g.drawString(Integer.toString(cards.getCard(cardIndex).getTile(r, c).getNumber()), r * 54 + 40, c * 55 + 100);
                } else if (cards.getCard(cardIndex).getTile(r, c).isCrossed()) {
                    g.setColor(Color.red);
                    g.drawString(Integer.toString(cards.getCard(cardIndex).getTile(r, c).getNumber()), r * 54 + 40, c * 55 + 100);
                }
            }
        }

        //rolling balls
        if (ballsRolled.size() == 0) {
            return;
        }
        g.drawString(Integer.toString(ballsRolled.get(ballsRolled.size() - 1)), 500, 500);

        for (int i = 0; i < ballsRolled.size(); i++) {
            g.drawString(Integer.toString(ballsRolled.get(i)), 30 * ((1 + i)%(getWidth()/30)) , 700 + i/(getWidth()/30) * 30);
        }

        //checking if ball equals a tile in bingo

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                for (int j = 0; j < numCards; j++) {
                    if (cards.getCard(j).getTile(r, c).getNumber() == ballsRolled.get(ballsRolled.size() - 1)) {
                        cards.getCard(j).getTile(r, c).setCrossed(true);
                    }
                }
            }
        }






        //checking for bingo
        if (cards.getCard(cardIndex).isBingo()) {
            g.setColor(Color.green);
            g.drawString("Bingo!", 600,600);
        } else{
            g.setColor(Color.white);
            g.fillRect(580,580,100,100);
        }


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("x: " + e.getX() + "      y: " + e.getY());
        System.out.println("************");

        if (x >= 321 && x <= 487 && y >= 0 && y <= 64 && cardIndex < numCards - 1) {
            cardIndex++;
        } else if (x >= 321 && x <= 487 && y >= 64 && y <= 128 && cardIndex > 0) {
            cardIndex--;
        } else if (x >= 487 && x <= 653 && y >= 0 && y <= 64) {
            int ball = generate();
            ballsRolled.add(ball);
        }

        repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private ArrayList<Integer> existingNumbers = new ArrayList<>();
    private static Random rand = new Random();

    private int generate() {
        int n;
        n = rand.nextInt(75);
        while (existingNumbers.contains(n)) {
            n = rand.nextInt(75);
        }
        existingNumbers.add(n);
        return n;
    }


}