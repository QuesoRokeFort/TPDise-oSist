package Interface;

import DTO.*;
import Gestores.GestorVehiculos;
import Hibernate.Model.EstadoCivil;
import Hibernate.Model.Sexo;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private List<ModeloDTO> modelos;
    private List<MarcaDTO> marcas;
    private List<AnioFabricacionDTO> años;


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
                fechaText1.setText("Escriba Aqui");
                Sexo1.setSelectedIndex(-1);
                Civil1.setSelectedIndex(-1);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private PolizaDTO createPoliza() {
        PolizaDTO polizaDTO = new PolizaDTO();
        polizaDTO.setNroSiniestrosAnuales((Integer) siniestrosBox.getSelectedItem());
        polizaDTO.setSumaAsegurada(calcularSumaAsegurada());
        // TODO ver estados poliza y suma asegurada y premio y derecho de emision y descuento
        polizaDTO.setEstadoPoliza("Pendiente");
        LocalDate nextDay = LocalDate.now().plusDays(1);
        LocalDateTime midnight = nextDay.atStartOfDay();
        polizaDTO.setFechaInicioVigencia(midnight.toLocalDate());
        midnight= midnight.plusMonths(6);
        polizaDTO.setFechaFinVigencia(midnight.toLocalDate());
        polizaDTO.setEstadoPolizaPdf(true);
        polizaDTO.setPremio(calcularPremio());
        polizaDTO.setDerechoDeEmision(calcularDerechoEmision());
        polizaDTO.setDescuentos(calcularDescuentos());
        polizaDTO.setPrima(calcularPrima());
        polizaDTO.setCliente(currentPersona.getCliente());
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setAnioFabricacion(años.get(AñoVehiculoBox.getSelectedIndex()));
        vehiculoDTO.setChasis(chasisText.getText());
        vehiculoDTO.setModelo(modelos.get(ModeloBox.getSelectedIndex()));
        vehiculoDTO.setMotor(motorText.getText());
        vehiculoDTO.setPatente(patenteText.getText());
        vehiculoDTO.setKilometrosAnuales(Integer.parseInt(kmText.getText()));
        System.out.println(vehiculoDTO.toString());
        polizaDTO.setVehiculo(vehiculoDTO);
        String selectedLocalidadNombre = (String) LocalidadBox.getSelectedItem();
        Optional<LocalidadDTO> localidadOptional = currentPersona.getDireccion().stream()
                .filter(dir -> dir.getLocalidad().getNombre().equals(selectedLocalidadNombre))
                .map(DireccionDTO::getLocalidad)
                .findFirst();
        localidadOptional.ifPresent(localidad -> polizaDTO.setLocalidad(localidad));
        if(!fechaText1.getText().equals("Escriba aqui") || Sexo1.getSelectedIndex()>=0 || Civil1.getSelectedIndex()>=0){
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

    private Integer calcularPrima() {
        return 0;
    }

    private Integer calcularDescuentos() {
        return 0;
    }

    private Integer calcularDerechoEmision() {
        return 0;
    }

    private Integer calcularPremio() {
        return 0;
    }

    private Integer calcularSumaAsegurada() {
        return 0;
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
        if (motorText.getText().equals("Escriba aqui")){
            aviso+= " Motor,";
        }
        if(chasisText.getText().equals("Escriba aqui")){
            aviso+= " Chasis,";
        }
        if(patenteText.getText().equals("Escriba aqui")){
            aviso+= " Patente,";
        }
        if(kmText.getText().equals("Escriba aqui")){
            aviso+= " Km,";
        }
        if (siniestrosBox.getSelectedIndex()<0){
            aviso+= " Siniestros,";
        }

        String patronFecha = "\\d{4}-\\d{2}-\\d{2}";

        Pattern pattern = Pattern.compile(patronFecha);

        if(!fechaText1.getText().equals("Escriba aqui") || Sexo1.getSelectedIndex()>=0 || Civil1.getSelectedIndex()>=0) {
            String textoFecha = fechaText1.getText();

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
        if(garaje.isSelected()){
            MedidaSeguridadDTO garaje = new MedidaSeguridadDTO();
            garaje.setNombreMedida("garaje");
            garaje.setValorPorcentual(VALORGARAJE);
            currentPoliza.addMedida(garaje);
        }
        if(alarma.isSelected()){
            MedidaSeguridadDTO alarma = new MedidaSeguridadDTO();
            alarma.setNombreMedida("alarma");
            alarma.setValorPorcentual(VALORALARMA);
            currentPoliza.addMedida(alarma);
        }
        if (rastreador.isSelected()){
            MedidaSeguridadDTO rastreador = new MedidaSeguridadDTO();
            rastreador.setNombreMedida("rastreador");
            rastreador.setValorPorcentual(VALORRASTREADOR);
            currentPoliza.addMedida(rastreador);
        }
        if(tuercasAntirobo.isSelected()){
            MedidaSeguridadDTO tuercasAntirobo = new MedidaSeguridadDTO();
            tuercasAntirobo.setNombreMedida("Tuercas Antirobos");
            tuercasAntirobo.setValorPorcentual(VALORTUERCAS);
            currentPoliza.addMedida(tuercasAntirobo);
        }
        return aviso;
    }
    public JPanel getPantallaPrincipal() {
        return PanelPrincipal;
    }
    public void cargarDatos(){
        List<String> uniqueProvinces = currentPersona.getDireccion().stream()
                .map(direccionDTO -> direccionDTO.getLocalidad().getProvincia().getNombre())
                .distinct()
                .toList();
        uniqueProvinces.forEach(p->ProvComboBox.addItem(p));
        ProvComboBox.setSelectedIndex(-1);
    }
    public void createUIComponents() {
        cargarHijos();
        siniestrosBox = new JComboBox<>();
        for (int i = 0; i < 6; i++) {
            siniestrosBox.addItem(i);
        }
        siniestrosBox.setSelectedIndex(-1);
        hijosPanelPrincipal = new JPanel();
        tabbedPane1 = new JTabbedPane();
        modelos= GestorVehiculos.getModelos();
        marcas= GestorVehiculos.getMarcas();
        años= GestorVehiculos.getAños();
        ProvComboBox = new JComboBox<>();
        ProvComboBox.setSelectedIndex(-1);
        MarcaBox = new JComboBox<>();
        DefaultComboBoxModel<String> marcaComboBoxModel = new DefaultComboBoxModel<>();
        MarcaBox.setModel(marcaComboBoxModel);
        ModeloBox= new JComboBox<>();
        AñoVehiculoBox= new JComboBox<>();
        DefaultComboBoxModel<Integer> añoComboBoxModel = new DefaultComboBoxModel<>();
        AñoVehiculoBox.setModel(añoComboBoxModel);
        marcas.forEach(marcaDTO -> marcaComboBoxModel.addElement(marcaDTO.getNombreMarca()));
        MarcaBox.setSelectedIndex(-1);
        años.forEach(anioFabricacionDTO -> añoComboBoxModel.addElement(anioFabricacionDTO.getAnio()));
        AñoVehiculoBox.setSelectedIndex(-1);
        hijoPanel1 = new JPanel();
        hijoPanel2 = new JPanel();
        hijoPanel3 = new JPanel();
        hijoPanel4 = new JPanel();

        ProvComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Object selectedProvObject = ProvComboBox.getSelectedItem();
                    List<String> locSelecionadas = currentPersona.getDireccion().stream()
                            .filter(direccionDTO -> direccionDTO.getLocalidad().getProvincia().getNombre().equals(selectedProvObject))
                            .map(direccionDTO -> direccionDTO.getLocalidad().getNombre())
                            .distinct()
                            .toList();
                    DefaultComboBoxModel<String> locComboBoxModel = new DefaultComboBoxModel<>();
                    LocalidadBox.setModel(locComboBoxModel);
                    locSelecionadas.forEach(l -> locComboBoxModel.addElement(l));
                    LocalidadBox.setSelectedIndex(-1);
                }
            }
        });
        MarcaBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Object selectedMarcaObject = MarcaBox.getSelectedItem();
                    List<String> modSelecionadas = modelos.stream()
                            .filter(modeloDTO -> modeloDTO.getMarca().getNombreMarca().equals(selectedMarcaObject))
                            .map(modeloDTO -> modeloDTO.getNombreModelo())
                            .distinct()
                            .toList();
                    DefaultComboBoxModel<String> modComboBoxModel = new DefaultComboBoxModel<>();
                    ModeloBox.setModel(modComboBoxModel);
                    modSelecionadas.forEach(m -> modComboBoxModel.addElement(m));
                    ModeloBox.setSelectedIndex(-1);
                }
            }
        });
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

