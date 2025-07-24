package parqueo_inteligente.newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClienteForm extends JFrame {
    private JTextField campoNombre;
    private JButton botonGuardar;

    public interface ClienteCreadoListener {
        void clienteCreado(Cliente cliente);
    }

    private ClienteCreadoListener clienteCreadoListener;

    public void setClienteCreadoListener(ClienteCreadoListener listener) {
        this.clienteCreadoListener = listener;
    }

    public ClienteForm() {
        setTitle("Formulario Cliente");
        setSize(  700, 500);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.BLUE);


        JLabel titulo  = new JLabel ("Parqueo Inteligente");
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel header = new JPanel();
        header.add(titulo);
        header.setBackground(new Color (70, 130, 180));
        GridBagConstraints headerLineal = new GridBagConstraints();
        headerLineal.fill = GridBagConstraints.BOTH;
        headerLineal.gridx = 0;
        headerLineal.gridy = 0;
        headerLineal.gridwidth = 2;
        headerLineal.weightx = 1.0;
        headerLineal.weighty = 0.2;

        header.add(titulo);

        add(header, headerLineal);

        JPanel div = new JPanel(new GridBagLayout());
        div.setBackground(new Color(70, 130, 180));
        div.setPreferredSize(new Dimension(600, 300));

        GridBagConstraints nombre = new GridBagConstraints();
        nombre.fill = GridBagConstraints.HORIZONTAL;
        nombre.insets = new Insets(10, 10, 10, 10);
        nombre.anchor = GridBagConstraints.CENTER;
        nombre.gridx  = 0;
        nombre.gridy = 0;
        nombre.gridwidth = 2;
        JLabel nombreLabel = new JLabel("ingrese su nombre: ");
        nombreLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        nombreLabel.setForeground(Color.white);
        div.add(nombreLabel, nombre);

        campoNombre = new JTextField();
        nombre.gridx = 0;
        nombre.gridy = 1;
        nombre.gridwidth = 2;
        campoNombre.setPreferredSize(new Dimension(300, 30));
        div.add(campoNombre, nombre);

        botonGuardar = new JButton("Guardar Cliente");
        GridBagConstraints buton = new GridBagConstraints();
        buton.fill = GridBagConstraints.HORIZONTAL;
        buton.insets = new Insets(10, 10, 10, 10);
        buton.gridx = 0;
        buton.gridy = 2;
        buton.gridwidth  =2;
        botonGuardar.setPreferredSize(new Dimension(300, 30));
        botonGuardar.addActionListener(e -> guardarCliente());
       div.add(botonGuardar, buton);

       GridBagConstraints contenedor = new GridBagConstraints();
       contenedor.gridx = 0;
       contenedor.gridy = 1;
       contenedor.gridwidth = 2;
       contenedor.weightx = 1.0;
       contenedor.weighty = 0.8;
       contenedor.fill = GridBagConstraints.NONE;
       contenedor.anchor = GridBagConstraints.CENTER;

       add(div, contenedor);
    }

    private void guardarCliente() {
        try {
            String nombre = campoNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.");
                return;
            }

            Cliente cliente = new Cliente(nombre, null);

            if (clienteCreadoListener != null) {
                clienteCreadoListener.clienteCreado(cliente);
            }

            JOptionPane.showMessageDialog(this, "Cliente guardado correctamente.");
            this.dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el cliente.");
        }
    }
}