import javax.swing.*; 
import java.awt.*; 

public class SimplePaint extends JComponent implements Runnable{

    Image image; // the canvas
    Graphics2D graphics2D;  // this will enable drawing
    int curX; // current mouse x coordinate
    int curY; // current mouse y coordinate
    int oldX; // previous mouse x coordinate
    int oldY; // previous mouse y coordinate

    JButton enterButton; // button to enter information
    JTextField strTextField; // text field for input

    SimplePaint paint; // variable of the type SimplePaint

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            // this lets us draw on the image (ie. the canvas)
            graphics2D = (Graphics2D) image.getGraphics();

            // gives us better rendering quality for the drawing lines 
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                       RenderingHints.VALUE_ANTIALIAS_ON);

            // set canvas to white with default paint color 
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
}


    public void run() {
        JFrame frame = new JFrame("Simple Paint Walkthrough");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new SimplePaint();
        content.add(paint, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimplePaint());
    }
}