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


	public PolizaGenerar() {
		confirmarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentPoliza.setMontoTotal(Integer.valueOf(totalAPagarLabel.getText()));
				GestorPoliza.crearPoliza(currentPoliza,localidad,vehiculoDTO,cob);
				cardLayout.show(cardPanel,"MenuProductorSeguro");
				cardPanel.setPreferredSize(new Dimension(600, 218));
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
		marcaLabel.setText(currentPoliza.getVehiculo().getModelo().getMarca().getNombreMarca());
		//modeloLabel = new JLabel();
		modeloLabel.setText(currentPoliza.getVehiculo().getModelo().getNombreModelo());
		//motorLabel = new JLabel();
		motorLabel.setText(currentPoliza.getVehiculo().getMotor());
		//chasisLabel = new JLabel();
		chasisLabel.setText(currentPoliza.getVehiculo().getChasis());
		//patenteLabel = new JLabel();
		patenteLabel.setText(currentPoliza.getVehiculo().getPatente());
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
		importe1.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
		//totalAPagarLabel = new JLabel();
		totalAPagarLabel.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
		/*vencimiento2 = new JLabel();
		vencimiento3 = new JLabel();
		vencimiento4 = new JLabel();
		vencimiento5 = new JLabel();
		vencimiento6 = new JLabel();
		importe2 = new JLabel();
		importe3 = new JLabel();
		importe4 = new JLabel();
		importe5 = new JLabel();
		importe6 = new JLabel();*/
		if(currentPoliza.getFormaDePago().equals("Semestral")){
			vencimiento2.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(2)));
			vencimiento3.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(3)));
			vencimiento4.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(4)));
			vencimiento5.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(5)));
			vencimiento6.setText(String.valueOf(currentPoliza.getFechaInicioVigencia().plusMonths(6)));
			importe2.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
			importe3.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
			importe4.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
			importe5.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
			importe6.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()));
			totalAPagarLabel.setText(String.valueOf(currentPoliza.getCobertura().getPrecio()*6));
		}
	}
}
