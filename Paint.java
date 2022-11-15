import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Paint extends JComponent implements Runnable{
    
    Image image; // the canvas
    Graphics2D graphics2D;  // this will enable drawing
    int curX; // current mouse x coordinate
    int curY; // current mouse y coordinate
    int oldX; // previous mouse x coordinate
    int oldY; // previous mouse y coordinate
    JButton enterButton;
    JTextField hexText;
    JTextField rText;
    JTextField gText;
    JTextField bText;
    JButton clrButton;
    JButton fillButton;
    JButton eraseButton;
    JButton randomButton;
    JButton hexButton;
    JButton rgbButton;
    Paint paint;

    Color bgcolor;
    Color paintColor;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clrButton) {
                paint.clearCanvas();
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");
            }
            if (e.getSource() == fillButton) {
                paint.fillCanvas();
            }
            if (e.getSource() == eraseButton) {
                //graphics2D.setPaint(bgcolor);
                paint.eraseCanvas();
            }
            if (e.getSource() == randomButton) {
                int[] rgbValueArray = paint.randomCanvas();
                rText.setText(Integer.toString(rgbValueArray[0]));
                gText.setText(Integer.toString(rgbValueArray[1]));
                bText.setText(Integer.toString(rgbValueArray[2]));
                String currentHex = String.format("#%02x%02x%02x", rgbValueArray[0], rgbValueArray[1], rgbValueArray[2]);
                hexText.setText(currentHex);
            }

            if (e.getSource() == rgbButton) {
                if (rText.getText().equals("")) {
                    rText.setText("0");
                } else if (gText.getText().equals("")) {
                    gText.setText("0");
                } else if (bText.getText().equals("")) {
                    bText.setText("0");
                }

                try {
                    Color newColor = new Color(Integer.parseInt(rText.getText()), Integer.parseInt(gText.getText()), Integer.parseInt(bText.getText()));
                    paint.rgbButtonActions(newColor);
                    String currentHex = String.format("#%02x%02x%02x", newColor.getRed(), newColor.getGreen(), newColor.getBlue());
                    hexText.setText(currentHex);

                } catch (NumberFormatException b) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value", "Error", JOptionPane.ERROR_MESSAGE);
                }

                
            }

            if (e.getSource() == hexButton) {
                try {
                    Color color = Color.decode(hexText.getText());
                    paintColor = color;
                    graphics2D.setPaint(color);
                    repaint();
                    rText.setText(String.valueOf(color.getRed()));
                    gText.setText(String.valueOf(color.getGreen()));
                    bText.setText(String.valueOf(color.getBlue()));
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    };


    public void fillCanvas() {
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void rgbButtonActions(Color newColor) {
        paintColor = newColor;
        graphics2D.setPaint(newColor);
    }

    public void clearCanvas() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
        bgcolor = Color.white;
    }

    public void eraseCanvas() {
        graphics2D.setPaint(bgcolor);
        repaint();
    }

    public int[] randomCanvas() {
        Random random = new Random();
        int red = random.nextInt(0, 256);
        int green = random.nextInt(0, 256);
        int blue = random.nextInt(0, 256);
        Color rgbColor = new Color(red, green, blue);
        graphics2D.setPaint(rgbColor);
        repaint();
        paintColor = rgbColor;
        return new int[] {red, green, blue};
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            // this lets us draw on the image (ie. the canvas)
            graphics2D = (Graphics2D) image.getGraphics();

            // gives us better rendering quality for the drawing lines 
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                       RenderingHints.VALUE_ANTIALIAS_ON);

            graphics2D.setPaint(Color.white);
            bgcolor = Color.white;
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }


    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press*/
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where mouse is being dragged*/
                curX = e.getX();
                curY = e.getY();

                graphics2D.setStroke(new BasicStroke(5));

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        clrButton = new JButton("Clear");
        clrButton.addActionListener(actionListener);
        fillButton = new JButton("Fill");
        fillButton.addActionListener(actionListener);
        eraseButton = new JButton("Erase");
        eraseButton.addActionListener(actionListener);
        randomButton = new JButton("Random");
        randomButton.addActionListener(actionListener);

        hexText = new JTextField(10);
        rText = new JTextField(5);
        gText = new JTextField(5);
        bText = new JTextField(5);
        hexButton = new JButton("Hex");
        hexButton.addActionListener(actionListener);
        rgbButton = new JButton("RGB");
        rgbButton.addActionListener(actionListener);

        JPanel topPanel = new JPanel();
        topPanel.add(clrButton);
        topPanel.add(fillButton);
        topPanel.add(eraseButton);
        topPanel.add(randomButton);
        content.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(hexText);
        bottomPanel.add(hexButton);
        bottomPanel.add(rText);
        bottomPanel.add(gText);
        bottomPanel.add(bText);
        bottomPanel.add(rgbButton);
        content.add(bottomPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());
    }
}