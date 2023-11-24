package Interface;

import DTO.DireccionDTO;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;
import GestorPersonas.GestorPersona;
import Hibernate.Dao.UsuarioDao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GestorInterface {
	private static JFrame frame;
	static JPanel cardPanel;
	static CardLayout cardLayout;


	public static void panelCargaCliente() {
		frame = new JFrame("Carga de Persona");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardPanel = new JPanel();

		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		// Panel 1 (Assuming CargaPersonaInterface.panel1 is the first panel)
		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface();
		cardPanel.add(cargaPersonaInterface.getPanel1(), "CargaPersonaPanel");

		// Panel 2 (Assuming DirreccionInterface.getPanel1() returns the second panel)
		DirreccionInterface dirreccionInterface = new DirreccionInterface();
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
			PersonaDTO personaDTO = cargaPersonaInterface.getPersonaDTO();
			DireccionDTO direccionDTO = dirreccionInterface.getDireccionDTO();
			if (personaDTO != null) {
				personaDTO.addDirecion(direccionDTO);
				GestorPersona.crearCliente(personaDTO);
			}

		});

		// Set the initial panel to show
		cardLayout.show(cardPanel, "CargaPersonaPanel");

		frame.setContentPane(cardPanel);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

	public static void AccesoUsuario() {
		frame = new JFrame("Acceso Usuarios");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/imagenes/a.png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		frame.setContentPane(new JLabel(new ImageIcon(img)));

		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		AccesoUsuario accesoUsuario = new AccesoUsuario();
		cardPanel.add(accesoUsuario.getPanel1(), "AccesoUsuario");

		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface();
		cardPanel.add(cargaPersonaInterface.getPanel1(), "CargaPersonaPanel");


		accesoUsuario.confirmarMenu.addActionListener(e -> {
			UsuarioDTO usuario = accesoUsuario.getUsuario();
			if (usuario != null) {
				usuario = GestorPersona.logInUsuario(usuario);
				if (usuario != null) {
				}else{
					JOptionPane.showMessageDialog(null, "error cuenta o contraseña no valida");
				}
			}
			switch (usuario.getRol()){
				case GERENTE -> {
					MenuGerente menuGerente = new MenuGerente();
					cardPanel.add(menuGerente.getPanel3(),"MenuGerente");
					cardLayout.show(cardPanel,"MenuGerente");
					cardPanel.setPreferredSize(menuGerente.getPanel3().getPreferredSize());
				}
				case COBRADOR -> {
					MenuCobrador menuCobrador = new MenuCobrador();
					cardPanel.add(menuCobrador.getPanel2(),"MenuCobrador");
					cardLayout.show(cardPanel,"MenuCobrador");
					cardPanel.setPreferredSize(menuCobrador.getPanel2().getPreferredSize());
				}
				case PRODUCTOR_SEGURO -> {
					MenuProductorSeguros menuProductorSeguros = new MenuProductorSeguros();
					cardPanel.add(menuProductorSeguros.getPanel1(),"MenuProductorSeguro");
					cardLayout.show(cardPanel,"MenuProductorSeguro");
					cardPanel.setPreferredSize(menuProductorSeguros.getPanel1().getPreferredSize());
				}
			}
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		cardLayout.show(cardPanel, "AccesoUsuario");
		cardPanel.setPreferredSize(accesoUsuario.getPanel1().getPreferredSize());
		frame.add(cardPanel);
		frame.setVisible(true);
	}

}
