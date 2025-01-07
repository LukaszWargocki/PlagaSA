import javax.swing.*;

public class ErrorMessage {
    // TODO: add print stack trace and error message arguments
    public ErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
