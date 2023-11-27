package Interface;

import DTO.PersonaDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Interface.GestorInterface.cardLayout;
import static Interface.GestorInterface.cardPanel;

public class AltaPoliza1 {
    private JButton buscarClienteButton;
    private JButton agregarClienteButton;
    private JPanel PantallaPrincipal;
    private JLabel nroClientelabel;
    public JButton confirmarButton;
    private JLabel nombreLabel;
    private JLabel ApellidoLabel;
    private JLabel tipoDocumentLabel;
    private JLabel numeroDocumentoLabel;
    private JLabel provinciaLabel;
    private JLabel localidadLabel;
    private JLabel direccionLabel;
    public JButton cancelarButton;

    public AltaPoliza1() {

    }

    public JButton getBuscarClienteButton() {
        return buscarClienteButton;
    }

    public JButton getAgregarClienteButton() {
        return agregarClienteButton;
    }

    public JButton getConfirmarButton() {
        return confirmarButton;
    }

    public JPanel getPantallaPrincipal(){
        return PantallaPrincipal;
    }

    public void setdatos(PersonaDTO personaDTO) {
        nroClientelabel.setText(String.valueOf(personaDTO.getCliente().getNroCliente()));
        nombreLabel.setText(personaDTO.getNombrePersona());
        ApellidoLabel.setText(personaDTO.getApellido());
        tipoDocumentLabel.setText(String.valueOf(personaDTO.getTipoDocumento()));
        numeroDocumentoLabel.setText(String.valueOf(personaDTO.getNroDocumento()));
        provinciaLabel.setText(personaDTO.getDireccion().get(0).getCalle());
        localidadLabel.setText(personaDTO.getDireccion().get(0).getLocalidad().getNombre());
        direccionLabel.setText(personaDTO.getDireccion().get(0).getLocalidad().getProvincia().getNombre());
    }
}
