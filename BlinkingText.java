import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BlinkingText extends JFrame {
    private JLabel label;
    private boolean isBlinking = true;
    public BlinkingText() {
        setTitle("Blinking Text");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Blinking Text", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
        // Create a thread to handle blinking
        Thread blinkThread = new Thread(new BlinkingTask());
        blinkThread.start();
        setVisible(true);
    }
    private class BlinkingTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    if (isBlinking) {
                        label.setVisible(false);
                        Thread.sleep(500); // Adjust blinking speed here (milliseconds)
                        label.setVisible(true);
                        Thread.sleep(500); // Adjust blinking speed here (milliseconds)
                    } else {
                        Thread.sleep(100); // Sleep when not blinking
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlinkingText());
    }
}
