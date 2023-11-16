package Interface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class AccesoUsuario extends JFrame{
    private JPanel PantallaPrincipal;
    private JPanel Borde;
    private JPanel Login;
    private JLabel idLogin;
    private JLabel idUsuario;
    private JTextField idUsuarioText;
    private JLabel idContraseña;
    private JTextField idContraseñaText;
    private JButton confirmarMenu;
    private JPanel idPanelLogin;
    private JPanel idPanelUsuario;
    private JPanel idPanelContraseña;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public AccesoUsuario() {
        //  SetImageLabel(Dibujo, "/java/images/auto.jpg");
        setContentPane(PantallaPrincipal);
        setTitle("Menu");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        confirmarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aviso = validateData();
                if(aviso.equals("Error en: ")) {
                    String usuario = idUsuarioText.getText();
                    JOptionPane.showMessageDialog(AccesoUsuario.this, "Bienvenido " + usuario);
                }
                else{
                    JOptionPane.showMessageDialog(AccesoUsuario.this,aviso);
                }
            }
        });
        idUsuarioText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if (idUsuarioText.getText().equals("Escriba su Usuario...")) idUsuarioText.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idUsuarioText.getText().equals("")) {
                    idUsuarioText.setText("Escriba su Usuario...");
                }
            }
        });
        idContraseñaText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if (idContraseñaText.getText().equals("Escriba su Contraseña...")) idContraseñaText.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idContraseñaText.getText().equals("")) {
                    idContraseñaText.setText("Escriba su Contraseña...");
                }
            }
        });
    }
    public static void main(String[] args) {
        new AccesoUsuario();
    }
    private String validateData() {
        String aviso = "Error en: ";
        if (idUsuarioText.getText().equals("Escriba su Usuario...")) {
            aviso += " Usuario, ";
        }
        if (idContraseñaText.getText().equals("Escriba su Contraseña...")) {
            aviso += " Contraseña. ";
        }
    return aviso;
    }
    //private void SetImageLabel(JLabel labelName, String root){
    //  ImageIcon image = new ImageIcon(root);
    //  Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(), Image.SCALE_DEFAULT));
    //  labelName.setIcon(icon);
    //  this.repaint();
    //}
}
