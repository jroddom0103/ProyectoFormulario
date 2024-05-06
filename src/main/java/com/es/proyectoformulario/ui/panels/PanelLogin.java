package com.es.proyectoformulario.ui.panels;


import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Pablo Macías
 */
public class PanelLogin extends JPanel {
    private JTextField user;
    private JTextField pass;
    private JButton bEnviar;
    private JButton bAlta;

    // Este es el FramePadre de este panel
    private FrameLogin framePadre;

    private ServiceUser serviceUser = new ServiceUser();

    private MouseListener listenerMouseCambiarAspecto = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(208, 223, 232)); // Fondo azul medio
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBorder(new LineBorder(new Color(0, 115, 183), 2)); // Borde azul oscuro
        }
    };

    private MouseListener listenerMouseEnviar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (serviceUser.checkUser(user.getText(), pass.getText())) {
                System.out.println("Esta registrado");

            } else {
                System.out.println("Pa tu casa");
            }
        }
    };

    private MouseListener listenerMouseAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("Alta pulsado");
            cargarPanelAlta();

        }
    };


    public PanelLogin(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(174, 139, 225));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(200, 135));
        usuario.setSize(new Dimension(152, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(usuario);

        user = new JTextField("Introduzca su usuario");
        user.setLocation(new Point(260, 135));
        user.setSize(new Dimension(152, 32));
        this.add(user);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200, 200));
        passwd.setSize(new Dimension(152, 32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260, 200));
        pass.setSize(new Dimension(152, 32));
        this.add(pass);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(120, 321));
        bEnviar.setSize(new Dimension(152, 32));
        bEnviar.setBackground(new Color(208, 223, 232)); // Fondo azul medio
        bEnviar.setBorder(new LineBorder(new Color(135, 206, 250), 2)); // Borde azul claro
        bEnviar.addMouseListener(listenerMouseEnviar);
        bEnviar.addMouseListener(listenerMouseCambiarAspecto);
        this.add(bEnviar);


        bAlta = new JButton("Alta");
        bAlta.setLocation(new Point(320, 321));
        bAlta.setSize(new Dimension(152, 32));
        bAlta.setBackground(new Color(208, 223, 232));
        bAlta.setBorder(new LineBorder(new Color(135, 206, 250), 2)); // Borde azul claro
        // Añadimos el mouseListener
        bAlta.addMouseListener(listenerMouseAlta);
        this.add(bAlta);

    }

    private void cargarPanelAlta() {
        // ELIMNAMOS THIS PanelLogin... este... no otro.
        framePadre.remove(this);

        // AÑADIMOS UN PANEL ALTA AL ¡¡¡FRAME!!!
        PanelAlta panelAlta = new PanelAlta(framePadre);
        framePadre.add(panelAlta);

        // ULTIMO: REPINTAR EL FRAME
        framePadre.repaint();
        framePadre.revalidate();

    }

}
