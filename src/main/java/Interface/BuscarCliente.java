package Interface;

import DTO.PersonaDTO;
import Gestores.GestorPersona;
import Hibernate.Model.TipoDocumento;
import com.google.protobuf.StringValue;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import java.util.List;

public class BuscarCliente {

    private JPanel PantallaPrincipal;
    private JComboBox largoBox;
    private JTable tablaClientes;
    public JButton buscarButton;
    private JTextField nombreText;
    private JComboBox tipoDocumentobox;
    public JButton atras;
    public JButton adelante;
    public JButton cancelarButton;
    public JButton confirmarButton;
    private JTextField nroClienteText;
    private JTextField ApellidoText;
    private JTextField documentoText;
    private JLabel páginaXLabel;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private Integer nroCliente;
    private Integer documento;
    private List <PersonaDTO> lista;
    private DefaultTableModel modeloTabla;
    private boolean defaultTable;
    private int filas;
    private int pagina;
    private String página;
    public BuscarCliente(){
        String[] columnas = {"NRO CLIENTE", "APELLIDO", "NOMBRE", "TIPO DOCUMENTO", "NRO DOCUMENTO"};
        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : Object.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaulttable();
        página = "Página ";
        página+= String.valueOf(pagina);
        páginaXLabel.setText(página);

        buscarButton.addActionListener(e -> {
            String aviso = validateData();
            if (aviso.equals("Error en:")) {
                if (!nombreText.getText().equals("")) {
                    nombre = nombreText.getText();
                } else {
                    nombre = null;
                }
                if (!ApellidoText.getText().equals("")) {
                    apellido = ApellidoText.getText();
                } else {
                    apellido = null;
                }
                if (!(tipoDocumentobox.getSelectedIndex() == -1)) {
                    tipoDocumento = (TipoDocumento) tipoDocumentobox.getSelectedItem();
                    System.out.println(tipoDocumento);
                } else {
                    tipoDocumento = null;
                }
                if (!documentoText.getText().equals("")) {
                    documento = Integer.parseInt(documentoText.getText());
                } else {
                    documento = null;
                }
                if (!nroClienteText.getText().equals("")) {
                    nroCliente = Integer.parseInt(nroClienteText.getText());
                } else {
                    nroCliente = null;
                }
                if (nombre != null || apellido != null || tipoDocumento != null || documento != null || nroCliente != null) {
                    defaultTable = false;
                    lista = GestorPersona.getClientes(nombre, apellido, tipoDocumento, documento, nroCliente);

                    // Clear the existing data in the table
                    modeloTabla.setRowCount(0);

                    // Now, you can update the table with the filtered list
                    cargarTabla(lista);
                    tablaClientes.setModel(modeloTabla);
                } else {
                    if (!defaultTable) defaulttable();
                }
            }else {
                JOptionPane.showMessageDialog(null,aviso);
            }
        });

        largoBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    filas = (int) largoBox.getSelectedItem();
                    defaulttable();
                }
            }
        });
        adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagina ++;
                página = "Página ";
                página+= String.valueOf(pagina);
                páginaXLabel.setText(página);
                modeloTabla.setRowCount(0);
                cargarTabla(lista);
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagina--;
                página = "Página ";
                página+= String.valueOf(pagina);
                páginaXLabel.setText(página);
                modeloTabla.setRowCount(0);
                cargarTabla(lista);
            }
        });
    }

    private String validateData() {
        String aviso = "Error en:";
        if (nombreText.getText().length()>20) {
            aviso += " Nombre";
        }
        if (ApellidoText.getText().length()>20) {
            aviso +=" Apellido";
        }
        if ((!documentoText.getText().matches("\\d+")&& !documentoText.getText().equals("")) || documentoText.getText().length()>15) {
            aviso +=" Documento";
        }
        if ((!nroClienteText.getText().matches("\\d+")&& !nroClienteText.getText().equals("")) || nroClienteText.getText().length()>15) {
            aviso +=" NroCliente";
        }
        return aviso;
    }

    private void cargarTabla(List<PersonaDTO> lista) {
        int j =0;
        for (int i = (pagina-1)*filas; j < filas && i < lista.size(); i++) {
            PersonaDTO persona = lista.get(i);

            Object[] fila = {
                    persona.getCliente().getNroCliente(),
                    persona.getApellido(),
                    persona.getNombrePersona(),
                    persona.getTipoDocumento(),
                    persona.getNroDocumento(),
            };
            modeloTabla.addRow(fila);
            j++;
        }
    }

    private void defaulttable() {
        defaultTable=true;
        lista=GestorPersona.getPersonas();
        modeloTabla.setRowCount(0);
        cargarTabla(lista);

        tablaClientes.setModel(modeloTabla);
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer();

        renderizador.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tablaClientes.getColumnCount(); i++) {
            tablaClientes.getColumnModel().getColumn(i).setCellRenderer(renderizador);
        }
    }

    private void createUIComponents() {
        tipoDocumentobox = new JComboBox<>(TipoDocumento.sortedValues());
        tipoDocumentobox.setSelectedIndex(-1);
        Integer valores[] ={5,10,15};
        largoBox = new JComboBox<>(valores);
        filas = 5;
        pagina =1;
        páginaXLabel = new JLabel();
    }


    public PersonaDTO getSelectedPerson() {
        return lista.get(tablaClientes.getSelectedRow());
    }

    public JPanel getpantallaprincipal() {
        return PantallaPrincipal;
    }


}
