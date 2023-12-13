package Interface;

import Gestores.GestorPoliza;
import Hibernate.Model.Vehiculo;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import static Interface.AltaPoliza2.localidad;
import static Interface.AltaPoliza2.vehiculoDTO;
import static Interface.GestorInterface.cardLayout;
import static Interface.GestorInterface.cardPanel;
import static Interface.MenuProductorSeguros.currentPoliza;
import static Interface.SeleccionarCobertura.cob;


public class PolizaGenerar {
    private JPanel PantallaPrincipal;
    private JButton confirmarButton;
	private JLabel tiularLabel;
	private JLabel fechaDeInicioLabel;
	private JLabel fechaDeFinLabel;
	private JLabel sumaAseguradaLabel;
	private JLabel premioLabel;
	private JLabel ImportePorDescuento;
	private JLabel marcaLabel;
	private JLabel modeloLabel;
	private JLabel motorLabel;
	private JLabel chasisLabel;
	private JLabel patenteLabel;
	private JLabel totalAPagarLabel;
	private JLabel vencimiento1;
	private JLabel vencimiento2;
	private JLabel vencimiento3;
	private JLabel vencimiento4;
	private JLabel vencimiento5;
	private JLabel vencimiento6;
	private JLabel importe1;
	private JLabel importe2;
	private JLabel importe3;
	private JLabel importe4;
	private JLabel importe5;
	private JLabel importe6;

	public JButton cancelarButton;


	public PolizaGenerar() {
		confirmarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentPoliza.setMontoTotal(Integer.valueOf(totalAPagarLabel.getText()));
				currentPoliza.getCliente().setEstadoCliente("Normal");
				try {
					GestorPoliza.crearPoliza(currentPoliza, localidad, vehiculoDTO, cob);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				cardLayout.show(cardPanel,"MenuProductorSeguro");
				cardPanel.setPreferredSize(new Dimension(600, 218));
			}
		});
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
		return PantallaPrincipal;
	}
	private void createUIComponents() {

	}
	public void cargarDatos(){
		//tiularLabel = new JLabel();
		tiularLabel.setText(currentPoliza.getCliente().getPersona().getNombrePersona()+" "+currentPoliza.getCliente().getPersona().getApellido());
		//marcaLabel = new JLabel();
		marcaLabel.setText(vehiculoDTO.getModelo().getMarca().getNombreMarca());
		//modeloLabel = new JLabel();
		modeloLabel.setText(vehiculoDTO.getModelo().getNombreModelo());
		//motorLabel = new JLabel();
		motorLabel.setText(vehiculoDTO.getMotor());
		//chasisLabel = new JLabel();
		chasisLabel.setText(vehiculoDTO.getChasis());
		//patenteLabel = new JLabel();
		patenteLabel.setText(vehiculoDTO.getPatente());
		//fechaDeFinLabel = new JLabel();
		fechaDeFinLabel.setText(String.valueOf(currentPoliza.getFechaFinVigencia()));
		//fechaDeInicioLabel = new JLabel();
		fechaDeInicioLabel.setText(String.valueOf(currentPoliza.getFechaInicioVigencia()));
		//sumaAseguradaLabel = new JLabel();
		sumaAseguradaLabel.setText(String.valueOf(currentPoliza.getSumaAsegurada()));
		//premioLabel = new JLabel();
		premioLabel.setText(String.valueOf(currentPoliza.getPremio()));
		//ImportePorDescuento = new JLabel();
		ImportePorDescuento.setText(String.valueOf(currentPoliza.getDescuentos()));
		//vencimiento1 = new JLabel();
		vencimiento1.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(1)));
		//importe1 = new JLabel();
		importe1.setText(String.valueOf(cob.getPrecio()));
		//totalAPagarLabel = new JLabel();
		totalAPagarLabel.setText(String.valueOf(cob.getPrecio()));
		if(currentPoliza.getFormaDePago().equals("Semestral")){
			vencimiento2.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(2)));
			vencimiento3.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(3)));
			vencimiento4.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(4)));
			vencimiento5.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(5)));
			vencimiento6.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(6)));
			importe2.setText(String.valueOf(cob.getPrecio()));
			importe3.setText(String.valueOf(cob.getPrecio()));
			importe4.setText(String.valueOf(cob.getPrecio()));
			importe5.setText(String.valueOf(cob.getPrecio()));
			importe6.setText(String.valueOf(cob.getPrecio()));
			totalAPagarLabel.setText(String.valueOf(cob.getPrecio()*6));
		}
	}
}
