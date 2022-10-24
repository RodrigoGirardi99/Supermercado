package vista;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.ProveedorView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_cuit;
	private JTextField textField_razonSocial;

	public EliminarProveedor() {
		setTitle("Eliminar Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCuit = new JLabel("Cuit : ");
		lblCuit.setToolTipText("");
		lblCuit.setBounds(46, 78, 124, 14);
		contentPane.add(lblCuit);

		JLabel lblRazonSocial = new JLabel("Razon Social :");
		lblRazonSocial.setBounds(46, 162, 124, 14);
		contentPane.add(lblRazonSocial);

		textField_cuit = new JTextField();
		textField_cuit.setBounds(212, 75, 150, 20);
		contentPane.add(textField_cuit);
		textField_cuit.setColumns(10);

		textField_razonSocial = new JTextField();
		textField_razonSocial.setEditable(false);
		textField_razonSocial.setBounds(212, 159, 300, 20);
		contentPane.add(textField_razonSocial);
		textField_razonSocial.setColumns(10);

		JButton btnEliminarProveedor = new JButton("Eliminar Proveedor");
		btnEliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_cuit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_cuit, "Complete el campo CUIT");
				} else {
					ProveedorView proveedor = Supermercado.getInstancia().buscarProveedorView(textField_cuit.getText());
					if (proveedor != null && proveedor.getEstado() != "2") {
						
						if (proveedor.getEstado() == "0") {

							if (JOptionPane.showConfirmDialog(btnEliminarProveedor,
									"¿Esta seguro de eliminar el proveedor?", "Salir", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

								Supermercado.getInstancia().BorrarProveedor(textField_cuit.getText());
								JOptionPane.showMessageDialog(null, "Proveedor eliminado fisicamente");
							}
						} else {

							String estado = "2";
							Supermercado.getInstancia().ActualizoProveedorB(textField_cuit.getText(), estado);
							JOptionPane.showMessageDialog(null,
									"Proveedor con productos asociados, se elimina logicamente");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
					}
				}
			}
		});
		btnEliminarProveedor.setBounds(578, 248, 150, 23);
		contentPane.add(btnEliminarProveedor);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(578, 382, 150, 23);
		contentPane.add(btnCerrar);

		JButton btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_cuit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_cuit, "Complete el campo CUIT");
				} else {
					ProveedorView proveedor = Supermercado.getInstancia().buscarProveedorView(textField_cuit.getText());
					if (proveedor != null && proveedor.getEstado() != "2") {

						textField_cuit.setText(proveedor.getCuit());
						textField_razonSocial.setText(proveedor.getRazonSocial());

					} else {
						JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
					}

				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(212, 248, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/proveedor.png"));
		contentPane.add(lblNewLabel);

		btnBuscarProveedor.setBounds(578, 114, 150, 23);
		contentPane.add(btnBuscarProveedor);
	}
}
