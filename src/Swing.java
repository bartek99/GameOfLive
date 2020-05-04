import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

/**Class used to create a window and graphic display of game of live
 * @version 1.0
 * @author Bartosz Liszka
 * @see Grid
 */
public class Swing extends JFrame implements KeyListener {
    private int counter;
    private Grid grid;
    private List<int[][]> patterns = new LinkedList<int[][]>();
    private List<boolean[][]> isAlives = new LinkedList<boolean[][]>();

    /**Gives the window the title, size,
     * if user presses enter the patter will change to next from list patterns,
     * but if the list doesn't have next element the window will shut down,
     * if simulation of the pattern be finishes and user click X in the window, the window will be shut down.
     */
    public Swing() {
        counter = 0;
        grid = new Grid();
        grid.randomPattern();
        patterns.add(grid.getGrid());
        isAlives.add(grid.getIsAlive());
        grid = new Grid();
        grid.queenBeeShuttlePattern();
        patterns.add(grid.getGrid());
        isAlives.add(grid.getIsAlive());
        grid = new Grid();
        grid.tumblerPattern();
        patterns.add(grid.getGrid());
        isAlives.add(grid.getIsAlive());

        setTitle("Game of live");
        setSize(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height);
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**The method draw board, fill it according pattern
     * (if the cell is alive fill in red and if the cell is dead in white),
     * next method form class'Grid' "simulation" is called
     * and again cells which are alive fill in red and dead cells fill in white.
     */
    public void paint(Graphics g) {

        Insets b = getInsets();
        g.translate(b.left, b.top);
        g.setColor(Color.black);
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                g.drawRect(j * 15, i * 15, 15, 15);
            }
        }
        try {
            grid.setGrid(patterns.get(counter));
            grid.setIsAlive(isAlives.get(counter));
        }catch (Exception e){
            dispose();
        }
        int[][] tab = new int[grid.getHeight()][grid.getWidth()];
        tab = grid.getGrid();
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (tab[i][j] == 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * 15 + 1, i * 15 + 1, 14, 14);
                } else {
                    g.setColor(Color.red);
                    g.fillRect(j * 15 + 1, i * 15 + 1, 14, 14);
                }
            }
        }
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(1 / 30);
        } catch (Exception e) {
            e.printStackTrace();
        }


        for(int i2=0;i2<200;i2++){
            grid.simulation();
            tab = grid.getGrid();
            for (int i = 0; i < grid.getHeight(); i++) {
                for (int j = 0; j < grid.getWidth(); j++) {
                    if (tab[i][j] == 0) {
                        g.setColor(Color.white);
                        g.fillRect(j * 15 + 1, i * 15 + 1, 14, 14);
                    } else {
                        g.setColor(Color.red);
                        g.fillRect(j * 15 + 1, i * 15 + 1, 14, 14);
                    }
                }
            }

            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(1 / 30);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**This method do nothing, it's not defined*/
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**After press enter counter is inkremented and and method 'paint' works from the beginning*/
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            counter++;
        }
        repaint();
    }
    /**This method do nothing, it's not defined*/
    @Override
    public void keyReleased(KeyEvent e) {
    }
}