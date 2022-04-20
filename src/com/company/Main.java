package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
public class Main extends JFrame implements MouseListener {
    private BufferedImage image;
    Main() {
        setTitle("Drawing Graphics in Frames");
        setBounds(300,0,1440,1080); // положение и размеры окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try { image = ImageIO.read(new File("nature-wallpaper-07.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addMouseListener(this);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        if (image != null)
            g.drawImage(image,0,30,null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    @Override
    public void mouseClicked(MouseEvent e) {
//        WritableRaster r = image.getRaster();
//        int[] pixel = new int[3];
//        int[] get = new int[256];
//        for (int y = 0; y < image.getHeight(); y++)
//            for (int x = 0; x < image.getWidth(); x++) {
//                r.getPixel(x, y, pixel);
//
//                int R = pixel[2];
//                int G = pixel[1];
//                int B = pixel[0];
//
//                get[G] += 1;
//            }
//        pixel[2] = 0;
//        pixel[1] = 255;
//        pixel[0] = 0;
//        for (int x = 0; x < 256; x++) {
//            for (int j = 0; j < get[x]/20; j++) {
//                r.setPixel(x, (image.getHeight() - j)/10, pixel);
//
//            }
//
//        }
        WritableRaster r = image.getRaster();
        int[] pixel = new int[3];
        int[] get = new int[256];
        for (int y = 0; y < image.getHeight(); y++)
            for (int x = 0; x < image.getWidth()-1; x++) {
                r.getPixel(x, y, pixel);
                int R = pixel[2];
                int G = pixel[1];
                int B = pixel[0];

                r.getPixel(x+1, y, pixel);
                int R1 = pixel[2];
                int G1 = pixel[1];
                int B1 = pixel[0];

                pixel[2]=R1-R+128;
                pixel[1]=G1-G+128;
                pixel[0]=B1-B+128;
                r.setPixel(x, y, pixel);
            }

        repaint();
//              if (R*1.1>=255) {
//                  R = 255;
//              }
//              else {
//                  R = (int) (R * 1.1);
//              }
//              if (B*1.1>=255){
//                  B=255;}
//              else {
//                  B=(int) (B*1.1);
//              }
//              if (G*1.1>=255){
//                  G=255;}
//              else {
//                  G=(int) (G*1.1);
//              }
//              int H = image.getHeight();
//              int W = image.getWidth();
//              if (y<x*H/W && y>-x*H/W+H|| y>x*H/W && y <-x*H/W+H){
//                  pixel[2]=255;
//                  pixel[1]=0;
//                  pixel[0]=255;
//              }
//                r.setPixel(x, y, pixel);
//            }

    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
