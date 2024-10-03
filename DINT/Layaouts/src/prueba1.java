import javax.swing.*;

public class prueba1 {
    private javax.swing.JPanel JPanel;
    private JButton button1;
    private JButton button2;


    public static void main(String[] args) {
        // Crear el JFrame y añadir el panel principal generado
        JFrame frame = new JFrame("Mi Aplicación Swing");
        frame.setContentPane(new prueba1().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
