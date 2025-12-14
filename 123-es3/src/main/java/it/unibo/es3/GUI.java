package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.logics = new LogicsImpl(width, 3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        // Create button >
        final JButton specialButton = new JButton(">");
        this.getContentPane().add(BorderLayout.SOUTH, specialButton);
        specialButton.addActionListener(e -> {
            System.out.println(logics.toString());
            if (logics.toQuit()) {
                this.dispose();
            }
        });

        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(logics.getContent(pos.x(), pos.y()));
                this.cells.add(button);
                /*button.addActionListener(e -> {
                    button.setText(String.valueOf(cells.indexOf(button)));
                });*/
                panel.add(button);
            }
        }
        pack();
        this.setVisible(true);
    }
}
