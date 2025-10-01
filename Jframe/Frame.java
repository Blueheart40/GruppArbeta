package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Frame extends JFrame {
    private JLabel adLabel;
    private ImageIcon[] adImages;
    private int currentAdIndex = 0;

    public Frame() {
        setTitle("Reklamskylt!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        adImages = new ImageIcon[]{
            new ImageIcon("ad1.jpg"),
            new ImageIcon("ad2.jpg"),
            new ImageIcon("ad3.jpg"),
            new ImageIcon("ad4.jpg")
        };

        for (int i = 0; i < adImages.length; i++) {
            if (adImages[i].getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Image failed to load: ad" + (i + 1) + ".jpg");
            }

            Image scaledImage = adImages[i].getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
            adImages[i] = new ImageIcon(scaledImage);
        }

        adLabel = new JLabel(adImages[currentAdIndex]);
        add(adLabel);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAdIndex = (currentAdIndex + 1) % adImages.length;
                adLabel.setIcon(adImages[currentAdIndex]);
            }
        });

        timer.start();

        pack(); // Automatically size the window to fit content
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame());
    }
}
