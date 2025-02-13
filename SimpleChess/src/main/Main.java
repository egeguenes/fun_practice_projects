/*
* A Simple Chess project from RyiSnow channel on YouTube, to learn and understand the Java better and improve my skills
* https://www.youtube.com/watch?v=jzCxywhTAUI
*/

package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack(); // adjusts the size to the game panel

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();
    }
}
