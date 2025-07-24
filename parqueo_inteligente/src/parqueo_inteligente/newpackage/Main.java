package parqueo_inteligente.newpackage;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteForm clienteForm = new ClienteForm();
            clienteForm.setClienteCreadoListener(cliente -> {
                VehiculoForm vehiculoForm = new VehiculoForm(cliente);
                vehiculoForm.setVisible(true);
            });
            clienteForm.setVisible(true);
        });
    }
}
