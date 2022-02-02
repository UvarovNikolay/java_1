package lesson1_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private  int value;
    private JLabel infoLabel;
    private JPanel panelLeft;
    private JPanel panelRight;

    public CounterApp() {
        setBounds(500, 500, 400, 120);
        setTitle("Counter app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Шрифт
        Font font = new Font("Arial", Font.BOLD, 32);

        //Текстовое поле
        JLabel label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        //Добавление инфопанели
        //Будем показывать ошибку, если значение счетчика по модулю больше 10
        infoLabel = new JLabel();
        infoLabel.setForeground(Color.red);
        add(infoLabel, BorderLayout.NORTH);

        //Кнопки увеличения и уменьшения
        panelLeft = new JPanel();
        panelLeft.setLayout(new BorderLayout());
        add(panelLeft, BorderLayout.WEST);

        JButton decrementTenButton = new JButton("<<");
        decrementTenButton.setFont(font);
        panelLeft.add(decrementTenButton, BorderLayout.WEST);

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        panelLeft.add(decrementButton, BorderLayout.EAST);

        panelRight = new JPanel();
        panelRight.setLayout(new BorderLayout());
        add(panelRight, BorderLayout.EAST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        panelRight.add(incrementButton, BorderLayout.WEST);

        JButton incrementTenButton = new JButton(">>");
        incrementTenButton.setFont(font);
        panelRight.add(incrementTenButton, BorderLayout.EAST);

        decrementTenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value -= 10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementTenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value += 10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        setVisible(true);
    }

    private void validateRange() {
        if (Math.abs(value) > 100) {
            infoLabel.setText("Value out of range");
        } else {
            infoLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}