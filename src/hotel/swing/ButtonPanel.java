package hotel.swing;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private JButton[] buttons;

    public ButtonPanel(String[] labels) {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons = new JButton[labels.length];

        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            add(buttons[i]);
        }
    }

}

