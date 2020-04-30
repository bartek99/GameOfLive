/**The interface has declared methods wihich represent rules for game of live
 * @version 1.0
 * @author Bartosz Liszka
 */
public interface Rules {
    /**{@inheritDoc}
     * Counts how many neighbors of cell in top-left corner has
     * @param i row's  number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int topLeftCorner(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in top-right corner has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int topRightCorner(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in bottom-left corner has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int bottomLeftCorner(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in bottom-right corner has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int bottomRightCorner(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in row 0 has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int row0(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in column 0 has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int column0(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in last row has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int lastRow(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell in last column has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int lastColumn(int i, int j, int counter);
    /**{@inheritDoc}
     * Counts how many neighbors of cell for other cells has
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public int otherCells(int i, int j, int counter);
    /**{@inheritDoc}
     * If alive cell has fewer than two live neighbors, the cell dies,
     * if live cell has two or three live neighbors, the cell lives on to the next generation,
     * if live cell has more than three live neighbors the cell dies,
     * if dead cell has exactly three live neighbors, it becomes a live cell
     * @param i row's number
     * @param j column number
     * @param counter counter of neighbours
     */
    public void rules(int i, int j, int counter);
}