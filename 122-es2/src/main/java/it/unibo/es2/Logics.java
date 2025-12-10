package it.unibo.es2;

import java.util.List;

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
     * The current values for every slot.
     * 
     * @return ordered list of the integers in each slot
     */
    List<String> values();

    /**
     * Change the content of a certain button.
     *
     * @param buttonPosition the button to change
     * @return the new value a button should show after being pressed
     */
    String hit(Pair<Integer, Integer> buttonPosition);

    /**
     * True if it is time to quit (i.e., all slots in the same row or column 
     * have the same content).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
