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

public class BingoPanel extends JPanel implements MouseListener {
    private BufferedImage BingoCard;
    private Card card;

    public BingoPanel(int seed) {
        super();
        addMouseListener(this);
        try {
            BingoCard = ImageIO.read(new File("src\\bingocardimage.jpg"));
        } catch (Exception E) {
            System.out.println("Exception Error");
            return;
        }
        card = new Card(seed);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(BingoCard, 0, 0, 160,200, null);
        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                g.drawString(Integer.toString(card.getTile(r,c).getNumber()), r * 27 + 20, c * 30 + 50);
            }
        }
        g.setColor(Color.blue);
        g.fillRect(0, 202, 158, 200);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
        System.out.println("************");


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

    private ArrayList<Integer> existingNumbers;
    private static Random rand = new Random();
    private int generate(){
        int n;
        n = rand.nextInt(75);
        while(existingNumbers.contains(n)){
            n = rand.nextInt(75);
        }
        existingNumbers.add(n);
        return n;
    }

    


}