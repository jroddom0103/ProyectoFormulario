package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelOpciones extends JPanel {

    private FrameLogin framePadre;

    private JButton botonAlta, botonBaja, botonModificar, botonConsultar;

    private MouseListener listenerMouseAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Alta pulsado");
            cargarPanelAlta();
        }
    };

    private MouseListener listenerMouseBaja = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Baja pulsado");
            cargarPanelLogin();
        }
    };

    private MouseListener listenerMouseModificar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Alta pulsado");
            cargarPanelAlta();
        }
    };

    private MouseListener listenerMouseConsultar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Alta pulsado");
            cargarPanelAlta();
        }
    };

    public PanelOpciones(FrameLogin framePadre) {

        this.framePadre = framePadre;
        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        botonAlta = new JButton("Alta");
        botonBaja = new JButton("Baja");
        botonModificar = new JButton("Modificar");
        botonConsultar = new JButton("Consultar");

        this.setBackground(new Color(0xDFDCDC));
        this.botonAlta.setBackground(new Color(0xC0DDB8));
        this.botonBaja.setBackground(new Color(0xEA8484));
        this.botonModificar.setBackground(new Color(0xD8B969));
        this.botonConsultar.setBackground(new Color(0x69B0D8));

        this.botonAlta.setBounds(200, 100, 130, 32);
        this.botonBaja.setBounds(200, 200, 130, 32);
        this.botonModificar.setBounds(200, 300, 130, 32);
        this.botonConsultar.setBounds(200, 400, 130, 32);

        botonAlta.addMouseListener(listenerMouseAlta);


        this.add(botonAlta);
        this.add(botonBaja);
        this.add(botonModificar);
        this.add(botonConsultar);


    }

    private void cargarPanelAlta() {
        // ELIMINAMOS THIS PanelLogin
        framePadre.remove(this);

        // AÑADIMOS UN PANEL ALTA AL ¡¡¡FRAME!!!
        PanelAlta panelAlta = new PanelAlta(framePadre);
        framePadre.add(panelAlta);

        // ULTIMO: REPINTAR EL FRAME
        framePadre.repaint();
        framePadre.revalidate();

    }

    private void cargarPanelLogin() {
        // ELIMINAMOS THIS PanelLogin
        framePadre.remove(this);

        // AÑADIMOS UN PANEL ALTA AL ¡¡¡FRAME!!!
        PanelLogin panelLogin = new PanelLogin(framePadre);
        framePadre.add(panelLogin);

        // ULTIMO: REPINTAR EL FRAME
        framePadre.repaint();
        framePadre.revalidate();

    }
}
