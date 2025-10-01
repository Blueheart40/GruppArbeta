package Jframe;

import javax.swing.*;


public class Frame {
    public static void main(String[] args) {
        JFrame window = new JFrame("GUI");
        window.setTitle("Reklamskylt!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 200);
        window.setVisible(true);

    }

}
