package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.GestionFicheroUser;
import com.es.proyectoformulario.services.impl.ServiceLogger;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelConsultar extends JPanel {

    // VINCULAMOS EL PANEL AL FRAME
    private FrameLogin framePadre;
    private JTextField user;
    private JTextField nameUser;
    private JTextField pass;
    private JTextField pass2;
    private JComboBox isAdmin;
    private JButton bAtras;
    private JButton bConsultar;
    private ServiceUser serviceUser = new ServiceUser();
    private ServiceLogger serviceLogger = new ServiceLogger();
    private String ruta = "src/main/resources/users/users.txt";


    private MouseListener listenerMouseConsultar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            User user1 = serviceUser.obtenerUsuario(user.getText());
            

        }
    };

    private MouseListener listenerMouseOpciones = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelOpciones();
        }
    };


    public PanelConsultar(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        JLabel eti = new JLabel("Panel CONSULTAR");
        eti.setBounds(275, 80, 172, 55);
        this.add(eti);

        JLabel usuario = new JLabel("Id:");
        usuario.setBounds(220, 150, 172, 55);
        this.add(usuario);

        user = new JTextField();
        user.setBounds(250, 168, 172, 20);
        this.add(user);

        JLabel informacion = new JLabel();
        informacion.setBounds(200,190,200,200);
        this.add(informacion);

        bAtras = new JButton("Atras");
        bAtras.setBounds(40, 500, 100, 50);
        bAtras.setBackground(new Color(208, 223, 232));
        bAtras.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        bAtras.addMouseListener(listenerMouseOpciones);
        this.add(bAtras);

        bConsultar = new JButton("Consultar");
        bConsultar.setBounds(280, 200, 100, 50);
        bConsultar.setBackground(new Color(208, 223, 232));
        bConsultar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        bConsultar.addMouseListener(listenerMouseConsultar);
        this.add(bConsultar);
    }

    private void cargarPanelOpciones() {
        // ELIMINAMOS THIS PanelLogin
        framePadre.remove(this);

        // AÑADIMOS UN PANEL ALTA AL ¡¡¡FRAME!!!
        PanelOpciones panelOpciones = new PanelOpciones(framePadre);
        framePadre.add(panelOpciones);

        // ULTIMO: REPINTAR EL FRAME
        framePadre.repaint();
        framePadre.revalidate();

    }
}

