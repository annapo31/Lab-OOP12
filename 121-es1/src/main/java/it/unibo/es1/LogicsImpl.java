package it.unibo.es1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    //private static final String ERROR_MESSAGE = "Unimplemented method";
    private static final int INITIAL_STATE = 0;

    private final int size;
    private final List<Integer> list;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.add(INITIAL_STATE);
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
    public List<Integer> values() {
        return Collections.unmodifiableList(this.list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> state = new LinkedList<>();

        for (final Integer i : list) {
            state.add(i < this.size());
        }
        return state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        this.list.set(elem, this.list.get(elem) + 1);
        return this.list.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        String s = "";

        for (final Integer i : list) {
           s = s.concat(String.valueOf(i)).concat("|");
        }
        return s.substring(0, s.length() - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        /* Old code
        final int match = this.list.get(0);
        for (int i = 1; i < size; i++) {
            if (match != this.list.get(i)) {
                return false;
            }
        }
        return true;*/

        return this.list.stream()
            .allMatch(i -> i.equals(this.list.get(0)));
    }
}
