package rob.gra;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        Game game = new Game();

        JFrame frame = new JFrame("Simple Game");
        frame.setBounds(200,200,700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(game);


    }
}
