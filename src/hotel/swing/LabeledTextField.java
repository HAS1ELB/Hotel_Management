package hotel.swing;


import javax.swing.*;
import java.awt.*;

public class LabeledTextField extends JPanel {

    private JTextField textField;

    public LabeledTextField(String label, int col) {
        this(label, col, 0, false);
    }

    public LabeledTextField(String label, int col, int labelWidth) {
        this(label, col, labelWidth, false);
    }

    public LabeledTextField(String label, int col, int labelWidth, boolean isPasswordField) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(new JLabel(label));

        if (isPasswordField) {
            textField = new JPasswordField(col);
        } else {
            textField = new JTextField(col);
        }

        add(textField);

        if (labelWidth > 0) {
            ((JLabel) this.getComponent(0)).setPreferredSize(new Dimension(labelWidth, 60));
        }
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }
    public void setEditable(boolean editable) {
        textField.setEditable(editable);
    }
}