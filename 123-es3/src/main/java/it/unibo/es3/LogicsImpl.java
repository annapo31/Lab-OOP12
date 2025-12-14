package it.unibo.es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String BLANK_SPACE = " ";
    private static final String ASTERISK = "*";
    private static final Random RANDOM = new Random();

    private final int size;
    private final Map<Pair<Integer, Integer>, String> selected = new HashMap<>();

    /**
     * Constructor.
     * 
     * @param size size of the grid
     * @param number number of asterisk
     */
    public LogicsImpl(final int size, final int number) {
        this.size = size;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                selected.put(new Pair<>(i, j), BLANK_SPACE);
            }
        }
        selectRandomCells(number);
    }

    private void selectRandomCells(final int number) {
        for (int i = 0; i < number; i++) {
            this.selected.put(new Pair<>(RANDOM.nextInt(size), RANDOM.nextInt(size)), ASTERISK);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getContent(final Pair<Integer, Integer> pos) {
        return this.selected.get(pos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hit() {
        // We need to make a defensive copy
        final Map<Pair<Integer, Integer>, String> copy = new HashMap<>(this.selected);
 
        copy.entrySet().stream()
            .filter(elem -> BLANK_SPACE.equals(elem.getValue())
                        && copy.entrySet().stream().anyMatch(other ->
                            ASTERISK.equals(other.getValue())
                            && neighbours(elem.getKey().x(), elem.getKey().y(), other.getKey().x(), other.getKey().y())
                        ))
            .forEach(elem -> this.selected.put(elem.getKey(), ASTERISK));
    }

    // Code from a06, es 2 exam 2021
    private boolean neighbours(final int x1, final int y1, final int x2, final int y2) {
        return Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return !this.selected.containsValue(BLANK_SPACE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final var list = this.selected.entrySet().stream()
            .map(Map.Entry::getValue)
            .toList();
        return list.toString();
    }

}
