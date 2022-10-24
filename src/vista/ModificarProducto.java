package vista;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.ProductoView;
import negocio.Proveedor;
import negocio.ProveedorView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarProducto extends JFrame {

	protected static final Object[] Proveedor = null;
	private JPanel contentPane;
	private JTextField textField_codigo;
	private JTextField textField_descripcion;
	private JTextField textField_marca;
	private JTextField textField_precio;
	private JTextField textField_stockMinimo;
	private JTextField textField_stock;
	private JTextField textField_estado;
	private JTextField textField_cuit;
	private JTextField textField_razonSocial;
	private JTextField textField_pedidoReposicion;

	public ModificarProducto() {
		setTitle("Modificar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setBounds(46, 38, 121, 14);
		contentPane.add(lblCodigo);

		JLabel lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setBounds(46, 90, 121, 14);
		contentPane.add(lblDescripcion);

		JLabel lblMarca = new JLabel("Marca : ");
		lblMarca.setBounds(46, 194, 121, 14);
		contentPane.add(lblMarca);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(46, 246, 121, 14);
		contentPane.add(lblPrecio);

		JLabel lblStockMinimo = new JLabel("Stock Minimo : ");
		lblStockMinimo.setBounds(46, 298, 121, 14);
		contentPane.add(lblStockMinimo);

		JLabel lblStock = new JLabel("Stock :  ");
		lblStock.setBounds(46, 402, 121, 14);
		contentPane.add(lblStock);

		JLabel lblEstado = new JLabel("Estado : ");
		lblEstado.setBounds(46, 454, 121, 14);
		contentPane.add(lblEstado);

		textField_codigo = new JTextField();
		textField_codigo.setBounds(177, 33, 150, 20);
		contentPane.add(textField_codigo);
		textField_codigo.setColumns(10);

		textField_descripcion = new JTextField();
		textField_descripcion.setBounds(177, 86, 300, 20);
		contentPane.add(textField_descripcion);
		textField_descripcion.setColumns(10);

		textField_marca = new JTextField();
		textField_marca.setBounds(177, 192, 150, 20);
		contentPane.add(textField_marca);
		textField_marca.setColumns(10);

		textField_precio = new JTextField();
		textField_precio.setBounds(177, 245, 150, 20);
		contentPane.add(textField_precio);
		textField_precio.setColumns(10);

		textField_stockMinimo = new JTextField();
		textField_stockMinimo.setBounds(177, 298, 150, 20);
		contentPane.add(textField_stockMinimo);
		textField_stockMinimo.setColumns(10);

		textField_stock = new JTextField();
		textField_stock.setBounds(177, 404, 150, 20);
		contentPane.add(textField_stock);
		textField_stock.setColumns(10);

		textField_estado = new JTextField();
		textField_estado.setEditable(false);
		textField_estado.setBounds(177, 457, 86, 20);
		contentPane.add(textField_estado);
		textField_estado.setColumns(10);

		// Botones

		// Listener para modificar producto
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setEnabled(false);
		btnModificarProducto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (textField_codigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigo, "Complete el campo CODIGO");
				} else {

					try {
						ProductoView producto = Supermercado.getInstancia().buscarProductoView(textField_codigo.getText());
						if (producto != null && producto.getEstado() != "2") {

							float floatprecio = Float.parseFloat(textField_precio.getText());
							int intstock = Integer.parseInt(textField_stock.getText());
							int intstockminimo = Integer.parseInt(textField_stockMinimo.getText());
							int pedidioReposicion = Integer.parseInt(textField_pedidoReposicion.getText());

							Supermercado.getInstancia().ModificarProducto(textField_codigo.getText(),
									textField_descripcion.getText(), textField_marca.getText(),
									textField_cuit.getText(), floatprecio, intstock, intstockminimo, pedidioReposicion);

							JOptionPane.showMessageDialog(null, "Modificacion efectuada");
							textField_descripcion.setText("");
							textField_cuit.setText("");
							textField_marca.setText("");
							textField_precio.setText("");
							textField_razonSocial.setText("");
							textField_stockMinimo.setText("");
							textField_pedidoReposicion.setText("");
							textField_estado.setText("");
							textField_stock.setText("");

						} else {
							JOptionPane.showMessageDialog(null, "Producto no encontrado");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros en Stock, StockMinimo, Pedido Reposicion y Precio",
								"", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		btnModificarProducto.setBounds(734, 298, 150, 23);
		contentPane.add(btnModificarProducto);

		// Buscar Producto
		JButton btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cargo los valores encontrados en pantalla
				if (textField_codigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigo, "Complete el campo CODIGO");
				} else {
					ProductoView producto = Supermercado.getInstancia().buscarProductoView(textField_codigo.getText());
					// Busco y muestro
					if (producto != null && producto.getEstado() != "2") {
										
						btnModificarProducto.setEnabled(true);
						textField_codigo.setText(producto.getCodigo());
						textField_descripcion.setText(producto.getDescripcion());
						textField_marca.setText(producto.getMarca());

						textField_precio.setText(String.valueOf(producto.getPrecio()));
						textField_stockMinimo.setText(String.valueOf(producto.getStockMinimo()));
						textField_stock.setText(String.valueOf(producto.getStock()));
						textField_estado.setText(producto.getEstado());
						textField_pedidoReposicion.setText(String.valueOf(producto.getPedidoReposicion()));

						// Cargo valores de proveedor
						Proveedor OCuit = Supermercado.getInstancia().buscarProducto(textField_codigo.getText())
								.getProveedor();
						String cuit = (OCuit.getCuit());
						textField_cuit.setText(cuit);
						contentPane.add(textField_cuit);

						Proveedor ORazon = Supermercado.getInstancia().buscarProducto(textField_codigo.getText())
								.getProveedor();
						String razonSocial = (ORazon.getRazonSocial());
						textField_razonSocial.setText(razonSocial);
						contentPane.add(textField_razonSocial);

					} else {

						textField_codigo.setText("");
						textField_descripcion.setText("");
						textField_cuit.setText("");
						textField_marca.setText("");
						textField_precio.setText("");
						textField_razonSocial.setText("");
						textField_estado.setText("");
						textField_pedidoReposicion.setText("");
						textField_stockMinimo.setText("");
						textField_stock.setText("");

						JOptionPane.showMessageDialog(null, "Producto no encontrado");

					}

				}
			}
		});
		btnBuscarProducto.setBounds(734, 84, 150, 23);
		contentPane.add(btnBuscarProducto);

		// Listener para cancelar
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(734, 405, 150, 23);
		contentPane.add(btnCancelar);

		textField_cuit = new JTextField();
		textField_cuit.setBounds(177, 139, 150, 20);
		contentPane.add(textField_cuit);
		textField_cuit.setColumns(10);

		JLabel lblProveedor = new JLabel("Proveedor (CUIT) :");
		lblProveedor.setBounds(46, 142, 121, 14);
		contentPane.add(lblProveedor);

		textField_razonSocial = new JTextField();
		textField_razonSocial.setEditable(false);
		textField_razonSocial.setColumns(10);
		textField_razonSocial.setBounds(337, 139, 300, 20);
		contentPane.add(textField_razonSocial);

		JButton btnBuscarProveedor_1 = new JButton("Buscar Proveedor");
		btnBuscarProveedor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cargo los valores encontrados en pantalla
				if (textField_cuit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_cuit, "Complete el campo CUIT");
				} else {
					// Busco y muestro
					ProveedorView proveedor = Supermercado.getInstancia().buscarProveedorView(textField_cuit.getText());
					if (proveedor != null) {

						 
						textField_cuit.setText(proveedor.getCuit());
						contentPane.add(textField_cuit);

						textField_razonSocial.setText(proveedor.getRazonSocial());
						contentPane.add(textField_razonSocial);

					} else {

						textField_razonSocial.setText("");
						JOptionPane.showMessageDialog(null, "Proveedor no encontrado");

					}

				}

			}
		});
		btnBuscarProveedor_1.setBounds(734, 191, 150, 23);
		contentPane.add(btnBuscarProveedor_1);

		JLabel lblPedidoReposicion = new JLabel("Pedido Reposicion : ");
		lblPedidoReposicion.setBounds(46, 350, 121, 14);
		contentPane.add(lblPedidoReposicion);

		textField_pedidoReposicion = new JTextField();
		textField_pedidoReposicion.setColumns(10);
		textField_pedidoReposicion.setBounds(177, 351, 150, 20);
		contentPane.add(textField_pedidoReposicion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(430, 246, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/producto.png"));
		contentPane.add(lblNewLabel);
	}
}
