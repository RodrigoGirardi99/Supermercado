package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.ProductoView;
import negocio.ProveedorView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaProducto extends JFrame {

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

	public AltaProducto() {
		setTitle("Alta Producto");
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

		JLabel lblPrecio = new JLabel("Precio : ");
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
		textField_estado.setText("0");
		textField_estado.setBounds(177, 457, 86, 20);
		contentPane.add(textField_estado);
		textField_estado.setColumns(10);

		JLabel lblDescripcion_1 = new JLabel(
				"1 : Posee ventas asociadas | 0 : No posee ventas asociadas | 2 : Baja Logica");
		lblDescripcion_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblDescripcion_1.setBounds(273, 460, 401, 14);
		contentPane.add(lblDescripcion_1);

		// Botones

		// Listener para crear producto
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigo.getText().isEmpty() || textField_descripcion.getText().isEmpty()
						|| textField_marca.getText().isEmpty() || textField_precio.getText().isEmpty()
						|| textField_stockMinimo.getText().isEmpty() || textField_stock.getText().isEmpty()
						|| textField_estado.getText().isEmpty() || textField_cuit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigo, "Complete todos los campos");
				} else { 
					try {
						ProductoView producto = Supermercado.getInstancia()
								.buscarProductoView(textField_codigo.getText());
						ProveedorView proveedor = Supermercado.getInstancia()
								.buscarProveedorView(textField_cuit.getText());
						// Busco y muestro
						System.out.println("valores"+ proveedor.getEstado() + proveedor);
						if (  proveedor == null || proveedor.getEstado() != "2") {
							if (producto == null) {

								// Alta producto

								float floatprecio = Float.parseFloat(textField_precio.getText());
								int intstock = Integer.parseInt(textField_stock.getText());
								int intstockminimo = Integer.parseInt(textField_stockMinimo.getText());
								int pedidioReposicion = Integer.parseInt(textField_pedidoReposicion.getText());

								// Cargo valores de proveedor
								textField_cuit.setText(proveedor.getCuit());
								textField_razonSocial.setText(proveedor.getRazonSocial());

								Supermercado.getInstancia().crearNuevoProducto(textField_codigo.getText(),
										textField_descripcion.getText(), textField_marca.getText(),
										textField_cuit.getText(), floatprecio, intstock, intstockminimo,
										pedidioReposicion);

								JOptionPane.showMessageDialog(null, "Alta efectuada");
								textField_descripcion.setText("");
								textField_marca.setText("");
								textField_codigo.setText("");
								textField_cuit.setText("");
								textField_razonSocial.setText("");
								textField_precio.setText("");
								textField_pedidoReposicion.setText("");
								textField_stockMinimo.setText("");
								textField_stock.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "Producto ya registrado");
							}

						} else {

							textField_razonSocial.setText("");
							JOptionPane.showMessageDialog(null, "Proveedor no encontrado");

						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros en Stock, StockMinimo, Pedido Reposicion y Precio", "",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		btnCrearProducto.setBounds(629, 214, 150, 23);
		contentPane.add(btnCrearProducto);

		// Listener para cancelar
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(629, 393, 150, 23);
		contentPane.add(btnCancelar);

		JLabel lblProveedor = new JLabel("Proveedor (CUIT) : ");
		lblProveedor.setBounds(46, 142, 121, 14);
		contentPane.add(lblProveedor);

		textField_cuit = new JTextField();
		textField_cuit.setBounds(177, 139, 150, 20);
		contentPane.add(textField_cuit);
		textField_cuit.setColumns(10);

		textField_razonSocial = new JTextField();
		textField_razonSocial.setEditable(false);
		textField_razonSocial.setColumns(10);
		textField_razonSocial.setBounds(337, 139, 300, 20);
		contentPane.add(textField_razonSocial);

		JLabel lblPedidoReposicion = new JLabel("Pedido Reposicion : ");
		lblPedidoReposicion.setBounds(46, 350, 121, 14);
		contentPane.add(lblPedidoReposicion);

		textField_pedidoReposicion = new JTextField();
		textField_pedidoReposicion.setColumns(10);
		textField_pedidoReposicion.setBounds(177, 351, 150, 20);
		contentPane.add(textField_pedidoReposicion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/producto.png"));
		contentPane.add(lblNewLabel);

	}
}
