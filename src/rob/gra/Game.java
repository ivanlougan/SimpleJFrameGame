package rob.gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game extends JPanel implements KeyListener, ActionListener {

    private int x = 300;
    private int points = 0;
    private Timer time;
    private int speed = 20;
    private int ex = 10;
    private int ey = 10;
    private Random r = new Random();
    private int enemy1 = r.nextInt(6)*100;
    private int enemy2 = r.nextInt(6)*100;
    private int enemy3 = r.nextInt(6)*100;

    public Game() {
        time = new Timer(10, this);
        time.start();

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 700, 600);
        // Player
        g.setColor(Color.GREEN);
        g.fillRect(x, 425, 75, 75);
        // Enemy
        g.setColor(Color.RED);
        g.fillRect(enemy1, ey, 100,100);
        g.fillRect(enemy2, ey, 100,100);
        g.fillRect(enemy3, ey, 100,100);
        // Points
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString("Points: " + points, 570, 20);
        g.drawString("Press Enter to restart",10 , 20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
        ey += 3;

        if (ey == 580) {
            points++;
            ey = 10;
            enemy1 = r.nextInt(6)*100;
            enemy2 = r.nextInt(6)*100;
            enemy3 = r.nextInt(6)*100;
        }

        Rectangle player = new Rectangle(x, 475, 75,75);
        Rectangle enemyX1 = new Rectangle(enemy1, ey,100,100);
        Rectangle enemyX2 = new Rectangle(enemy2, ey,100,100);
        Rectangle enemyX3 = new Rectangle(enemy3, ey,100,100);

        if (player.intersects(enemyX1) || player.intersects(enemyX2) || player.intersects(enemyX3)) {
            time.stop();
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (x == 0) {
                x = 0;
            } else {
                x -= speed;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (x == 600) {
                x = 600;
            } else {
                x += speed;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            reset();
        }
    }

    private void reset() {
        ey = 10;
        enemy1 = r.nextInt(6)*100;
        enemy2 = r.nextInt(6)*100;
        x = 300;
        time.start();
        points = 0;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
