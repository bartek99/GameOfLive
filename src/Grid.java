
import java.util.Random;

/**Class is responsible for working of algorithm 'game of live'
 * @version 1.0
 * @author Bartosz Liszka
 * @see Patterns
 * @see Rules
 */
public class Grid implements Patterns, Rules {
    private final int width;
    private final int height;
    private int[][] grid;
    private boolean[][] isAlive;

    /**Create 2 two-dimensional array and attribute them value 0(or false)*/
    public Grid() {
        width = 50;
        height = 50;
        grid = new int[height][width];
        isAlive=new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = 0;
                isAlive[i][j]=false;
            }
        }
    }

    /**Getter of width
     * @return number of width
     */
    public int getWidth() {
        return width;
    }
    /**Getter of height
     * @return number of height
     */
    public int getHeight() {
        return height;
    }
    /**Getter of grid
     * @return array 'grid'
     */
    public int[][] getGrid() {
        return grid;
    }
    /**Getter of isAlive
     * @return array 'isAlive'
     */
    public boolean[][] getIsAlive() {
        return isAlive;
    }

    /**Setter of grid
     * @param grid new array
     */
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    /**Setter of isAlive
     * @param isAlive new array
     */
    public void setIsAlive(boolean[][] isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public void randomPattern() {
        Random random = new Random();
        int counter = 0;
        int x = 0;
        int y = 0;
        int alive = width * height / 2;
        while (counter != alive) {
            x = random.nextInt(50);
            y = random.nextInt(50);
            if (!isAlive[x][y]) {
                grid[x][y] = 1;
                isAlive[x][y] = true;
                counter++;
            }
        }
    }
    @Override
    public void queenBeeShuttlePattern(){
        grid[21][23]=1;
        grid[21][24]=1;
        grid[22][25]=1;
        grid[23][26]=1;
        grid[24][26]=1;
        grid[25][26]=1;
        grid[26][25]=1;
        grid[27][24]=1;
        grid[27][23]=1;
        isAlive[21][23]=true;
        isAlive[21][24]=true;
        isAlive[22][25]=true;
        isAlive[23][26]=true;
        isAlive[24][26]=true;
        isAlive[25][26]=true;
        isAlive[26][25]=true;
        isAlive[27][24]=true;
        isAlive[27][23]=true;
    }

    @Override
    public void tumblerPattern() {
      grid[22][22]=1;
      grid[22][23]=1;
      grid[22][25]=1;
      grid[22][26]=1;
      grid[23][22]=1;
      grid[23][23]=1;
      grid[23][25]=1;
      grid[23][26]=1;
      grid[24][23]=1;
      grid[24][25]=1;
      grid[25][21]=1;
      grid[25][23]=1;
      grid[25][25]=1;
      grid[25][27]=1;
      grid[26][21]=1;
      grid[26][23]=1;
      grid[26][25]=1;
      grid[26][27]=1;
      grid[27][21]=1;
      grid[27][22]=1;
      grid[27][26]=1;
      grid[27][27]=1;

    }

    /**@return number of neighbors
     */
    @Override
    public int topLeftCorner(int i, int j, int counter){
        if (isAlive[i][j + 1]) {
            counter++;
        }
        if (isAlive[i + 1][j]) {
            counter++;
        }
        if (isAlive[i + 1][j + 1]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int topRightCorner(int i, int j, int counter){
        if (isAlive[i][j - 1] ) {
            counter++;
        }
        if (isAlive[i + 1][j - 1] ) {
            counter++;
        }
        if (isAlive[i + 1][j]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int bottomLeftCorner(int i, int j, int counter){
        if (isAlive[i - 1][j]) {
            counter++;
        }
        if (isAlive[i - 1][j + 1]) {
            counter++;
        }
        if (isAlive[i][j + 1]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int bottomRightCorner(int i, int j, int counter){
        if (isAlive[i - 1][j]) {
            counter++;
        }
        if (isAlive[i - 1][j - 1]) {
            counter++;
        }
        if (isAlive[i][j - 1] ) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int row0(int i, int j, int counter){
        if (isAlive[i][j - 1]) {
            counter++;
        }
        if (isAlive[i + 1][j-1]) {
            counter++;
        }
        if (isAlive[i + 1][j]) {
            counter++;
        }
        if (isAlive[i + 1][j + 1]) {
            counter++;
        }
        if (isAlive[i][j + 1]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int column0(int i, int j, int counter){
        if (isAlive[i - 1][j]) {
            counter++;
        }
        if (isAlive[i - 1][j + 1]) {
            counter++;
        }
        if (isAlive[i][j + 1]) {
            counter++;
        }
        if (isAlive[i + 1][j + 1]) {
            counter++;
        }
        if (isAlive[i + 1][j]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int lastRow(int i, int j, int counter){
        if (isAlive[i][j - 1]) {
            counter++;
        }
        if (isAlive[i - 1][j - 1]) {
            counter++;
        }
        if (isAlive[i - 1][j]) {
            counter++;
        }
        if (isAlive[i - 1][j + 1]) {
            counter++;
        }
        if (isAlive[i][j + 1]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int lastColumn(int i, int j, int counter){
        if (isAlive[i - 1][j]) {
            counter++;
        }
        if (isAlive[i - 1][j - 1]) {
            counter++;
        }
        if (isAlive[i][j - 1]) {
            counter++;
        }
        if (isAlive[i + 1][j - 1]) {
            counter++;
        }
        if (isAlive[i + 1][j]) {
            counter++;
        }
        return counter;
    }
    /**@return number of neighbors
     */
    @Override
    public int otherCells(int i, int j, int counter){
        if (isAlive[i][j - 1]) {
            counter++;
        }
        if (isAlive[i - 1][j - 1]) {
            counter++;
        }
        if (isAlive[i - 1][j]) {
            counter++;
        }
        if (isAlive[i - 1][j + 1]) {
            counter++;
        }
        if (isAlive[i][j + 1]) {
            counter++;
        }
        if (isAlive[i + 1][j + 1]) {
            counter++;
        }
        if (isAlive[i + 1][j]) {
            counter++;
        }
        if (isAlive[i + 1][j - 1]) {
            counter++;
        }
        return counter;
    }

    @Override
    public void rules(int i, int j, int counter){
        if (counter < 2 && isAlive[i][j]) {
            grid[i][j] = 0;
        }
        else if (counter == 3 && !isAlive[i][j]) {
            grid[i][j] = 1;
        }
        else if (counter > 3 && isAlive[i][j]) {
            grid[i][j] = 0;
        }
    }


    /**Method which is responsible of working algorith "game of live"*/
    public void simulation() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int counter = 0;
                if (i == 0 && j == 0) {
                   counter=topLeftCorner(i,j,counter);
                    rules(i,j,counter);
                }
                else if (i == 0 && j == width - 1) {
                    counter=topRightCorner(i,j,counter);
                    rules(i,j,counter);
                }
                else if (i == height - 1 && j == 0) {
                    counter=bottomLeftCorner(i, j,counter);
                    rules(i,j,counter);
                }
                else if (i == height - 1 && j == width - 1) {
                    counter=bottomRightCorner(i,j,counter);
                    rules(i,j,counter);
                }
                else if (i == 0) {
                    counter=row0(i,j,counter);
                    rules(i,j,counter);
                }
                else if (j == 0) {
                    counter=column0(i,j,counter);
                    rules(i,j,counter);
                }
                else if (i == height - 1) {
                    counter=lastRow(i, j, counter);
                    rules(i,j,counter);
                }
                else if (j == width - 1) {
                    counter=lastColumn(i,j,counter);
                    rules(i,j,counter);
                }
                else {
                    counter=otherCells(i,j,counter);
                    rules(i,j,counter);
                }
            }
        }
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j]==1){
                    isAlive[i][j]=true;
                }
                else{
                    isAlive[i][j]=false;
                }
            }
        }
    }
}