package Interface;

import DTO.PersonaDTO;
import Hibernate.Model.*;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CargaPersonaInterface {
	private JPanel panel1;
	private JTextField TextoNombre;
	private JButton terminarButton;
	private JComboBox TipoDocumentoBOX;
	private JComboBox<Sexo> SexoBox = new JComboBox<>(Sexo.values());
	private JButton agregarDireccionButton;
	private JComboBox ProfesionBox;
	private JTextField TextoApellido;
	private JTextField Nro;
	private JTextField Texto_Fecha;
	private JTextField TextoEmail;
	private JComboBox EstadoCiviBox;

	/*public CargaPersonaInterface() {
		terminarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonaDTO personaDTO = new PersonaDTO();
				personaDTO.setNombrePersona(TextoNombre.getText());
				personaDTO.setApellido(TextoApellido.getText());
				String pattern = "yyyy-M-dd";
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat(pattern);
				Date fecha = null;
				try {
					fecha = formatoDelTexto.parse(Texto_Fecha.getText());
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				personaDTO.setFechaNac(fecha);
				personaDTO.setNroDocumento(Integer.valueOf(Nro.getText()));
				Usuario usuario = new Usuario();
				usuario.setMail(TextoEmail.getText());
				usuario.setRol(Rol.CLIENTE);
				personaDTO.setUsuario(usuario);
			}
		});
	}*/
	public CargaPersonaInterface() {

		terminarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validateData()) {
					PersonaDTO personaDTO = createPersonaDTO();
					System.out.println(personaDTO.toString());
					// Aquí puedes realizar acciones adicionales con el objeto personaDTO
				} else {
					JOptionPane.showMessageDialog(null, "Datos inválidos. Por favor, verifica la información ingresada.");
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
		personaDTO.setTipoDocumento((TipoDocumento) TipoDocumentoBOX.getSelectedItem());

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = dateFormat.parse(Texto_Fecha.getText());
			personaDTO.setFechaNac(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		personaDTO.setNroDocumento(Integer.valueOf(Nro.getText()));

		Usuario usuario = new Usuario();
		usuario.setMail(TextoEmail.getText());
		usuario.setRol(Rol.CLIENTE);
		personaDTO.setUsuario(usuario);

		return personaDTO;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Sexo.values()));
		JComboBox<Sexo> sexoJComboBox = new JComboBox<>(Sexo.values());
		JFrame jFrame = new JFrame("Carga de Persona");
		//jFrame.add(sexoJComboBox);
		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface();
		System.out.println(cargaPersonaInterface.SexoBox.getItemCount());
		jFrame.setContentPane(cargaPersonaInterface.panel1);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(500, 400);
		jFrame.setVisible(true);
	}
	private void createUIComponents() {
		SexoBox = new JComboBox<>(Sexo.values());
		EstadoCiviBox = new JComboBox<>(EstadoCivil.values());
		ProfesionBox = new JComboBox<>(Profesion.values());
		TipoDocumentoBOX = new JComboBox<>(TipoDocumento.values());
	}

	/*public static void main(String[] args) {
		JFrame jFrame = new JFrame("Carga de Persona");
		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface();

		jFrame.add(cargaPersonaInterface.panel1);

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400, 300);
		jFrame.setVisible(true);
	}*/

}
