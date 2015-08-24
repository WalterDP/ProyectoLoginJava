package formularios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clases.Datos;
/**
 * Created by walter on 24/08/15.
 */
public class frmLogin extends JFrame {

    //OBJETOS DEL FORMULARIO
    private JLabel lblUsuario;
    private JLabel lblClave;
    private JLabel lblImagen;
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnAceptar;
    private JButton btnCancelar;

    //CONSTRUCTOR
    public frmLogin(){

        //PROPÌEDADES
        setTitle("Ingreso Al Sistema");
        setResizable(false);
        setSize(400, 190);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREAMOS LOS ICONOS
        Icon icoAceptar = new ImageIcon(getClass().getResource("/images/Apply.png"));
        Icon icoCancelar = new ImageIcon(getClass().getResource("/images/Close.png"));
        Icon icoImagen = new ImageIcon(getClass().getResource("/images/Home.png"));

        //CREAMOS OBJETOS DEL FORMULARIO
        lblUsuario = new JLabel("Usuario");
        txtUsuario = new JTextField(15);
        lblClave = new JLabel("Clave");
        txtClave = new JPasswordField(15);
        btnAceptar = new JButton("Aceptar",icoAceptar);
        btnCancelar = new JButton("Cancelar",icoCancelar);
        lblImagen = new JLabel(icoImagen);

        //DEFINIMOS PROPIEDADES DE LOS OBJETOS
        btnAceptar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAceptar.setToolTipText("Ingresa al sistema");
        btnCancelar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCancelar.setToolTipText("Cancele la operacion");


        //ADICIONAMOS OBJETOS AL FORMULARIO
        add(lblUsuario);
        add(txtUsuario);
        add(lblClave);
        add(txtClave);
        add(btnAceptar);
        add(btnCancelar);

        //UBICAMOS OBJETOS EN EL FORMULARIO

        lblUsuario.reshape     (20,20,100,20);
        txtUsuario.reshape     (120,20,100,20);
        lblImagen.reshape      (250,20,128,128);

        lblClave.reshape       (20,45,100,20);
        txtClave.reshape       (120,45,100,20);

        btnAceptar.reshape     (20,80,100,70);
        btnCancelar.reshape    (120,80,100,70);

        //ADICIONASMOS FUNCIONES A LOS BOTONES

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  btnAceptarActionPerformed(e);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarActionPerformed(e);
            }
        });
    }

    private void  btnAceptarActionPerformed(ActionEvent e){
        Datos misDatos = new Datos();
        if (!misDatos.validarUsuario(txtUsuario.getText(),new String (txtClave.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña no validos :( :( ");
            txtUsuario.setText("");
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }

        frmPrincipal miPrincipal = new frmPrincipal();
        setVisible(false);
        miPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        miPrincipal.setVisible(true);
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        //TERMINAMOS LA APLICACION
        System.exit(0);

    }
}
