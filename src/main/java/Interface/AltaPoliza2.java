package Interface;

import DTO.*;
import Gestores.GestorDirrecciones;
import Gestores.GestorPoliza;
import Hibernate.Model.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;

import static Interface.GestorInterface.cardLayout;
import static Interface.GestorInterface.cardPanel;
import static Interface.MenuProductorSeguros.currentPersona;
import static Interface.MenuProductorSeguros.currentPoliza;
public class AltaPoliza2 {
    private static final Integer VALORGARAJE = 5;
    private static final Integer VALORALARMA = 3;
    private static final Integer VALORRASTREADOR = 3;
    private static final Integer VALORTUERCAS = 1;
    private JPanel PanelPrincipal;
    private JComboBox ProvComboBox;
    private JTabbedPane tabbedPane1;
    private JComboBox LocalidadBox;
    private JComboBox MarcaBox;
    private JComboBox ModeloBox;
    private JComboBox AñoVehiculoBox;
    private JButton confirmarButton;
    private JTextField motorText;
    private JTextField chasisText;
    private JTextField patenteText;
    private JTextField kmText;
    private JTextField fechaText1;
    private JComboBox Sexo1;
    private JComboBox Civil1;
    private JTextField fechaText2;
    private JComboBox Sexo2;
    private JComboBox Civil2;
    private JTextField fechaText3;
    private JComboBox Sexo3;
    private JComboBox Civil3;
    private JTextField fechaText4;
    private JComboBox Sexo4;
    private JComboBox Civil4;
    private JButton plusHijo2;
    private JButton PlusHijo3;
    private JButton plusHijo4;
    private JButton closeHijo4;
    private JButton closeHijo3;
    private JButton closeHijo2;
    private JPanel hijoPanel2;
    private JPanel hijoPanel3;
    private JPanel hijoPanel4;
    private JPanel hijoPanel1;
    private JPanel hijosPanelPrincipal;
    private JCheckBox garaje;
    private JCheckBox alarma;
    private JCheckBox rastreador;
    private JCheckBox tuercasAntirobo;
    private JComboBox siniestrosBox;
    private JButton X1;
   public JButton cancelarButton;
    private List<ModeloDTO> modelos=new ArrayList<>();
    private List<MarcaDTO> marcas=new ArrayList<>();
    private List<AnioFabricacionDTO> años=new ArrayList<>();
    static VehiculoDTO vehiculoDTO;
    static LocalidadDTO localidad;
    private boolean bloquearCargaAño = false;
    private boolean bloquearCargaLoc = false;
    private boolean bloquearCargaMod = false;
    List<ProvinciaDTO> uniqueProvinces= new ArrayList<>();


    public AltaPoliza2() {
        plusHijo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(1, true); //
            }
        });
        PlusHijo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(2, true); //
            }
        });
        plusHijo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(3, true); //
            }
        });
        closeHijo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(1, false); //
            }
        });
        closeHijo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(2, false); //
            }
        });
        closeHijo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(3, false); //
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPoliza = new PolizaDTO();
                String aviso = validateData();
                if (aviso.equals("Error en:")) {
                    currentPoliza = createPoliza();
                    currentPoliza.setCliente(currentPersona.getCliente());
                    System.out.println(currentPoliza.toString());
                    SeleccionarCobertura cobertura = new SeleccionarCobertura();
                    cardPanel.add(cobertura.getPantallaPrincipal(),"elegir cobertura");
                    cardPanel.setPreferredSize(cobertura.getPantallaPrincipal().getPreferredSize());
                    cobertura.cargarDatos();
                    cardLayout.show(cardPanel,"elegir cobertura");
                } else {
                    JOptionPane.showMessageDialog(null, aviso);
                }
            }
        });

        X1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaText1.setText("Escriba aquí...");
                Sexo1.setSelectedIndex(-1);
                Civil1.setSelectedIndex(-1);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fechaText1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fechaText1.getText().equals("Escriba aquí...")) fechaText1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fechaText1.getText().equals("")) {
                    fechaText1.setText("Escriba aquí...");
                }
            }
        });

        fechaText2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fechaText2.getText().equals("Escriba aquí...")) fechaText2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fechaText2.getText().equals("")) {
                    fechaText2.setText("Escriba aquí...");
                }
            }
        });

        fechaText3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fechaText3.getText().equals("Escriba aquí...")) fechaText3.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fechaText3.getText().equals("")) {
                    fechaText3.setText("Escriba aquí...");
                }
            }
        });

        fechaText4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fechaText4.getText().equals("Escriba aquí...")) fechaText4.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fechaText4.getText().equals("")) {
                    fechaText4.setText("Escriba aquí...");
                }
            }
        });
        ProvComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    if (!bloquearCargaLoc){
                        String selectedProvNombre = (String) ProvComboBox.getSelectedItem();
                        System.out.println(ProvComboBox.getSelectedItem());
                        ProvinciaDTO selectedProv = uniqueProvinces.stream().filter(provinciaDTO -> provinciaDTO.getNombre().equals(selectedProvNombre)).findFirst().orElse(null);
                        System.out.println(selectedProv.getId());
                        List<LocalidadDTO> locSelecionadas = new ArrayList<>(GestorDirrecciones.getLocalidadesByProvincia(selectedProv));
                        DefaultComboBoxModel<String> locComboBoxModel = new DefaultComboBoxModel<>();
                        LocalidadBox.setModel(locComboBoxModel);
                        Collections.sort(locSelecionadas, (l1, l2) -> l1.getNombre().compareToIgnoreCase(l2.getNombre()));
                        locSelecionadas.forEach(l -> locComboBoxModel.addElement(l.getNombre()));
                        LocalidadBox.setSelectedIndex(-1);
                    }
                }

            }
        });
        MarcaBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    if (!bloquearCargaMod) {
                        bloquearCargaAño = true;
                        Object selectedMarcaObject = MarcaBox.getSelectedItem();
                        modelos = new ArrayList<>(GestorPoliza.getModelosByMarca(marcas.stream().filter(m -> m.getNombreMarca().equals(selectedMarcaObject)).findFirst().orElse(null)));
                        DefaultComboBoxModel<String> modComboBoxModel = new DefaultComboBoxModel<>();
                        Collections.sort(modelos, (m1, m2) -> m1.getNombreModelo().compareToIgnoreCase(m2.getNombreModelo()));
                        modelos.forEach(m -> modComboBoxModel.addElement(m.getNombreModelo()));
                        ModeloBox.setModel(modComboBoxModel);
                        ModeloBox.setSelectedIndex(-1);
                        bloquearCargaAño = false;
                    }
                }
            }
        });
        ModeloBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (!bloquearCargaAño) {
                        Object selectedModeloObject = ModeloBox.getSelectedItem();
                        años = GestorPoliza.getañosByModelo(modelos.stream().filter(m -> m.getNombreModelo().equals(selectedModeloObject)).findFirst().orElse(null));
                        DefaultComboBoxModel<Integer> añoComboBoxModel = new DefaultComboBoxModel<>();
                        años.forEach(a -> añoComboBoxModel.addElement(a.getAnio()));
                        AñoVehiculoBox.setModel(añoComboBoxModel);
                        AñoVehiculoBox.setSelectedIndex(-1);
                    }
                }
            }
        });
    }

    private PolizaDTO createPoliza() {
        PolizaDTO polizaDTO = new PolizaDTO();
        polizaDTO.setNroSiniestrosAnuales((Siniestros) siniestrosBox.getSelectedItem());
        System.out.println(polizaDTO.getNroSiniestrosAnuales());
        polizaDTO.setEstadoPoliza("Generada");
        polizaDTO.setEstadoPolizaPdf(true);
        polizaDTO.setCliente(currentPersona.getCliente());
        LocalDate nextDay = LocalDate.now().plusDays(1);
        LocalDateTime midnight = nextDay.atStartOfDay();
        polizaDTO.setFechaInicioVigencia(midnight.toLocalDate());
        vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setAnioFabricacion(años.get(AñoVehiculoBox.getSelectedIndex()));
        vehiculoDTO.setChasis(chasisText.getText());
        vehiculoDTO.setModelo(modelos.get(ModeloBox.getSelectedIndex()));
        vehiculoDTO.setMotor(motorText.getText());
        vehiculoDTO.setPatente(patenteText.getText());
        vehiculoDTO.setKilometrosAnuales(Integer.parseInt(kmText.getText()));
        System.out.println(vehiculoDTO.toString());
        polizaDTO.setSumaAsegurada(GestorPoliza.calcularSumaAsegurada(vehiculoDTO));
        /*if(garaje.isSelected()){
            MedidaSeguridadDTO garaje = new MedidaSeguridadDTO();
            garaje.setNombreMedida("garaje");
            garaje.setValorPorcentual(VALORGARAJE);
            polizaDTO.addMedida(garaje);
        }
        if(alarma.isSelected()){
            MedidaSeguridadDTO alarma = new MedidaSeguridadDTO();
            alarma.setNombreMedida("alarma");
            alarma.setValorPorcentual(VALORALARMA);
            polizaDTO.addMedida(alarma);
        }
        if (rastreador.isSelected()){
            MedidaSeguridadDTO rastreador = new MedidaSeguridadDTO();
            rastreador.setNombreMedida("rastreador");
            rastreador.setValorPorcentual(VALORRASTREADOR);
            polizaDTO.addMedida(rastreador);
        }
        if(tuercasAntirobo.isSelected()){
            MedidaSeguridadDTO tuercasAntirobo = new MedidaSeguridadDTO();
            tuercasAntirobo.setNombreMedida("Tuercas Antirobos");
            tuercasAntirobo.setValorPorcentual(VALORTUERCAS);
            polizaDTO.addMedida(tuercasAntirobo);
        }*/
        //todo ver todo esto
        polizaDTO.setDerechoDeEmision(GestorPoliza.calcularDerechoEmision());
        String selectedLocalidadNombre = (String) LocalidadBox.getSelectedItem();
        localidad = currentPersona.getDireccion().stream()
                .filter(dir -> dir.getLocalidad().getNombre().equals(selectedLocalidadNombre))
                .map(DireccionDTO::getLocalidad)
                .findFirst()
                .orElse(null);
        if(fechaText1.getText().equals("Escriba aquí...") || Sexo1.getSelectedIndex()>=0 || Civil1.getSelectedIndex()>=0){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo1.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil1.getSelectedItem());
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaText1.getText());
                hijoDTO.setFechaDeNacimiento(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            polizaDTO.addHijo(hijoDTO);
        }
        if(tabbedPane1.isEnabledAt(1)){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo2.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil2.getSelectedItem());
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaText2.getText());
                hijoDTO.setFechaDeNacimiento(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            polizaDTO.addHijo(hijoDTO);
        }
        if(tabbedPane1.isEnabledAt(2)){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo3.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil3.getSelectedItem());
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaText3.getText());
                hijoDTO.setFechaDeNacimiento(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            polizaDTO.addHijo(hijoDTO);
        }
        if(tabbedPane1.isEnabledAt(3)){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo4.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil4.getSelectedItem());
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaText4.getText());
                hijoDTO.setFechaDeNacimiento(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            polizaDTO.addHijo(hijoDTO);
        }
        return polizaDTO;
    }

    private String validateData() {
        String aviso="Error en:";
        if (ProvComboBox.getSelectedIndex()<0){
            aviso+= " Provincia,";
        }
        if (LocalidadBox.getSelectedIndex()<0){
            aviso+= " Localidad,";
        }
        if (MarcaBox.getSelectedIndex()<0){
            aviso+= " Marca,";
        }
        if (ModeloBox.getSelectedIndex()<0){
            aviso+= " Modelo,";
        }
        if (AñoVehiculoBox.getSelectedIndex()<0){
            aviso+= " AñoVehiculo,";
        }
        if (motorText.getText().equals("")||motorText.getText().length()<20){
            aviso+= " Motor,";
        }
        if(chasisText.getText().equals("")||chasisText.getText().length()<20){
            aviso+= " Chasis,";
        }
        if(patenteText.getText().equals("")||patenteText.getText().length()<20){
            aviso+= " Patente,";
        }
        if(kmText.getText().equals("")||kmText.getText().length()<20|| !kmText.getText().matches("\\d+")){
            aviso+= " Km,";
        }
        if (siniestrosBox.getSelectedIndex()<0){
            aviso+= " Siniestros,";
        }

        String patronFecha = "\\d{4}-\\d{2}-\\d{2}";

        Pattern pattern = Pattern.compile(patronFecha);

        if(!(fechaText1.getText().equals("Escriba aquí...") || Sexo1.getSelectedIndex()>=0 || Civil1.getSelectedIndex()>=0)) {
            String textoFecha = fechaText1.getText();
            validateFecha(textoFecha);
            Matcher matcher = pattern.matcher(textoFecha);

            if (!matcher.matches()) {
                aviso += " Fecha Hijo1, ";
            }
            if (Sexo1.getSelectedIndex() < 0) {
                aviso += " Sexo Hijo1,";
            }
            if (Civil1.getSelectedIndex() < 0) {
                aviso += " Estado Civil Hijo1,";
            }
        }
        if (tabbedPane1.isEnabledAt(1)) {
            String textoFecha = fechaText2.getText();

            Matcher matcher = pattern.matcher(textoFecha);

            if (!matcher.matches()) {
                aviso += " Fecha Hijo2, ";
            }
            if (Sexo2.getSelectedIndex() < 0) {
                aviso += " Sexo Hijo2,";
            }
            if (Civil2.getSelectedIndex() < 0) {
                aviso += " Estado Civil Hijo2,";
            }
        }
        if (tabbedPane1.isEnabledAt(2)) {
            String textoFecha = fechaText3.getText();

            Matcher matcher = pattern.matcher(textoFecha);

            if (!matcher.matches()) {
                aviso += " Fecha Hijo3, ";
            }
            if (Sexo3.getSelectedIndex() < 0) {
                aviso += " Sexo Hijo3,";
            }
            if (Civil3.getSelectedIndex() < 0) {
                aviso += " Estado Civil Hijo3,";
            }
        }
        if (tabbedPane1.isEnabledAt(3)) {
            String textoFecha = fechaText4.getText();

            Matcher matcher = pattern.matcher(textoFecha);

            if (!matcher.matches()) {
                aviso += " Fecha Hijo4, ";
            }
            if (Sexo4.getSelectedIndex() < 0) {
                aviso += " Sexo Hijo4,";
            }
            if (Civil4.getSelectedIndex() < 0) {
                aviso += " Estado Civil Hijo4,";
            }
        }
        return aviso;
    }

    private void validateFecha(String textoFecha) {
        //todo
    }

    public JPanel getPantallaPrincipal() {
        return PanelPrincipal;
    }
    public void cargarDatos(){
        bloquearCargaLoc = true;
        ProvComboBox.removeAllItems();
        uniqueProvinces = new ArrayList<>(GestorDirrecciones.getProvincias());
        Collections.sort(uniqueProvinces, (p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
        uniqueProvinces.forEach(p -> ProvComboBox.addItem(p.getNombre()));
        ProvComboBox.setSelectedIndex(-1);
        bloquearCargaLoc=false;
        bloquearCargaMod =true;
        DefaultComboBoxModel<String> marcaComboBoxModel = new DefaultComboBoxModel<>();
        MarcaBox.setModel(marcaComboBoxModel);
        marcas= new ArrayList<>(GestorPoliza.getMarcas());

        Collections.sort(marcas, (m1, m2) -> m1.getNombreMarca().compareToIgnoreCase(m2.getNombreMarca()));
        marcas.forEach(marcaDTO -> marcaComboBoxModel.addElement(marcaDTO.getNombreMarca()));
        MarcaBox.setSelectedIndex(-1);
        bloquearCargaMod =false;
    }
    public void createUIComponents() {
        cargarHijos();
        siniestrosBox = new JComboBox<>(Siniestros.values());
        siniestrosBox.setSelectedIndex(-1);
        hijosPanelPrincipal = new JPanel();
        tabbedPane1 = new JTabbedPane();
        ModeloBox= new JComboBox<>();
        ProvComboBox = new JComboBox<>();
        ProvComboBox.setSelectedIndex(-1);
        AñoVehiculoBox= new JComboBox<>();
        hijoPanel1 = new JPanel();
        hijoPanel2 = new JPanel();
        hijoPanel3 = new JPanel();
        hijoPanel4 = new JPanel();
        MarcaBox = new JComboBox<>();
    }

    private void cargarHijos() {
        Sexo1 = new JComboBox<>(Sexo.values());
        Sexo1.setSelectedIndex(-1);
        Civil1 = new JComboBox<>(EstadoCivil.values());
        Civil1.setSelectedIndex(-1);
        Sexo2 = new JComboBox<>(Sexo.values());
        Sexo2.setSelectedIndex(-1);
        Civil2 = new JComboBox<>(EstadoCivil.values());
        Civil2.setSelectedIndex(-1);
        Sexo3 = new JComboBox<>(Sexo.values());
        Sexo3.setSelectedIndex(-1);
        Civil3 = new JComboBox<>(EstadoCivil.values());
        Civil3.setSelectedIndex(-1);
        Sexo4 = new JComboBox<>(Sexo.values());
        Sexo4.setSelectedIndex(-1);
        Civil4 = new JComboBox<>(EstadoCivil.values());
        Civil4.setSelectedIndex(-1);
    }


}

