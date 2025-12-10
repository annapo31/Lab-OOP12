package it.unibo.es2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String ERROR_MESSAGE = "Unimplemented method";
    private static final String ASTERISK = "*";
    private static final String BLANCK_SPACE = " ";

    private final int size;
    private final List<String> list;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.list = new LinkedList<>();

        for (int i = 0; i < size * size; i++) {
            list.add(BLANCK_SPACE);
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
    public List<String> values() {
        return Collections.unmodifiableList(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String hit(final Pair<Integer, Integer> buttonPosition) {
        // Formula per calcolare posizione in matrice 2x2
        final Integer position = buttonPosition.x() * size + buttonPosition.y();

        final String newValue = BLANCK_SPACE.equals(this.list.get(position)) ? ASTERISK : BLANCK_SPACE;
        this.list.set(position, newValue);
        return newValue;
    }
    /* Codice vecchio che dava problemi:
        return this.list.set(position,
            BLANCK_SPACE.equals(this.list.get(position)) ? ASTERISK : BLANCK_SPACE);
        Errore: non ritornava l'elemento corretto alla gui, ma quello precedente,
        nella lista interna c'erano i valori giusti
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

}
