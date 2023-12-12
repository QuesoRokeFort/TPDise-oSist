package Interface;

import DTO.CoberturaDTO;
import DTO.PrecioProveedorTipoDTO;
import Gestores.GestorCoberturas;
import Gestores.GestorPoliza;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;

import static Interface.AltaPoliza2.vehiculoDTO;
import static Interface.GestorInterface.cardLayout;
import static Interface.GestorInterface.cardPanel;
import static Interface.MenuProductorSeguros.currentPoliza;

public class SeleccionarCobertura {
	private JPanel PantallPrincipal;
	private JLabel nroDeClienteLabel;
	private JLabel nombreLabel;
	private JButton button1;
	private JButton cancelarButton;
	private JButton confirmarButton;
	private JLabel apellidoLabel;
	private JTable tablaCoberturas;
	private JLabel NroCliente;
	private JLabel Nombre;
	private JLabel Apellido;
	private JLabel FechaVencimiento;
	private JLabel FechaInicio;
	private JComboBox formaDePagoBox;
	private JScrollPane scrollPane;
	private List<PrecioProveedorTipoDTO> listaPrecios;
	private DefaultTableModel modeloTabla;
	private int selectedRow;
	static CoberturaDTO  cob;


	public JPanel getPantallaPrincipal() {
		return PantallPrincipal;
	}


	private void createUIComponents() {
		selectedRow = -1;
		confirmarButton = new JButton();
		confirmarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("here");
				cob=new CoberturaDTO();
				cob.setAjusteCantHijos(CalcularAjusteHIJOS());
				cob.setAjustePorKm(CalcularAjusteKM());
				cob.setAjusteSiniestro(CalcularAjusteSiniestro());
				listaPrecios.forEach(c-> System.out.println(c.toString()));
				System.out.println(selectedRow);
				PrecioProveedorTipoDTO selectedPrecio = listaPrecios.get(selectedRow);
				cob.setPrecio(selectedPrecio.getPrecio());
				cob.setProveedor(selectedPrecio.getProveedor());
				cob.setTipoCobertura(selectedPrecio.getTipoCobertura());
				currentPoliza.setFormaDePago((String) formaDePagoBox.getItemAt(formaDePagoBox.getSelectedIndex()));
				currentPoliza.setEstadoPolizaPdf(false);
				currentPoliza.setDescuentos(GestorPoliza.calcularDescuentos(currentPoliza.getMedidasSeguradad(),currentPoliza.getCliente(),currentPoliza.getFormaDePago()));
				currentPoliza.setPrima(GestorPoliza.calcularPrima(cob,currentPoliza.getLocalidad(),currentPoliza.getVehiculo(),currentPoliza.getMedidasSeguradad(),currentPoliza.getNroSiniestrosAnuales(),currentPoliza.getHijosPoliza()));
				currentPoliza.setPremio(GestorPoliza.calcularPremio(currentPoliza.getDerechoDeEmision(),currentPoliza.getPrima()));
				PolizaGenerar polizaGenerar = new PolizaGenerar();
				polizaGenerar.cargarDatos();
				cardPanel.add(polizaGenerar.getPantallaPrincipal(),"poliza a generar");
				cardLayout.show(cardPanel,"poliza a generar");
				cardPanel.setPreferredSize(polizaGenerar.getPantallaPrincipal().getPreferredSize());
				cardPanel.repaint();
				cardPanel.revalidate();
			}

			private String CalcularAjusteSiniestro() {
				return "";
			}

			private Integer CalcularAjusteHIJOS() {
				return 0;
			}
			private Integer CalcularAjusteKM() {
				return 0;
			}
		});
		NroCliente = new JLabel();
		Nombre = new JLabel();
		Apellido = new JLabel();
		String[] columnas = {"Proveedores", "Cobertura", "Precio", "Select"};
		modeloTabla = new DefaultTableModel(null, columnas) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 3 ? Boolean.class : Object.class;
			}
		};
		tablaCoberturas = new JTable();
		defaulttable();
		scrollPane = new JScrollPane(tablaCoberturas);
		formaDePagoBox =new JComboBox<>();
		formaDePagoBox.addItem("Mensual");
		formaDePagoBox.addItem("Semestral");
	}
	public void cargarDatos(){
		System.out.println(currentPoliza.toString());
		NroCliente.setText(String.valueOf(currentPoliza.getCliente().getNroCliente()));
		Nombre.setText(currentPoliza.getCliente().getPersona().getNombrePersona());
		Apellido.setText(currentPoliza.getCliente().getPersona().getApellido());
		FechaInicio.setText(String.valueOf(currentPoliza.getFechaInicioVigencia()));
		FechaVencimiento.setText(String.valueOf(currentPoliza.getFechaFinVigencia()));
	}
	private void defaulttable() {
		modeloTabla.setRowCount(0);
		listaPrecios = GestorCoberturas.getPrecios();
		int todayYear = LocalDate.now().getYear();
		//System.out.println(todayYear-vehiculoDTO.getAnioFabricacion().getAnio());
		if (todayYear-vehiculoDTO.getAnioFabricacion().getAnio()>10){
			listaPrecios=listaPrecios.stream().filter(c-> c.getTipoCobertura().getNombreTipo().equals("ResponsabilidadCivil")).toList();
		}
		for (PrecioProveedorTipoDTO cobertura : listaPrecios) {
			Object[] fila = {cobertura.getProveedor().getNombreProv(), cobertura.getTipoCobertura().getNombreTipo(), cobertura.getPrecio(), false};
			modeloTabla.addRow(fila);
		}
		tablaCoberturas.setModel(modeloTabla);
		tablaCoberturas.getColumnModel().getColumn(3).setCellRenderer(new RadioButtonRenderer());
		tablaCoberturas.getColumnModel().getColumn(3).setCellEditor(new RadioButtonEditor(new JCheckBox(), this)); // Pass 'this' reference
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
		private SeleccionarCobertura seleccionarCobertura; // Reference to the outer class

		public RadioButtonEditor(JCheckBox checkBox, SeleccionarCobertura buscarCliente) {
			super(checkBox);
			this.seleccionarCobertura = buscarCliente;
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

			seleccionarCobertura.selectedRow = tablaCoberturas.getEditingRow(); // Set the selected row index
			stopCellEditing(); // Manually stop editing to trigger the update
			seleccionarCobertura.modeloTabla.fireTableDataChanged(); // Notify the table model
		}
	}

}
