import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    public Layout() {
        super("Пример менеджеров компоновки");

        // Устанавливаем менеджер компоновки окна (JFrame)
        setLayout(new BorderLayout());

        // Создаём панель с FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Кнопка 1"));
        flowPanel.add(new JButton("Кнопка 2"));
        flowPanel.add(new JButton("Кнопка 3"));

        // Добавляем панель в центр окна
        add(flowPanel, BorderLayout.CENTER);

        // Добавляем другую кнопку в северную часть окна JFrame
        add(new JButton("Север"), BorderLayout.NORTH);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Центрируем окно
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Layout().setVisible(true);
        });
    }
}
