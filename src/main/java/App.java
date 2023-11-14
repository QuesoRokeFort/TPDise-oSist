import DTO.DireccionDTO;
import DTO.PersonaDTO;
import Interface.CargaPersonaInterface;
import Interface.DirreccionInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private DireccionDTO direccionDTO;
    private PersonaDTO personaDTO = new PersonaDTO();

    public static void main(String[] args) {
		/*Localidad localidad = new Localidad();
		localidad.setNombre("Santa Fe");
		localidad.setValorDeRiesgo(10);
		localidad.setProvincia(ProvinciaDao.getProvinciaById(1));
		LocalidadDao.saveLocalidad(localidad);*/
        //LocalidadDao.getLocalidades().forEach(l-> System.out.println(l.toString()));
		/*Direccion direccion =new Direccion();
		direccion.setCalle("pedro dias colodrero");
		direccion.setAltura(1645);
		direccion.setPiso("0");
		direccion.setDepto("no");
		direccion.setLocalidad(LocalidadDao.getLocalidadById(1));
		DireccionDao.saveDireccion(direccion);*/
        //DireccionDao.getDirecciones().forEach(d-> System.out.println(d.toString()));
		/*Usuario usuario = new Usuario();
		usuario.setClave("contra");
		usuario.setMail("exg@gmail.com");
		usuario.setRol(Rol.COBRADOR);
		System.out.println(usuario.toString());
		UsuarioDao.saveUsuario(usuario);*/
        //UsuarioDao.getUsuarios().forEach(u -> System.out.println(u.toString()));
		/*Persona persona = new Persona();
		persona.setApellido("Muller");
		persona.setDireccion(DireccionDao.getDireccionById(1));
		persona.setNombrePersona("Lucio");
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setFechaNac(new Date(99, 4, 4));
		persona.setSexo(Sexo.MASCULINO);
		persona.setProfesion(Profesion.PROGRAMADOR);
		persona.setUsuario(UsuarioDao.getUsuarioById(1));
		persona.setNroDocumento(41847630);
		persona.setTipoDocumento(TipoDocumento.DNI);
		PersonaDao.savePersona(persona);*/
        //PersonaDao.getAllPersonas().forEach(p->System.out.println(p.toString()));
        //ProvinciaDao.getProvinciasByPais(PaisDao.getPaisById(1)).forEach(p-> System.out.println(p.toString()));


        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new App();
        });
    }

    public App() {
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
                System.out.println(personaDTO.toString());
            }

        });

        // Set the initial panel to show
        cardLayout.show(cardPanel, "CargaPersonaPanel");

        frame.setContentPane(cardPanel);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
