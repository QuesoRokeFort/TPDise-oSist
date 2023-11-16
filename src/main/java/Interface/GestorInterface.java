package Interface;

import DTO.DireccionDTO;
import DTO.PersonaDTO;
import GestorPersonas.GestorPersona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorInterface {
	private static JFrame frame;
	private static JPanel cardPanel;
	private static CardLayout cardLayout;
	private static PersonaDTO personaDTO;
	private static DireccionDTO direccionDTO;

	public static void panelCargaCliente(){
		frame = new JFrame("Carga de Persona");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardPanel = new JPanel();

		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		// Panel 1 (Assuming CargaPersonaInterface.panel1 is the first panel)
		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface(frame);
		cardPanel.add(cargaPersonaInterface.getPanel1(), "CargaPersonaPanel");

		// Panel 2 (Assuming DirreccionInterface.getPanel1() returns the second panel)
		DirreccionInterface dirreccionInterface = new DirreccionInterface(frame);
		cardPanel.add(dirreccionInterface.getPanel1(), "DirreccionPanel");

		// Set up button action in the first panel to switch to the second panel
		cargaPersonaInterface.agregarDireccionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "DirreccionPanel");
			}
		});

		// Set up button action in the second panel to switch back to the first panel
		dirreccionInterface.doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "CargaPersonaPanel");
			}
		});
		cargaPersonaInterface.terminarButton.addActionListener(e -> {
			personaDTO = cargaPersonaInterface.getPersonaDTO();
			direccionDTO = dirreccionInterface.getDireccionDTO();
			if (personaDTO != null) {
				personaDTO.setDireccion(direccionDTO);
				GestorPersona.crearCliente(personaDTO);
			}

		});

		// Set the initial panel to show
		cardLayout.show(cardPanel, "CargaPersonaPanel");

		frame.setContentPane(cardPanel);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
