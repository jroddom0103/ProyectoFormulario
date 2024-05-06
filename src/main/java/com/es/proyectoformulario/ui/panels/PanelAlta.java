package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;

public class PanelAlta extends JPanel {

    // VINCULAMOS EL PANEL AL FRAME
    private FrameLogin framePadre;

    JTextField textFieldUser;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;

    JButton botonHide;

    public PanelAlta(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(0,255,0));
        this.setLayout(null);

        JLabel eti = new JLabel("Panel ALTA");
        eti.setBounds(100,100,100,32);
        this.add(eti);

        botonHide = new JButton("Ocultar");
        botonHide.setBounds(100,300, 100, 32);
        this.add(botonHide);

    }


}
