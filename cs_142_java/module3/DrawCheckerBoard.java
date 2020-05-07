import java.awt.*;
import javax.swing.*;

public class DrawCheckerBoard {
    
	//Draw a checkerboard.
	public static void drawCheckerBoard(Graphics g, int width, int height) {
        //Background color
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, width, height);

        //Checker square size
        int squareWidth = width / 8;
        int squareHeight = height / 8;

        //Drawing the board
        for (int j = 0; j < height / squareHeight; j++) {
            for (int i = 0; i <  width / squareWidth; i += 2) {
                    g.setColor(Color.lightGray);
                    g.fillRect(i * squareWidth, j * squareHeight, squareWidth, squareHeight);
                }
            }
        }
    // Leave the main method alone! It just sets up the drawing window for you. This is the framework.
    public static void main(String[] args) {
        JFrame window = new JFrame("Graphics window");
        window.setLocationByPlatform(true);
        @SuppressWarnings("serial")
        final JPanel panel = new JPanel() {
            protected void paintComponent(Graphics gx) {
                Graphics2D g = (Graphics2D) gx;
                //int width = getWidth(), height = getHeight();
                int width=600;
                int height=600;
                g.clearRect(0, 0, width, height);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setBackground(Color.WHITE);
                g.setColor(Color.BLACK);
                
                drawCheckerBoard(g, width, height);
            }
        };
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(d.width / 2, d.height / 2);
        window.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        window.setContentPane(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
