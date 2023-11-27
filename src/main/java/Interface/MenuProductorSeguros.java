package Interface;

import DTO.DireccionDTO;
import DTO.PersonaDTO;
import DTO.PolizaDTO;
import Gestores.GestorPersona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static Interface.GestorInterface.cardLayout;
import static Interface.GestorInterface.cardPanel;

public class MenuProductorSeguros {
    private JPanel PantallaPrincipal;
    public JButton darDeAltaPolizaButton;
    public JButton darDeAltaClienteButton;
    public JButton consultarPólizaButton;
    public JButton consultarClienteButton;
    public JButton generarPropuestaRenovaciónButton;
    public JButton actualizarFactoresButton;
    private JButton cerrarSesionButton;
    private JLabel idMenu;
    private JPanel idPanelMenu;
    static PersonaDTO currentPersona;
    static PolizaDTO currentPoliza;




    public MenuProductorSeguros() {
        darDeAltaClienteButton.addActionListener(altaCliente -> {
            altaCliente();
        });
        darDeAltaPolizaButton.addActionListener(altaPoliza -> {
            altaPoliza();
        });

    }
    private void altaCliente(){
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
                cardPanel.setPreferredSize(dirreccionInterface.getPanel1().getPreferredSize());
            }
        });

        // Set up button action in the second panel to switch back to the first panel
        dirreccionInterface.doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "CargaPersonaPanel");
                cardPanel.setPreferredSize(cargaPersonaInterface.getPanel1().getPreferredSize());
            }
        });
        cargaPersonaInterface.terminarButton.addActionListener(e -> {
            PersonaDTO personaDTO = cargaPersonaInterface.getPersonaDTO();
            DireccionDTO direccionDTO = dirreccionInterface.getDireccionDTO();
            if (personaDTO != null) {
                personaDTO.addDirecion(direccionDTO);
                GestorPersona.crearCliente(personaDTO);
                cardLayout.show(cardPanel,"MenuProductorSeguro");
                cardPanel.setPreferredSize(this.PantallaPrincipal.getPreferredSize());
                currentPersona = personaDTO;

            }
        });

        // Set the initial panel to show
        cardLayout.show(cardPanel, "CargaPersonaPanel");
        cardPanel.setPreferredSize(cargaPersonaInterface.getPanel1().getPreferredSize());
    }
    private void altaPoliza() {
        currentPersona = null;
        AltaPoliza1 altaPolizaClienteDatos = new AltaPoliza1();

        AltaPoliza2 cargarDatosPoliza = new AltaPoliza2();
        cardPanel.add(cargarDatosPoliza.getPantallaPrincipal(),"carga datos poliza");
        BuscarCliente buscarCliente = new BuscarCliente();
        cardPanel.add(buscarCliente.getpantallaprincipal(),"buscar cliente");
        cardPanel.add(altaPolizaClienteDatos.getPantallaPrincipal(),"Datos Cliente");
        cardLayout.show(cardPanel,"Datos Cliente");
        cardPanel.setPreferredSize(altaPolizaClienteDatos.getPantallaPrincipal().getPreferredSize());
        altaPolizaClienteDatos.getAgregarClienteButton().addActionListener(e -> {
            altaCliente();
        });
        altaPolizaClienteDatos.getBuscarClienteButton().addActionListener(e -> {
            cardLayout.show(cardPanel,"buscar cliente");
            cardPanel.setPreferredSize(buscarCliente.getpantallaprincipal().getPreferredSize());
            buscarCliente.confirmarButton.addActionListener(e1 -> {
                currentPersona = buscarCliente.getSelectedPerson();
                altaPolizaClienteDatos.setdatos(currentPersona);
                cargarDatosPoliza.cargarDatos();
                cardLayout.show(cardPanel,"Datos Cliente");
                cardPanel.setPreferredSize(altaPolizaClienteDatos.getPantallaPrincipal().getPreferredSize());
            });
        });
        altaPolizaClienteDatos.confirmarButton.addActionListener(e->{
            if(currentPersona != null) {
                cardLayout.show(cardPanel, "carga datos poliza");
                cardPanel.setPreferredSize(altaPolizaClienteDatos.getPantallaPrincipal().getPreferredSize());
            }
        });
        altaPolizaClienteDatos.cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"MenuProductorSeguro");
                cardPanel.setPreferredSize(PantallaPrincipal.getPreferredSize());
            }
        });

        cargarDatosPoliza.cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Datos Cliente");
                cardPanel.setPreferredSize(altaPolizaClienteDatos.getPantallaPrincipal().getPreferredSize());
            }
        });

        buscarCliente.cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Datos Cliente");
                cardPanel.setPreferredSize(altaPolizaClienteDatos.getPantallaPrincipal().getPreferredSize());
            }
        });

    }





    public JPanel getPanel1() {
        return PantallaPrincipal;
    }


    public JButton getCerrarSesionButton() {
        return  cerrarSesionButton;
    }
}


