package vista;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.ProductoView;
import negocio.VentaView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EscaneoProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField_codigoProducto;
	private JTextField textField_cantidad;
	private JTextField textField_nombreProducto;
	private JTextField textField_precio;
	private JTextField textField_codigoVenta;
	private JTextField textField_nombreCajero;

	public EscaneoProducto() {
		setTitle("Escaneo Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoProducto = new JLabel("Codigo Producto : ");
		lblCodigoProducto.setBounds(61, 169, 120, 14);
		contentPane.add(lblCodigoProducto);

		textField_codigoProducto = new JTextField();
		textField_codigoProducto.setBounds(241, 163, 130, 20);
		contentPane.add(textField_codigoProducto);
		textField_codigoProducto.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad : ");
		lblCantidad.setBounds(61, 385, 120, 14);
		contentPane.add(lblCantidad);

		textField_cantidad = new JTextField();
		textField_cantidad.setBounds(241, 382, 86, 20);
		contentPane.add(textField_cantidad);
		textField_cantidad.setColumns(10);

		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setEnabled(false);
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_codigoProducto.getText().isEmpty() || textField_cantidad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigoProducto, "Complete Producto, Precio y Cantidad");
				} else {

					try {

						// convierto String a int
						int cantidad = Integer.parseInt(textField_cantidad.getText());

						// Busco y muestro
						if (cantidad != 0) {

							ProductoView producto = Supermercado.getInstancia()
									.buscarProductoView(textField_codigoProducto.getText());

							if (producto.getEstado() != "2") {
							if ((producto.getStock() - cantidad) >= 0   ) {

								Supermercado.getInstancia().agregarItem(textField_codigoVenta.getText(),
										textField_codigoProducto.getText(), cantidad);

								float total = cantidad * producto.getPrecio();

								JOptionPane.showMessageDialog(textField_codigoVenta,
										"Producto agregado : " + textField_nombreProducto.getText() + " $ " + total);
								
								textField_nombreProducto.setText("");
								textField_precio.setText("");
								textField_cantidad.setText("");
								textField_codigoProducto.setText("");

							} else {
								JOptionPane.showMessageDialog(textField_codigoVenta,
										"Sin Stock suficiente, stock actual : " + producto.getStock());
							}
							} else {
								JOptionPane.showMessageDialog(null, "Producto dado de baja");
							}
						} else {

							JOptionPane.showMessageDialog(null, "Producto o Numero de venta no encontrado");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros cantidad", "",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
		btnAgregarProducto.setBounds(579, 249, 143, 23);
		contentPane.add(btnAgregarProducto);

		JButton btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigoProducto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigoProducto, "Complete Codigo de Producto");
				} else {
					ProductoView producto = Supermercado.getInstancia()
							.buscarProductoView(textField_codigoProducto.getText());
					// Busco y muestro
					if (producto != null && producto.getEstado() != "2") {

						textField_codigoProducto.setText(producto.getCodigo());
						contentPane.add(textField_codigoProducto);

						textField_nombreProducto.setText(producto.getDescripcion());
						contentPane.add(textField_nombreProducto);

						float precio = Supermercado.getInstancia().buscarProducto(textField_codigoProducto.getText())
								.getPrecio();
						textField_precio.setText(String.valueOf(precio));
						contentPane.add(textField_precio);

					} else {
						textField_nombreProducto.setText("");
						textField_precio.setText("");
						textField_codigoProducto.setText("");
						JOptionPane.showMessageDialog(null, "Producto no encontrado");
					}
				}
			}
		});
		btnBuscarProducto.setBounds(579, 169, 143, 23);
		contentPane.add(btnBuscarProducto);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(579, 383, 143, 23);
		contentPane.add(btnCerrar);

		textField_nombreProducto = new JTextField();
		textField_nombreProducto.setEditable(false);
		textField_nombreProducto.setColumns(10);
		textField_nombreProducto.setBounds(241, 207, 300, 20);
		contentPane.add(textField_nombreProducto);

		textField_precio = new JTextField();
		textField_precio.setEditable(false);
		textField_precio.setColumns(10);
		textField_precio.setBounds(241, 248, 156, 20);
		contentPane.add(textField_precio);

		JLabel lblNombreProducto = new JLabel("Nombre : ");
		lblNombreProducto.setBounds(103, 210, 156, 14);
		contentPane.add(lblNombreProducto);

		JLabel lblPrecio = new JLabel("Precio : ");
		lblPrecio.setBounds(111, 251, 46, 14);
		contentPane.add(lblPrecio);

		JLabel lblCodigoVenta = new JLabel("Codigo Venta :");
		lblCodigoVenta.setBounds(63, 43, 118, 14);
		contentPane.add(lblCodigoVenta);

		textField_codigoVenta = new JTextField();

		textField_codigoVenta.setBounds(241, 40, 130, 20);
		contentPane.add(textField_codigoVenta);
		textField_codigoVenta.setColumns(10);

		JButton btnBuscarVenta = new JButton("Buscar Venta");

		btnBuscarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigoVenta.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigoVenta, "Complete Codigo Venta");
				} else {
					// Busco y muestro
					VentaView venta = Supermercado.getInstancia().buscarVentaView(textField_codigoVenta.getText());
					if (venta != null) {

						if (venta.getEstado() == "1") {
							btnAgregarProducto.setEnabled(true);
							textField_codigoVenta.setEditable(false);

							textField_nombreCajero.setText(venta.getNombreCajero());
							contentPane.add(textField_nombreCajero);

						} else {
							JOptionPane.showMessageDialog(null, "Venta cerrada");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Venta no encontrada");
					}
				}
			}
		});
		btnBuscarVenta.setBounds(579, 43, 143, 23);
		contentPane.add(btnBuscarVenta);

		JLabel lblNombreCajero = new JLabel("Nombre Cajero: ");
		lblNombreCajero.setBounds(61, 85, 156, 14);
		contentPane.add(lblNombreCajero);

		textField_nombreCajero = new JTextField();
		textField_nombreCajero.setEditable(false);
		textField_nombreCajero.setColumns(10);
		textField_nombreCajero.setBounds(241, 82, 156, 20);
		contentPane.add(textField_nombreCajero);

		JLabel lblSimbolo = new JLabel("$");
		lblSimbolo.setBounds(226, 254, 13, 14);
		contentPane.add(lblSimbolo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/escaneo.png"));
		contentPane.add(lblNewLabel);
	}
}
