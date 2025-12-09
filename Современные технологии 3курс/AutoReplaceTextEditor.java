import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class AutoReplaceTextEditor extends JFrame {
    private JTextArea textArea;
    private Map<String, String> replacements;
    private volatile boolean spacePressed = false;

    public AutoReplaceTextEditor() {
        setTitle("Текстовый редактор с автозаменой");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        replacements = new HashMap<>();
        replacements.put("teh", "the"); // пример замены
        replacements.put("recieve", "receive");

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == ' ' || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spacePressed = true;
                }
            }
        });

        Thread worker = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }

                if (spacePressed) {
                    spacePressed = false;
                    SwingUtilities.invokeLater(this::processAutoReplace);
                }
            }
        });

        worker.setDaemon(true);
        worker.start();
    }

    private void processAutoReplace() {
        String text = textArea.getText();
        int caretPos = textArea.getCaretPosition();

        String[] words = text.split("\\b");
        StringBuilder newText = new StringBuilder();

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (replacements.containsKey(lowerWord)) {
                newText.append(replacements.get(lowerWord));
            } else {
                newText.append(word);
            }
        }

        textArea.setText(newText.toString());
        textArea.setCaretPosition(Math.min(caretPos, newText.length()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AutoReplaceTextEditor editor = new AutoReplaceTextEditor();
            editor.setVisible(true);
        });
    }
}
