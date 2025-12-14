package it.unibo.es2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The GUI class representing the graphical user interface of the application.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<JButton, Pair<Integer, Integer>> buttons = new LinkedHashMap<>();
    private final transient Logics logics;
    // Transient is compulsory, otherwise there'll be a problem
    // because of serialization.
    // Classe GUI è serializzabile ma contiene logic che non è serializzabile

    /**
     * Constructs a GUI with the specified size.
     *
     * @param size the size of the grid
     */
    public GUI(final int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);
        // Layout
        final var panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(BorderLayout.CENTER, panel);
        // Buttons
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Initially every button has a blanck space
                final JButton button = new JButton(" ");
                final Pair<Integer, Integer> buttonPosition = new Pair<>(i, j);
                this.buttons.put(button, buttonPosition);

                // Change of the content of the button
                button.addActionListener(elem -> {
                        button.setText(logics.hit(buttonPosition));
                        //System.out.println(logics.values().toString());
                        if (logics.toQuit()) {
                            this.dispose();
                        }
                    }
                );
                panel.add(button);
            }
        }
        this.setVisible(true);
    }
}
