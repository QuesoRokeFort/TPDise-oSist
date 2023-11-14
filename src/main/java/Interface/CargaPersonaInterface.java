package Interface;

import DTO.DireccionDTO;
import DTO.PersonaDTO;
import Hibernate.Model.*;

import javax.swing.*;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

	public CargaPersonaInterface(JFrame frame) {
		TextoApellido.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				TextoApellido.setText("");
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
				TextoNombre.setText("");
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
				TextoEmail.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(TextoEmail.getText().equals("")){
					TextoEmail.setText("ingrese aqui");
				}
			}
		});
		Nro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Nro.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(Nro.getText().equals("")){
					Nro.setText("ingrese aqui");
				}
			}
		});
		Texto_Fecha.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				Texto_Fecha.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(Texto_Fecha.getText().equals("")){
					Texto_Fecha.setText("YYYY-MM-DD");
				}
			}
		});
	}

	private boolean validateData() {
		// Realiza la validación de los datos aquí
		// Devuelve true si los datos son válidos, false en caso contrario
		return true; // Cambia esto según tus condiciones de validación
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
		if(TipoDocumentoBOX.getSelectedItem().equals(TipoDocumento.DNI)) {
			personaDTO.setTipoDocumento((TipoDocumento) TipoDocumentoBOX.getSelectedItem());
			personaDTO.setNroDocumento(Integer.valueOf(Nro.getText()));
		}else{
			personaDTO.setTipoDocumento((TipoDocumento) TipoDocumentoBOX.getSelectedItem());
			personaDTO.setNroCuil(Integer.valueOf(Nro.getText()));
		}

		Usuario usuario = new Usuario();
		usuario.setMail(TextoEmail.getText());
		usuario.setRol(Rol.CLIENTE);
		personaDTO.setUsuario(usuario);
		return personaDTO;
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Carga de Persona");
		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface(jFrame);
		jFrame.setContentPane(cargaPersonaInterface.panel1);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(500, 400);
		jFrame.setVisible(true);
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
		if (validateData()) {
			return personaDTO=createPersonaDTO();
			// Aquí puedes realizar acciones adicionales con el objeto personaDTO
		} else {
			JOptionPane.showMessageDialog(null, "Datos inválidos. Por favor, verifica la información ingresada.");
		}
		return null;
	}
}
