package it.unibo.es3;

/**
 * Interface defining the logic for a slot-based application.
 */
public interface Logics {

    /**
     * The number of rows (or colomns).
     *
     * @return the number of rows
     */
    int size();

    /**
     * Return the content of a certain cell.
     * 
     * @param pos position of the cell
     * @return the content of that cell
     */
    String getContent(Pair<Integer, Integer> pos);

    /**
     * Modify the list to expand *.
     * 
     */
    void hit();

    /**
     * True if it is time to quit (i.e., all slots have *).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
