package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.ServiceLogger;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.undo.UndoableEditSupport;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAlta extends JPanel {

    // VINCULAMOS EL PANEL AL FRAME
    private FrameLogin framePadre;
    private JTextField user;
    private JTextField nameUser;
    private JTextField pass;
    private JTextField pass2;
    private JComboBox isAdmin;
    private JButton bEnviar;
    private JButton bLogin;
    private ServiceUser serviceUser = new ServiceUser();
    private ServiceLogger serviceLogger = new ServiceLogger();


    private MouseListener listenerMouseEnviar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            String userString;
            String nameUserString;
            String passString;
            String isAdminString;
            boolean administrador;
            userString=user.getText();
            nameUserString= nameUser.getName();
            passString=pass.getText();
            isAdminString=(String)isAdmin.getSelectedItem();

            if (isAdminString.equals("Si")){
                administrador=true;
            }else{
                administrador=false;
            }
            User usuario = new User(userString,nameUserString,passString,administrador);
            serviceUser.anadirFicheroUsers(usuario);
            serviceLogger.registrarLog(userString,"Alta","OK");
            System.out.println("Añadido el usuario.");
        }
    };

    private MouseListener listenerMouseLogin = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelLogin();
        }
    };


    public PanelAlta(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        JLabel eti = new JLabel("Panel ALTA");
        eti.setBounds(275,80,172,55);
        this.add(eti);

        JLabel usuario = new JLabel("Id:");
        usuario.setBounds(220,150,172,55);
        this.add(usuario);

        user = new JTextField();
        user.setBounds(250,168,172,20);
        this.add(user);

        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(185,180,172,55);
        this.add(nombre);

        nameUser = new JTextField();
        nameUser.setBounds(250,200,172,20);
        this.add(nameUser);

        JLabel contrasena = new JLabel("Contrasena:");
        contrasena.setBounds(165,210,172,55);
        this.add(contrasena);

        pass = new JTextField();
        pass.setBounds(250,230,172,20);
        this.add(pass);

        JLabel contrasena2 = new JLabel("Repetir contrasena:");
        contrasena2.setBounds(120,240,172,55);
        this.add(contrasena2);

        pass2 = new JTextField();
        pass2.setBounds(250,260,172,20);
        this.add(pass2);

        JLabel esAdmin = new JLabel("Es admin:");
        esAdmin.setBounds(180,270,172,55);
        this.add(esAdmin);

        isAdmin = new JComboBox<>();
        isAdmin.addItem("Si");
        isAdmin.addItem("No");
        isAdmin.setBounds(250,290,150,20);
        this.add(isAdmin);

        bEnviar = new JButton("Enviar");
        bEnviar.setBounds(180,400,100,50);
        bEnviar.setBackground(new Color(208, 223, 232));
        bEnviar.setBorder(new LineBorder(new Color(0,0,0), 2));
        bEnviar.addMouseListener(listenerMouseEnviar);
        this.add(bEnviar);


        bLogin = new JButton("Login");
        bLogin.setBounds(300,400,100,50);
        bLogin.setBackground(new Color(208, 223, 232));
        bLogin.setBorder(new LineBorder(new Color(0,0,0), 2));
        bLogin.addMouseListener(listenerMouseLogin);
        this.add(bLogin);
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
