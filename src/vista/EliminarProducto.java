package vista;


import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.ProductoView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField_codigo;
	private JTextField textField_descripcion;

	public EliminarProducto() {
		setTitle("Eliminar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCuit = new JLabel("Codigo : ");
		lblCuit.setToolTipText("");
		lblCuit.setBounds(46, 78, 124, 14);
		contentPane.add(lblCuit);

		JLabel lblDescripcion = new JLabel("Descripcion :");
		lblDescripcion.setBounds(46, 162, 124, 14);
		contentPane.add(lblDescripcion);

		textField_codigo = new JTextField();
		textField_codigo.setBounds(212, 75, 150, 20);
		contentPane.add(textField_codigo);
		textField_codigo.setColumns(10);

		textField_descripcion = new JTextField();
		textField_descripcion.setEditable(false);
		textField_descripcion.setBounds(212, 159, 300, 20);
		contentPane.add(textField_descripcion);
		textField_descripcion.setColumns(10);

		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigo, "Complete el campo CODIGO");
				} else {
					ProductoView producto = Supermercado.getInstancia().buscarProductoView(textField_codigo.getText());
					if (producto != null && producto.getEstado() != "2") {

						if (producto.getEstado() == "0") {

							if (JOptionPane.showConfirmDialog(btnEliminarProducto,
									"¿Esta seguro de eliminar el producto?", "Salir", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
								Supermercado.getInstancia().BorrarProducto(textField_codigo.getText());

								JOptionPane.showMessageDialog(null, "Producto eliminado fisicamente");
							}

						} else {
							String estado = "2";
							Supermercado.getInstancia().ActualizoProductoB(textField_codigo.getText(), estado);

							JOptionPane.showMessageDialog(null,
									"Producto con ventas asociadas, se elimina logicamente");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Producto no encontrado");
					}
				}
			}
		});
		btnEliminarProducto.setBounds(666, 245, 150, 23);
		contentPane.add(btnEliminarProducto);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(666, 379, 150, 23);
		contentPane.add(btnCerrar);

		JButton btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigo, "Complete el campo CODIGO");
				} else {
					ProductoView producto = Supermercado.getInstancia().buscarProductoView(textField_codigo.getText());
					if (producto != null && producto.getEstado() != "2") {

						textField_codigo.setText(producto.getCodigo());
						textField_descripcion.setText(producto.getDescripcion());

					} else {
						textField_descripcion.setText("");
						JOptionPane.showMessageDialog(null, "Producto no encontrado");

					}

				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(212, 245, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/producto.png"));
		contentPane.add(lblNewLabel);
		
		btnBuscarProducto.setBounds(666, 111, 150, 23);
		contentPane.add(btnBuscarProducto);
	}
}
