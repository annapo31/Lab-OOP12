package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private static final String BLANK_SPACE = " ";
    private static final String ASTERISK = "*";

    private final int size;
    private final List<String> selected = new ArrayList<>();
    
    public LogicsImpl(final int size, final int number) {
        this.size = size;

        for (int i = 0; i < size * size; i++ ) {
            this.selected.add(BLANK_SPACE);
        }
        selectRandomCells(number);
    }

    private void selectRandomCells(final int number) {
        final Random random = new Random();
        for (int i = 0; i < number; i++) {
            this.selected.set(random.nextInt(size) * size + random.nextInt(size), ASTERISK);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String getContent(final int x, final int y) {
        return this.selected.get(x * size + y);
    }

    @Override
    public boolean toQuit() {
        return !this.selected.contains(BLANK_SPACE);
    }

    public String toString() {
        return Collections.unmodifiableList(this.selected).toString();
    }

}
