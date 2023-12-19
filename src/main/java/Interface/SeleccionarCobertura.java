package Interface;

import DTO.CoberturaDTO;
import DTO.PrecioProveedorTipoDTO;
import Gestores.GestorCoberturas;
import Gestores.GestorPoliza;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private JLabel FechaInicio;
	private JComboBox formaDePagoBox;
	private JScrollPane scrollPane;
	private List<PrecioProveedorTipoDTO> listaPrecios;
	private DefaultTableModel modeloTabla;
	static CoberturaDTO cob;


	public SeleccionarCobertura() {
		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AltaPoliza1 altaPolizaClienteDatos = new AltaPoliza1();
				cardLayout.show(cardPanel,"Datos Cliente");
				cardPanel.setPreferredSize(altaPolizaClienteDatos.getPantallaPrincipal().getPreferredSize());
			}
		});
	}

	public JPanel getPantallaPrincipal() {
		return PantallPrincipal;
	}


	private void createUIComponents() {
		confirmarButton = new JButton();
		confirmarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {;
				cob=new CoberturaDTO();
				cob.setAjusteCantHijos(GestorPoliza.CalcularAjusteHIJOS(currentPoliza.getHijosPoliza()));
				cob.setAjustePorKm(GestorPoliza.CalcularAjusteKM(vehiculoDTO.getKilometrosAnuales()));
				cob.setAjusteSiniestro(GestorPoliza.calcularAjusteSiniestro(currentPoliza.getNroSiniestrosAnuales()));
				PrecioProveedorTipoDTO selectedPrecio = listaPrecios.get(tablaCoberturas.getSelectedRow());
				cob.setPrecio(selectedPrecio.getPrecio());
				cob.setProveedor(selectedPrecio.getProveedor());
				cob.setTipoCobertura(selectedPrecio.getTipoCobertura());
				cob.setAjusteSiniestro(GestorPoliza.calcularAjusteSiniestro(currentPoliza.getNroSiniestrosAnuales()));
				currentPoliza.setFormaDePago((String) formaDePagoBox.getItemAt(formaDePagoBox.getSelectedIndex()));
				LocalDate nextDay = LocalDate.now().plusDays(1);
				LocalDateTime midnight = nextDay.atStartOfDay();
				midnight= midnight.plusMonths(6);
				currentPoliza.setFechaFinVigencia(midnight.toLocalDate());
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



		});
		NroCliente = new JLabel();
		Nombre = new JLabel();
		Apellido = new JLabel();
		String[] columnas = {"PROVEEDORES", "COBERTURA", "PRECIO"};
		modeloTabla = new DefaultTableModel(null, columnas) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 3 ? Boolean.class : Object.class;
			}
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
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
	}
	private void defaulttable() {
		modeloTabla.setRowCount(0);
		listaPrecios = GestorCoberturas.getPrecios();
		int todayYear = LocalDate.now().getYear();
		if (todayYear-vehiculoDTO.getAnioFabricacion().getAnio()>10){
			listaPrecios=listaPrecios.stream().filter(c-> c.getTipoCobertura().getNombreTipo().equals("ResponsabilidadCivil")).toList();
		}
		for (PrecioProveedorTipoDTO cobertura : listaPrecios) {
			Object[] fila = {cobertura.getProveedor().getNombreProv(), cobertura.getTipoCobertura().getNombreTipo(), cobertura.getPrecio(), false};
			modeloTabla.addRow(fila);
		}
		tablaCoberturas.setModel(modeloTabla);

		DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer();
		renderizador.setHorizontalAlignment(SwingConstants.CENTER);

		// Aplicar el renderizador a todas las columnas
		for (int i = 0; i < tablaCoberturas.getColumnCount(); i++) {
			tablaCoberturas.getColumnModel().getColumn(i).setCellRenderer(renderizador);
		}
	}

}
