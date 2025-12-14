package it.unibo.es3;

public interface Logics {

    /**
     * The number of rows (or colomns).
     *
     * @return the number of rows
     */
    int size();

    /**
     * Return the content of a certain cell
     * 
     * @param x row position
     * @param y colum position
     * @return the content of that cell
     */
    String getContent(int x, int y);

    /**
     * True if it is time to quit (i.e., all slots have *).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
