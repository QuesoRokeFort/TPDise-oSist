package Interface;

import javax.swing.*;
import java.awt.*;

public class MenuCobrador {
    private JPanel PantallaPrincipal;
    private JButton registrosDePagoPolizaButton;
    private JButton cerrarSesionButton;
    private JPanel PanelMenu;

    public Component getPanel2() {
        return PantallaPrincipal;
    }

    public JButton getCerrarSesionButton() {
        return cerrarSesionButton;
    }
}
