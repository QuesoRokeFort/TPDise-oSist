package Interface;


import DTO.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.management.LockInfo;


public class AccesoUsuario{
    private JPanel PantallaPrincipal;
    private JLabel idLogin;
    private JLabel idUsuario;
    private JTextField idUsuarioText;
    private JLabel idContraseña;
    private JTextField idContraseñaText;
    public JButton confirmarMenu;
    private JPanel idPanelLogin;
    private JPanel idPanelUsuario;

    private void createUIComponents() {
    }

    public AccesoUsuario() {
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

	public JPanel getPanel1() {
        return PantallaPrincipal;
	}

    public UsuarioDTO getUsuario() {
        String aviso = validateData();
        UsuarioDTO usuario = new UsuarioDTO();
        if(aviso.equals("Error en: ")) {
            usuario.setMail(idUsuarioText.getText());
            usuario.setClave(idContraseñaText.getText());
            return usuario;
        }
        else{
            JOptionPane.showMessageDialog(null,aviso);
        }
        return null;
    }

}
