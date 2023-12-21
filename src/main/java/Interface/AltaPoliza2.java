package Interface;

import DTO.*;
import Gestores.GestorDirrecciones;
import Gestores.GestorPoliza;
import Hibernate.Model.*;
import com.toedter.calendar.JCalendar;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
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

    private JComboBox Sexo1;
    private JComboBox Civil1;

    private JComboBox Sexo2;
    private JComboBox Civil2;

    private JComboBox Sexo3;
    private JComboBox Civil3;

    private JComboBox Sexo4;
    private JComboBox Civil4;
    private JButton plusHijo2;
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
    private JLabel SumaAseguradaText;
    private JPanel fecha1Panel;
    private JPanel fecha2Panel;
    private JPanel fecha3Panel;
    private JPanel fecha4Panel;
    private List<ModeloDTO> modelos=new ArrayList<>();
    private List<MarcaDTO> marcas=new ArrayList<>();
    private List<AnioFabricacionDTO> años=new ArrayList<>();
    List<LocalidadDTO> locSelecionadas = new ArrayList<>();
    static VehiculoDTO vehiculoDTO;
    static LocalidadDTO localidad;
    private boolean bloquearCargaAño = false;
    private boolean bloquearCargaLoc = false;
    private boolean bloquearCargaMod = false;
    List<ProvinciaDTO> uniqueProvinces= new ArrayList<>();
    static String medidasSeg = "";
    private JCalendar calendar;
    private JCalendar calendar2;
    private JCalendar calendar3;
    private JCalendar calendar4;



    public AltaPoliza2() {
        plusHijo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabbedPane1.isEnabledAt(0)){
                    if (tabbedPane1.isEnabledAt(1)){
                        if (tabbedPane1.isEnabledAt(2)){
                            tabbedPane1.setEnabledAt(3, true);
                        }else {
                            tabbedPane1.setEnabledAt(2, true);
                        }
                    }else {
                        tabbedPane1.setEnabledAt(1, true);
                    }
                }else {
                    tabbedPane1.setEnabledAt(0,true);
                }
            }
        });
        closeHijo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabbedPane1.isEnabledAt(3)) {
                    tabbedPane1.setEnabledAt(3, false);
                } else if (tabbedPane1.isEnabledAt(2)) {
                    tabbedPane1.setEnabledAt(2, false);
                } else if (tabbedPane1.isEnabledAt(1)) {
                    tabbedPane1.setEnabledAt(1, false);
                } else if (tabbedPane1.isEnabledAt(0)) {
                    tabbedPane1.setEnabledAt(0, false);
                }
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
                    JOptionPane.showMessageDialog(null,aviso,"Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                        locSelecionadas = new ArrayList<>(GestorDirrecciones.getLocalidadesByProvincia(selectedProv));
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
        AñoVehiculoBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SumaAseguradaText.setText(String.valueOf(GestorPoliza.calcularSumaAsegurada(vehiculoDTO)));
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
        if(garaje.isSelected()){
            medidasSeg +="1";
        }else {
            medidasSeg +="0";
        }
        if(alarma.isSelected()){
            medidasSeg +="1";
        }else {
            medidasSeg +="0";
        }
        if (rastreador.isSelected()){
            medidasSeg +="1";
        }else {
            medidasSeg +="0";
        }
        if(tuercasAntirobo.isSelected()){
            medidasSeg +="1";
        }else {
            medidasSeg +="0";
        }
        polizaDTO.setDerechoDeEmision(GestorPoliza.calcularDerechoEmision());
        String selectedLocalidadNombre = (String) LocalidadBox.getSelectedItem();
        localidad =  locSelecionadas.stream().filter(localidadDTO -> localidadDTO.getNombre().equals(selectedLocalidadNombre)).findFirst().orElse(null);
        if (tabbedPane1.isEnabledAt(0)) {
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo1.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil1.getSelectedItem());
            Date fecha = calendar.getDate();
            hijoDTO.setFechaDeNacimiento(fecha);
            polizaDTO.addHijo(hijoDTO);
        }
        if(tabbedPane1.isEnabledAt(1)){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo2.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil2.getSelectedItem());
            Date fecha = calendar2.getDate();
            hijoDTO.setFechaDeNacimiento(fecha);
            polizaDTO.addHijo(hijoDTO);
        }
        if(tabbedPane1.isEnabledAt(2)){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo3.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil3.getSelectedItem());
            Date fecha = calendar3.getDate();
            hijoDTO.setFechaDeNacimiento(fecha);
            polizaDTO.addHijo(hijoDTO);
        }
        if(tabbedPane1.isEnabledAt(3)){
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexoHijo((Sexo) Sexo4.getSelectedItem());
            hijoDTO.setEstadoCivil((EstadoCivil) Civil4.getSelectedItem());
            Date fecha = calendar4.getDate();
            hijoDTO.setFechaDeNacimiento(fecha);
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
        if (motorText.getText().equals("")||motorText.getText().length()>20){
            aviso+= " Motor,";
        }
        if(chasisText.getText().equals("")||chasisText.getText().length()>20){
            aviso+= " Chasis,";
        }
        if(patenteText.getText().equals("")||patenteText.getText().length()>20){
            aviso+= " Patente,";
        }
        if (GestorPoliza.patenteDuplicada(patenteText.getText())){
            aviso+=" Patente Ya Existente,";
        }
        if(kmText.getText().equals("")||kmText.getText().length()>20|| !kmText.getText().matches("\\d+")){
            aviso+= " Km,";
        }
        if (siniestrosBox.getSelectedIndex()<0){
            aviso+= " Siniestros,";
        }


        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, -18);
        Calendar thirtyYearsAgo = Calendar.getInstance();
        thirtyYearsAgo.add(Calendar.YEAR, -30);
        if (tabbedPane1.isEnabledAt(0)) {
            Date selectedDate = calendar.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
            Date selectedDate2 = calendar2.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate2);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
            Date selectedDate3 = calendar3.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate3);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
            Date selectedDate4 = calendar4.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate4);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
    /*private String validateDataEspesificado() {
        String aviso="Error en:";
        if (ProvComboBox.getSelectedIndex()<0){
            aviso+= " Provincia, campo vacio";
        }
        if (LocalidadBox.getSelectedIndex()<0){
            aviso+= " Localidad, campo vacio";
        }
        if (MarcaBox.getSelectedIndex()<0){
            aviso+= " Marca, campo vacio";
        }
        if (ModeloBox.getSelectedIndex()<0){
            aviso+= " Modelo, campo vacio";
        }
        if (AñoVehiculoBox.getSelectedIndex()<0){
            aviso+= " AñoVehiculo, campo vacio";
        }
        if (motorText.getText().equals("")){
            aviso+= " Motor, campo vacio";
        }else if(motorText.getText().length()>20) {
            aviso += " Motor, campo mayor a 20 caracteres";
        }
        if(chasisText.getText().equals("")){
            aviso+= " Chasis, campo vacio";
        }else if(chasisText.getText().length()>20){
            aviso+= " Chasis, campo mayor a 20 caracteres";
        }
        if(patenteText.getText().equals("")){
            aviso+= " Patente, campo vacio";
        }else if(patenteText.getText().length()>20){
            aviso+= " Patente, campo mayor a 20 caracteres";
        }
        if (GestorPoliza.patenteDuplicada(patenteText.getText())){
            aviso+=" Patente Ya Existente";
        }
        if(kmText.getText().equals("")){
            aviso+= " Km, campo vacio";
        }else if(kmText.getText().length()>20){
            aviso+= " Km, campo mayor a 20 caracteres";
        }else if(!kmText.getText().matches("\\d+")){
            aviso+= " Km, campo solo acepta numeros";
        }
        if (siniestrosBox.getSelectedIndex()<0){
            aviso+= " Siniestros, campo vacio";
        }


        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, -18);
        Calendar thirtyYearsAgo = Calendar.getInstance();
        thirtyYearsAgo.add(Calendar.YEAR, -30);
        if (tabbedPane1.isEnabledAt(0)) {
            Date selectedDate = calendar.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
                aviso += " Fecha Hijo1, no cumple formato";
            }
            if (Sexo1.getSelectedIndex() < 0) {
                aviso += " Sexo Hijo1, campo vacio";
            }
            if (Civil1.getSelectedIndex() < 0) {
                aviso += " Estado Civil Hijo1, campo vacio";
            }
        }
        if (tabbedPane1.isEnabledAt(1)) {
            Date selectedDate2 = calendar2.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate2);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
            Date selectedDate3 = calendar3.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate3);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
            Date selectedDate4 = calendar4.getDate();
            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate4);
            if (!dob.after(thirtyYearsAgo) || !dob.before(now)) {
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
    }*/

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
        fecha1Panel = new JPanel();
        calendar = new JCalendar();
        fecha1Panel.add(calendar, Component.CENTER_ALIGNMENT);
        fecha2Panel = new JPanel();
        calendar2 = new JCalendar();
        fecha2Panel.add(calendar2, Component.CENTER_ALIGNMENT);
        calendar3 = new JCalendar();
        fecha3Panel = new JPanel();
        fecha3Panel.add(calendar3, Component.CENTER_ALIGNMENT);
        calendar4 = new JCalendar();
        fecha4Panel = new JPanel();
        fecha4Panel.add(calendar4, Component.CENTER_ALIGNMENT);
    }

    private void cargarHijos() {
        Sexo[] sexoValues = Sexo.values();
        Arrays.sort(sexoValues, (s1, s2) -> s1.name().compareTo(s2.name()));
        EstadoCivil[] CivilValues = EstadoCivil.values();
        Arrays.sort(CivilValues, (s1, s2) -> s1.name().compareTo(s2.name()));
        Sexo1 = new JComboBox<>(sexoValues);
        Sexo1.setSelectedIndex(-1);
        Sexo1.setFocusable(false);
        Civil1 = new JComboBox<>(CivilValues);
        Civil1.setSelectedIndex(-1);
        Civil1.setFocusable(false);
        Sexo2 = new JComboBox<>(sexoValues);
        Sexo2.setSelectedIndex(-1);
        Civil2 = new JComboBox<>(CivilValues);
        Civil2.setSelectedIndex(-1);
        Sexo3 = new JComboBox<>(sexoValues);
        Sexo3.setSelectedIndex(-1);
        Civil3 = new JComboBox<>(CivilValues);
        Civil3.setSelectedIndex(-1);
        Sexo4 = new JComboBox<>(sexoValues);
        Sexo4.setSelectedIndex(-1);
        Civil4 = new JComboBox<>(CivilValues);
        Civil4.setSelectedIndex(-1);
    }


}

