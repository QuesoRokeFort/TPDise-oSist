package Interface;


import DTO.UsuarioDTO;
import GestorPersonas.GestorPersona;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GestorInterface {
	private static JFrame frame;
	static JPanel cardPanel;
	static CardLayout cardLayout;
	private static AccesoUsuario accesoUsuario;
	//private static JComponent emptyCard;


	public static void AccesoUsuario() {
		frame = new JFrame("Acceso Usuarios");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage img;
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
		accesoUsuario = new AccesoUsuario();
		cardPanel.add(accesoUsuario.getPanel1(), "AccesoUsuario");

		CargaPersonaInterface cargaPersonaInterface = new CargaPersonaInterface();
		cardPanel.add(cargaPersonaInterface.getPanel1(), "CargaPersonaPanel");


		accesoUsuario.confirmarMenu.addActionListener(e -> {
			UsuarioDTO usuario = accesoUsuario.getUsuario();
			if (usuario != null) {
				usuario = GestorPersona.logInUsuario(usuario);
				if (usuario != null) {
					JOptionPane.showMessageDialog(null, usuario.getRol());
				}else{
					JOptionPane.showMessageDialog(null, "error cuenta o contraseña no valida");
				}
			}
			switch (usuario.getRol()) {
				case GERENTE -> {
					MenuGerente menuGerente = new MenuGerente();
					cardPanel.add(menuGerente.getPanel3(), "MenuGerente");
					cardLayout.show(cardPanel, "MenuGerente");
					cardPanel.setPreferredSize(menuGerente.getPanel3().getPreferredSize());
					configurarCerrarSeccion(menuGerente);
				}
				case COBRADOR -> {
					MenuCobrador menuCobrador = new MenuCobrador();
					cardPanel.add(menuCobrador.getPanel2(), "MenuCobrador");
					cardLayout.show(cardPanel, "MenuCobrador");
					cardPanel.setPreferredSize(menuCobrador.getPanel2().getPreferredSize());
					configurarCerrarSeccion(menuCobrador);
				}
				case PRODUCTOR_SEGURO -> {
					MenuProductorSeguros menuProductorSeguros = new MenuProductorSeguros();
					cardPanel.add(menuProductorSeguros.getPanel1(), "MenuProductorSeguro");
					cardLayout.show(cardPanel, "MenuProductorSeguro");
					cardPanel.setPreferredSize(menuProductorSeguros.getPanel1().getPreferredSize());
					configurarCerrarSeccion(menuProductorSeguros);
				}
			}
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		MenuAccerso();
		frame.add(cardPanel);
		frame.setVisible(true);
	}

	private static void configurarCerrarSeccion(Object instance) {
		switch (instance.getClass().getSimpleName()) {
			case "MenuCobrador":
				MenuCobrador cobrador = (MenuCobrador) instance;
				cobrador.getCerrarSesionButton().addActionListener(e -> MenuAccerso());
				break;

			case "MenuGerente":
				MenuGerente gerente = (MenuGerente) instance;
				gerente.getCerrarSesionButton().addActionListener(e -> MenuAccerso());
				break;

			case "MenuProductorSeguros":
				MenuProductorSeguros productor = (MenuProductorSeguros) instance;
				productor.getCerrarSesionButton().addActionListener(e -> MenuAccerso());
				break;

			default:
				// Handle the case where the provided instance is not of the expected type.
				break;
		}
	}
	private static void MenuAccerso() {
		cardLayout.show(cardPanel, "AccesoUsuario");
		cardPanel.setPreferredSize(accesoUsuario.getPanel1().getPreferredSize());
	}
	/*private static void emptyLayout(){
		cardLayout.show(cardPanel, "EmptyCard");
		cardPanel.setPreferredSize(emptyCard.getPreferredSize());
	}*/

}

