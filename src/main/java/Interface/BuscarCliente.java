package Interface;

import DTO.PersonaDTO;
import Gestores.GestorPersona;
import Hibernate.Model.TipoDocumento;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

public class BuscarCliente {

    private JPanel PantallaPrincipal;
    private JComboBox comboBox1;
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
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private int nroCliente;
    private int documento;
    private List <PersonaDTO> lista;
    private DefaultTableModel modeloTabla;
    private int selectedRow = -1;
    private boolean defaultTable;

    public BuscarCliente(){
        String[] columnas = {"NroCliente", "Apellido", "Nombre", "TipoDocumento", "NroDocumento", "Select"};
        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : Object.class;
            }
        };
        defaulttable();

        buscarButton.addActionListener(e -> {
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
            } else {
                tipoDocumento = null;
            }
            if (!documentoText.getText().equals("")) {
                documento = Integer.parseInt(documentoText.getText());
            } else {
                documento = 0;
            }
            if (!nroClienteText.getText().equals("")) {
                nroCliente = Integer.parseInt(nroClienteText.getText());
            } else {
                nroCliente = 0;
            }
            if (nombre != null || apellido != null || tipoDocumento != null || documento > 0 || nroCliente > 0) {
                defaultTable=false;
                lista = GestorPersona.getClientes(nombre,apellido,tipoDocumento,documento,nroCliente);

                // Clear the existing data in the table
                modeloTabla.setRowCount(0);

                // Now, you can update the table with the filtered list
                for (PersonaDTO persona : lista) {
                    Object[] fila = {persona.getCliente().getNroCliente(), persona.getApellido(), persona.getNombrePersona(),
                            persona.getTipoDocumento(), persona.getNroDocumento(), false};
                    modeloTabla.addRow(fila);
                }
                tablaClientes.setModel(modeloTabla);
                tablaClientes.getColumnModel().getColumn(5).setCellRenderer(new RadioButtonRenderer());
                tablaClientes.getColumnModel().getColumn(5).setCellEditor(new RadioButtonEditor(new JCheckBox(), this)); // Pass 'this' reference
            }else {
                if (!defaultTable) defaulttable();
            }
        });
    }

    private void defaulttable() {
        defaultTable=true;
        lista=GestorPersona.getClientes(null,null,null,0,0);
        modeloTabla.setRowCount(0);
        for (PersonaDTO persona : lista) {
            Object[] fila = {persona.getCliente().getNroCliente(), persona.getApellido(), persona.getNombrePersona(),
                    persona.getTipoDocumento(), persona.getNroDocumento(), false};
            modeloTabla.addRow(fila);
        }

        tablaClientes.setModel(modeloTabla);
        tablaClientes.getColumnModel().getColumn(5).setCellRenderer(new RadioButtonRenderer());
        tablaClientes.getColumnModel().getColumn(5).setCellEditor(new RadioButtonEditor(new JCheckBox(), this)); // Pass 'this' reference
    }

    private void createUIComponents() {
        tipoDocumentobox = new JComboBox<>(TipoDocumento.values());
        tipoDocumentobox.setSelectedIndex(-1);
    }

    class RadioButtonRenderer extends DefaultTableCellRenderer {
        private JRadioButton radioButton = new JRadioButton();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            if (value != null && value instanceof Boolean) {
                radioButton.setSelected((Boolean) value);
            }
            return radioButton;
        }
    }

    class RadioButtonEditor extends DefaultCellEditor implements ActionListener {
        private JRadioButton radioButton;
        private ButtonGroup buttonGroup;
        private BuscarCliente buscarCliente; // Reference to the outer class

        public RadioButtonEditor(JCheckBox checkBox, BuscarCliente buscarCliente) {
            super(checkBox);
            this.buscarCliente = buscarCliente;
            this.buttonGroup = new ButtonGroup();
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value != null && value instanceof Boolean) {
                radioButton = new JRadioButton();
                radioButton.setSelected((Boolean) value);
                radioButton.addActionListener(this);

                // Add the radio button to the button group for the column
                buttonGroup.add(radioButton);
            }
            return radioButton;
        }

        public Object getCellEditorValue() {
            return radioButton.isSelected();
        }

        public void actionPerformed(ActionEvent actionEvent) {
            // Unselect other radio buttons in the same column
            for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button != radioButton) {
                    button.setSelected(false);
                }
            }

            buscarCliente.selectedRow = tablaClientes.getEditingRow(); // Set the selected row index
            stopCellEditing(); // Manually stop editing to trigger the update
            buscarCliente.modeloTabla.fireTableDataChanged(); // Notify the table model
        }
    }

    // Getter method to retrieve the selected person
    public PersonaDTO getSelectedPerson() {
        if (selectedRow != -1 && selectedRow < lista.size()) {
            return lista.get(selectedRow);
        }
        return null; // No person selected
    }

    public JPanel getpantallaprincipal() {
        return PantallaPrincipal;
    }


}
