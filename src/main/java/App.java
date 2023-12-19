import DTO.MedidaSeguridadDTO;
import DTO.PolizaDTO;
import Hibernate.Dao.*;
import Hibernate.Model.*;
import Interface.GestorInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Random;

//Backdoor profiles
// gerente mail ("gerente@gmail.com");
// gerente contra("gerente");

// cobrador mail ("cobrador@gmail.com");
// cobrador contra("cobrador");

// PRODUCTOR_SEGURO mail("prodSeguro@gmail.com");
// PRODUCTOR_SEGURO contra("prodSeguro");
//
import java.awt.BorderLayout;
import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;

public class App {

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("Metal");
            } catch (Exception e) {
                e.printStackTrace();
            }
            new App();
        });
    }
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing Calendar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JCalendar
        JCalendar calendar = new JCalendar();

        // Create a JButton
        JButton readButton = new JButton("Read Date");

        // Add ActionListener to the button
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected date from the JCalendar
                Date selectedDate = calendar.getDate();

                // Print the selected date (you can do whatever you want with the date)
                System.out.println("Selected Date: " + selectedDate);
            }
        });

        // Add the JCalendar and JButton to the frame
        frame.getContentPane().add(calendar, BorderLayout.CENTER);
        frame.getContentPane().add(readButton, BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/



    public App() {
        GestorInterface.AccesoUsuario();
        //GestorInterface.panelCargaCliente();
    }
}

