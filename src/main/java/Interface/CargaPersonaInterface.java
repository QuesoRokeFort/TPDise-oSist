package Interface;

import DTO.DireccionDTO;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;
import Hibernate.Model.*;

import javax.swing.*;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CargaPersonaInterface {
    private JPanel panel1;
    private JTextField TextoNombre;
    public JButton terminarButton;
    private JComboBox TipoDocumentoBOX;
    private JComboBox<Sexo> SexoBox = new JComboBox<>(Sexo.values());
    public JButton agregarDireccionButton;
    private JComboBox ProfesionBox;
    private JTextField TextoApellido;
    private JTextField Nro;
    private JTextField Texto_Fecha;
    private JTextField TextoEmail;
    private JComboBox EstadoCiviBox;
    private JLabel TextoAviso;
    private PersonaDTO personaDTO;

    public CargaPersonaInterface() {
        TextoApellido.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextoApellido.getText().equals("ingrese aqui")) TextoApellido.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TextoApellido.getText().equals("")) {
                    TextoApellido.setText("ingrese aqui");
                }
            }
        });
        TextoNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if (TextoNombre.getText().equals("ingrese aqui")) TextoNombre.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TextoNombre.getText().equals("")) {
                    TextoNombre.setText("ingrese aqui");
                }
            }
        });
        TextoEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextoEmail.getText().equals("ingrese aqui")) TextoEmail.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TextoEmail.getText().equals("")) {
                    TextoEmail.setText("ingrese aqui");
                }
            }
        });
        Nro.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if (Nro.getText().equals("ingrese aqui")) Nro.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Nro.getText().equals("")) {
                    Nro.setText("ingrese aqui");
                }
            }
        });
        Texto_Fecha.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Texto_Fecha.getText().equals("YYYY-MM-DD")) Texto_Fecha.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Texto_Fecha.getText().equals("")) {
                    Texto_Fecha.setText("YYYY-MM-DD");
                }
            }
        });
    }

    private String validateData() {
        String aviso = "Error en:";
        if (TextoNombre.getText().equals("ingrese aqui")) {
            aviso += " Nombre, ";
        }
        if (TextoApellido.getText().equals("ingrese aqui")) {
            aviso += " Apellido, ";
        }
        if (TipoDocumentoBOX.getSelectedIndex() < 0) {
            aviso += " Tipo Documento, ";
        }
        if (Nro.getText().equals("ingrese aqui")) {
            aviso += " Numero Documento, ";
        }


        String patronFecha = "\\d{4}-\\d{2}-\\d{2}";

        Pattern pattern = Pattern.compile(patronFecha);

        String textoFecha = Texto_Fecha.getText();

        Matcher matcher = pattern.matcher(textoFecha);

        if (!matcher.matches()) {
            aviso += " Fecha, ";
        }
        if (TextoEmail.getText().equals("ingrese aqui")) {
            aviso += " Email, ";
        }
        if (EstadoCiviBox.getSelectedIndex() < 0) {
            aviso += " Estado Civil, ";
        }
        if (ProfesionBox.getSelectedIndex() < 0) {
            aviso += " Profesion, ";
        }

        // Realiza la validación de los datos aquí
        // Devuelve true si los datos son válidos, false en caso contrario
        return aviso; // Cambia esto según tus condiciones de validación
    }

    private PersonaDTO createPersonaDTO() {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombrePersona(TextoNombre.getText());
        personaDTO.setApellido(TextoApellido.getText());
        personaDTO.setSexo((Sexo) SexoBox.getSelectedItem());
        personaDTO.setProfesion((Profesion) ProfesionBox.getSelectedItem());
        personaDTO.setEstadoCivil((EstadoCivil) EstadoCiviBox.getSelectedItem());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = dateFormat.parse(Texto_Fecha.getText());
            personaDTO.setFechaNac(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (TipoDocumentoBOX.getSelectedItem().equals(TipoDocumento.DNI)) {
            personaDTO.setTipoDocumento((TipoDocumento) TipoDocumentoBOX.getSelectedItem());
            personaDTO.setNroDocumento(Integer.valueOf(Nro.getText()));
        } else {
            personaDTO.setTipoDocumento((TipoDocumento) TipoDocumentoBOX.getSelectedItem());
            personaDTO.setNroCuil(Integer.valueOf(Nro.getText()));
        }

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setMail(TextoEmail.getText());
        usuario.setPersona(personaDTO);
        personaDTO.setUsuario(usuario);
        return personaDTO;
    }


    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
        SexoBox = new JComboBox<>(Sexo.values());
        SexoBox.setSelectedIndex(-1);
        EstadoCiviBox = new JComboBox<>(EstadoCivil.values());
        EstadoCiviBox.setSelectedIndex(-1);
        ProfesionBox = new JComboBox<>(Profesion.values());
        ProfesionBox.setSelectedIndex(-1);
        TipoDocumentoBOX = new JComboBox<>(TipoDocumento.values());
        TipoDocumentoBOX.setSelectedIndex(-1);
    }


    public PersonaDTO getPersonaDTO() {
        String aviso = validateData();
        if (aviso.equals("Error en:")) {
            return personaDTO = createPersonaDTO();
            // Aquí puedes realizar acciones adicionales con el objeto personaDTO
        } else {
            JOptionPane.showMessageDialog(null, aviso);
        }
        return null;
    }
}
