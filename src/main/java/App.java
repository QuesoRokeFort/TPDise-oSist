import Interface.GestorInterface;

import javax.swing.*;

//Backdoor profiles
// gerente mail ("gerente@gmail.com");
// gerente contra("gerente");

// cobrador mail ("cobrador@gmail.com");
// cobrador contra("cobrador");

// PRODUCTOR_SEGURO mail("prodSeguro@gmail.com");
// PRODUCTOR_SEGURO contra("prodSeguro");
//

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



    public App() {
        GestorInterface.AccesoUsuario();
    }
}

