package Interface;

import DTO.DireccionDTO;
import DTO.LocalidadDTO;
import DTO.PaisDTO;
import DTO.ProvinciaDTO;
import Gestores.GestorDirrecciones;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;


public class DirreccionInterface {
	private JPanel panel1;
	private JComboBox LocComboBox;
	private JComboBox PaisComboBox;
	private JLabel ProvinciaLabel;
	private JLabel localidadLabel;
	private JLabel PaisLabel;
	private JComboBox ProvComboBox;
	private JTextField CalleText;
	public JButton doneButton;
	private JTextField PisoText;
	private JTextField AlturaText;
	private JTextField DeptoText;
	private JLabel Avistolabel;
	private List<PaisDTO> paises ;
	private List<String> nombresPaises ;
	private List<ProvinciaDTO> provincias ;
	private List<LocalidadDTO> localidades ;
	private  DireccionDTO Ddto;

	public DirreccionInterface() {
		CalleText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(CalleText.getText().equals("ingrese aqui"))CalleText.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(CalleText.getText().equals("")){
					CalleText.setText("ingrese aqui");
				}
			}
		});
		PisoText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(PisoText.getText().equals("ingrese aqui"))PisoText.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (PisoText.getText().equals("")) {
					PisoText.setText("ingrese aqui");
				}
			}
		});

		AlturaText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(AlturaText.getText().equals("ingrese aqui"))AlturaText.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (AlturaText.getText().equals("")) {
					AlturaText.setText("ingrese aqui");
				}
			}
		});

		DeptoText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				if(DeptoText.getText().equals("ingrese aqui"))DeptoText.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (DeptoText.getText().equals("")) {
					DeptoText.setText("ingrese aqui");
				}
			}
		});
		doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DireccionDTO direccion = new DireccionDTO();
				direccion.setCalle(CalleText.getText());
				direccion.setPiso(PisoText.getText());
				direccion.setAltura(Integer.valueOf(AlturaText.getText()));
				direccion.setDepto(DeptoText.getText());
				direccion.setLocalidad(new LocalidadDTO(localidades.stream()
						.filter(localidad -> localidad.getNombre().equals(LocComboBox.getSelectedItem()))
						.findFirst()
						.orElse(null)));
				Ddto = direccion;
			}
		});
	}

	private void createUIComponents() {
		paises = GestorDirrecciones.getPaises();
		nombresPaises = paises.stream()
				.map(PaisDTO::getNombre)
				.toList();
		provincias = GestorDirrecciones.getProvincias();
		localidades = GestorDirrecciones.getLocalidades();
		PaisComboBox = new JComboBox<>(nombresPaises.toArray(new String[0]));
		PaisComboBox.setSelectedIndex(-1);
		ProvComboBox = new JComboBox<>();
		LocComboBox = new JComboBox<>();
		PaisComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object selectedPaisObject = PaisComboBox.getSelectedItem();
					List<String> provSelecionadas = provincias.stream()
							.filter(provinciaDTO -> provinciaDTO.getPais().getNombre().equals(selectedPaisObject))
							.map(ProvinciaDTO::getNombre)
							.toList();
					DefaultComboBoxModel<String> provComboBoxModel = new DefaultComboBoxModel<>();
					ProvComboBox.setModel(provComboBoxModel);
					provSelecionadas.forEach(p -> provComboBoxModel.addElement(p));
					ProvComboBox.setSelectedIndex(-1);
					DefaultComboBoxModel<String> LocComboBoxModel0 = new DefaultComboBoxModel<>();
					LocComboBox.setModel(LocComboBoxModel0);
				}
			}
		});
		ProvComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					List<String> locSelecionadas = localidades.stream()
							.filter(localidadDTO -> localidadDTO.getProvincia().getNombre().equals(ProvComboBox.getSelectedItem()))
							.map(LocalidadDTO::getNombre)
							.toList();
					DefaultComboBoxModel<String> LocComboBoxModel = new DefaultComboBoxModel<>();
					LocComboBox.setModel(LocComboBoxModel);
					locSelecionadas.forEach(l->LocComboBoxModel.addElement(l));
					LocComboBox.setSelectedIndex(-1);
				}
			}
		});
	}

	public JPanel getPanel1() {
		return panel1;
	}


	public DireccionDTO getDireccionDTO() {
		String aviso = validateData();
		if (aviso.equals("Error en:")) {
			return Ddto;
			// Aquí puedes realizar acciones adicionales con el objeto personaDTO
		} else {
			JOptionPane.showMessageDialog(null, aviso);
		}
		return null;
	}

	private String validateData() {
		String aviso = "Error en:";
		if (PaisComboBox.getSelectedIndex() < 0) {
			aviso += " Pais, ";
		}
		if (ProvComboBox.getSelectedIndex() < 0) {
			aviso += " Provincia, ";
		}
		if (LocComboBox.getSelectedIndex() < 0) {
			aviso += " Localidad, ";
		}
		if (CalleText.getText().equals("ingrese aqui")) {
			aviso += " Calle, ";
		}
		if (PisoText.getText().equals("ingrese aqui")) {
			aviso += " Piso, ";
		}
		if (AlturaText.getText().equals("ingrese aqui")) {
			aviso += " Altura, ";
		}
		if (DeptoText.getText().equals("ingrese aqui")) {
			aviso += " Depto, ";
		}
		return aviso;
	}
}
