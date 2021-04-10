package lib.sRAD.gui.sComponent;

import lib.sRAD.gui.component.MainBar;
import lib.sRAD.gui.component.Theme;
import lib.sRAD.gui.component.VentanaEmergente;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static lib.sRAD.gui.component.Resource.blackBorderTransparent;

public class SFrame extends JFrame {

    //ajustes pre-establecidos
    public static final int ESTANDAR = 1; //configuración que uso en mis proyectos

    /**
     * Constructor especializado
     * @param type
     */
    public SFrame(int type) {
        setProperties(type);
    }

    /**
     * Constructor de javax.swing.JFrame
     */
    public SFrame() {
        super();
    }

    /**
     * Create a new decorated frame
     * @param width width of frame
     * @param height height of frame
     */
    public SFrame(int width, int height) {
        setProperties(width, height, Theme.fBg, true, blackBorderTransparent, null, true);
    }

    public void setProperties(int type) {
        if(type == ESTANDAR) {
            setProperties();
        }
    }

    /**
     * Default properties of frame
     */
    public void setProperties() {
        setProperties(1280, 720, Theme.fBg, true, blackBorderTransparent, null, true);
    }

    public void setProperties(int width, int height) {
        setProperties(width, height, Theme.fBg, true, blackBorderTransparent, null);
    }

    public void setProperties(int width, int height, Color background) {
        setProperties(width, height, background, true, blackBorderTransparent, null);
    }

    public void setProperties(int width, int height, Color background, Boolean undecorated, Border border, Component relativeLocation) {
        setSize(width, height);
        getContentPane().setBackground(background);
        setUndecorated(undecorated);
        rootPane.setBorder(border);
        setLocationRelativeTo(relativeLocation);
        setLayout(null);
    }

    public void setProperties(int width, int height, Color background, Boolean undecorated, Border border, Component relativeLocation,
                              Boolean visible) {
        setProperties(width, height, background, undecorated, border, relativeLocation);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(visible);
    }

    public void setMainBar(String title) {
        setMainBar(title, "resources/sRAD/exampleLogo.png");
    }

    public void setMainBar(String title, String pathLogo) {
        MainBar mainBar = new MainBar(this);
        mainBar.setTitle(title);
        mainBar.setLogo(new ImageIcon(pathLogo));
        add(mainBar);
        repaint();
    }

}
