package a;

import javax.swing.*;

public class MainWindow {
    public static void main(String[] args) {
        // Crear un nuevo JFrame (ventana)
        JFrame frame = new JFrame("Mi Ventana Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Establecer tamaño de la ventana

        // Agregar un botón de ejemplo
        JButton button = new JButton("Hacer clic");
        frame.getContentPane().add(button);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private static void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Usuario:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(10, 80, 150, 25);
        panel.add(loginButton);
    }
}
