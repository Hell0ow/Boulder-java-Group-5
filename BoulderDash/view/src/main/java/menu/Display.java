package menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Display extends JFrame{
    private static JFrame frame;
    private static Canvas canvas;
    private JLabel label;

    private String title;
    private static int width, height;

    private Toolkit tk;
    private Cursor cursor;
    private BufferedImage piocheImageCursor;
    /**
     * Instantiates a new Display.
     *
     * @param title  the title
     * @param width  the width
     * @param height the height
     * @throws IOException the io exception
     */

    public Display(String title, int width, int height) throws IOException {
        this.title = title;
        this.width = width;
        this.height = height;

        //cursor();
        createDisplay();
    }
    
    /**
     * Create display.
     */

    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));

        frame.add(canvas);
        frame.pack();
    }
    
     /**
     * Get canvas canvas.
     *
     * @return the canvas
     */

    public static Canvas getCanvas(){
        return canvas;
    }
    /**
     * Cursor.
     *
     * @throws IOException the io exception
     */

   /* public void cursor() throws IOException {                //marche pas, sûrement le cursor c'est pas enable, ou focus, chercher quoi
        tk = Toolkit.getDefaultToolkit();
        piocheImageCursor = ImageIO.read(new File("out/img/pioche.png"));
        cursor = tk.createCustomCursor(piocheImageCursor, new Point(1,1), "Pointeur");
        setCursor(cursor);
    }*/

/**
     * Gets widthframe.
     *
     * @return the widthframe
     */

    public static int getWidthframe() {
        return width;
    }
/**
     * Gets heightframe.
     *
     * @return the heightframe
     */

    public static int getHeightframe() {
        return height;
    }
    /**
     * Sets width.
     *
     * @param width the width
     */

    public static void setWidth(int width) {
        Display.width = width;
    } /**
     * Sets height.
     *
     * @param height the height
     */

    public static void setHeight(int height) {
        Display.height = height;
    }
/**
     * Gets frame.
     *
     * @return the frame
     */
    public static JFrame getFrame() {
        return frame;
    }




  /*  public static void Label(){
        label = new JLabel();

        label.setText(String.valueOf(Game.getTicks()));
        System.out.println();
        label.setAlignmentX(15);
        label.setAlignmentY(15);
        label.setSize(new Dimension(50, 50));
        label.setBackground(Color.blue);
        Display.getFrame().add(label);
    }*/
}
