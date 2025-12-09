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
        /*  SISTEMA
        String s = "";

        for (final Integer i : list) {
            s = s.concat(String.valueOf(i)).concat("|");
        }


        this.list.stream()
            .forEach(i -> s = s.concat(String.valueOf(i)).concat("|"));
    */
        return this.list.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return !this.enabledStates().contains(true);
    }
}
