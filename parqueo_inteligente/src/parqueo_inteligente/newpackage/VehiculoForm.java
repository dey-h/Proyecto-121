package parqueo_inteligente.newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;

public class VehiculoForm extends JFrame {
    private JTextField campoPlaca;
    private JTextField campoMarca;
    private JTextField campoColor;
    private JTextField campoTipo;
    private JTextField campoEspacio;
    private JButton botonGuardar;

    private Cliente propietario;

    public VehiculoForm(Cliente propietario) {
        this.propietario = propietario;



        setTitle("Formulario Vehículo");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel titulo = new JLabel("Ingrese sus datos");
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel header = new JPanel(new GridBagLayout());
        header.setBackground(new Color(70, 130, 180));
        GridBagConstraints headercont = new GridBagConstraints();
        headercont.gridx = 0;
        headercont.gridy = 0;
        headercont.gridwidth = 2;
        headercont.weightx = 1.0;
        headercont.weighty = 0.2;
        headercont.fill = GridBagConstraints.BOTH;
        header.add(titulo);
        add(header, headercont);
        JPanel div = new JPanel(new GridBagLayout());
        div.setBackground(new Color(70, 130, 180));
        div.setPreferredSize(new Dimension(500, 400));
        GridBagConstraints nroPlaca = new GridBagConstraints();
        nroPlaca.gridx = 0;
        nroPlaca.gridy = 0;
        nroPlaca.gridwidth = 2;
        nroPlaca.fill = GridBagConstraints.BOTH;
        nroPlaca.insets = new Insets(10, 10, 10, 10);
        div.add(new JLabel("Placa:"), nroPlaca);

        GridBagConstraints campoPl = new GridBagConstraints();
        campoPlaca = new JTextField();
        campoPl.gridx = 0;
        campoPl.gridy  = 1;
        campoPl.gridwidth = 2;
        campoPl.fill = GridBagConstraints.BOTH;
        campoPl.insets = new Insets(10, 10, 10, 10);
        div.add(campoPlaca, campoPl);
        GridBagConstraints marca = new GridBagConstraints();
        marca.gridx = 0;
        marca.fill = GridBagConstraints.BOTH;
        marca.insets = new Insets(10, 10, 10, 10);
        marca.gridy = 2;
        marca.gridwidth = 2;
        div.add(new JLabel("Marca:"), marca);
        marca.gridx = 0;
        marca.gridy = 3;
        marca.gridwidth = 2;
        marca.fill = GridBagConstraints.BOTH;
        marca.insets = new Insets(10, 10, 10, 10);
        campoMarca = new JTextField();
        div.add(campoMarca, marca);

        GridBagConstraints color = new GridBagConstraints();
        color.fill = GridBagConstraints.BOTH;
        color.insets = new Insets(10, 10, 10, 10);
        color.gridx = 0;
        color.gridy = 4;
        color.gridwidth= 2;
        div.add(new JLabel("Color:"), color);
        campoColor = new JTextField();
        color.gridx = 0;
        color.gridy = 5;
        color.gridwidth = 2;
        div.add(campoColor, color);

        GridBagConstraints tipoCampo = new GridBagConstraints();
        tipoCampo.fill = GridBagConstraints.BOTH;
        tipoCampo.insets = new Insets(10, 10, 10, 10);
        tipoCampo.gridx = 0;
        tipoCampo.gridy = 6;
        tipoCampo.gridwidth = 2;
        div.add(new JLabel("Tipo:"), tipoCampo);
        tipoCampo.gridx = 0;
        tipoCampo.gridy = 7;
        tipoCampo.gridwidth = 2;
        campoTipo = new JTextField();
        div.add(campoTipo, tipoCampo);

        GridBagConstraints espacio = new GridBagConstraints();
        espacio.fill = GridBagConstraints.BOTH;
        espacio.insets = new Insets(10, 10, 10, 10);
        espacio.gridx = 0;
        espacio.gridy = 8;
        espacio.gridwidth = 2;

        div.add(new JLabel("Espacio Asignado:"), espacio);
        GridBagConstraints campo = new GridBagConstraints();
        campo.fill = GridBagConstraints.BOTH;
        campo.insets = new Insets(10, 10, 10, 10);
        campo.gridx = 0;
        campo.gridy = 9;
        campo.gridwidth = 2;
        campoEspacio = new JTextField();
        div.add(campoEspacio, campo);

        botonGuardar = new JButton("Guardar Vehículo");
        GridBagConstraints button = new GridBagConstraints();
        button.fill = GridBagConstraints.BOTH;
        button.insets = new Insets(10, 10, 10, 10);
        button.gridx = 0;
        button. gridy = 10;
        button.gridwidth = 2;
        botonGuardar.addActionListener(e -> guardarVehiculo());
        div.add(botonGuardar, button);

        GridBagConstraints contenedor = new GridBagConstraints();
        contenedor.fill = GridBagConstraints.BOTH;
        contenedor.insets = new Insets(10, 10, 10, 10);
        contenedor.gridx = 0;
        contenedor.gridy = 1;
        contenedor.gridwidth = 2;
        contenedor.fill = GridBagConstraints.NONE;
        contenedor.anchor = GridBagConstraints.CENTER;
        contenedor.weightx = 1.0;
        contenedor.weighty = 0.8;

        add(div, contenedor);
    }

    private void guardarVehiculo() {
        try {
            String placa = campoPlaca.getText().trim();
            String marca = campoMarca.getText().trim();
            String color = campoColor.getText().trim();
            String tipo = campoTipo.getText().trim();
            String espacio = campoEspacio.getText().trim();

            if (placa.isEmpty() || marca.isEmpty() || color.isEmpty() || tipo.isEmpty() || espacio.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
                return;
            }

            Vehiculo vehiculo = new Vehiculo(placa, marca, color, propietario, tipo);
            vehiculo.asignarEspacio(espacio);
            vehiculo.registrarIngreso(LocalTime.now());

            propietario.setVehiculo(vehiculo);

            Connection conn = Conexion.conectar();
            String sql = "INSERT INTO vehiculo (placa, marca, color, propietario, tipo, espacioAsignado, horaIngreso) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getColor());
            stmt.setString(4, vehiculo.getPropietario().getNombre()); 
            stmt.setString(5, vehiculo.getTipo());
            stmt.setString(6, vehiculo.getEspacioAsignado());
            stmt.setString(7, vehiculo.getHoraIngreso().toString());

            stmt.executeUpdate();
            conn.close();
            

            JOptionPane.showMessageDialog(this, "Vehículo guardado correctamente.");
            this.dispose();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el vehículo en la base de datos.");
        }
    }
}