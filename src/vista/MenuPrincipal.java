package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	// iniciador
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		setForeground(Color.BLACK);

		// Seteo titulo
		setTitle("Menu Principal | Supermercado Rodrigo");
		// Salgo del sistema
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 5, 1005, 22);
		contentPane.add(menuBar);

		// Menu Proveedor
		JMenu Jmenu_Proveedores = new JMenu("Proveedores");
		menuBar.add(Jmenu_Proveedores);

		// Listener para agregar proveedor
		JMenuItem JMenuItem_agregarProveedor = new JMenuItem("Agregar Proveedor");
		JMenuItem_agregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				AltaProveedor ventanaContacto = new AltaProveedor();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Proveedores.add(JMenuItem_agregarProveedor);

		JMenuItem JMenuItem_modificarProveedor = new JMenuItem("Modificar Proveedor");
		JMenuItem_modificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				ModificarProveedor ventanaContacto = new ModificarProveedor();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Proveedores.add(JMenuItem_modificarProveedor);

		JMenuItem JMenuItem_eliminarProveedor = new JMenuItem("Eliminar Proveedor");
		JMenuItem_eliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				EliminarProveedor ventanaContacto = new EliminarProveedor();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Proveedores.add(JMenuItem_eliminarProveedor);

		// Menu Productos
		JMenu Jmenu_Productos = new JMenu("Productos");
		menuBar.add(Jmenu_Productos);

		JMenuItem JMenuItem_agregarProducto = new JMenuItem("Agregar Producto");
		JMenuItem_agregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				AltaProducto ventanaContacto = new AltaProducto();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Productos.add(JMenuItem_agregarProducto);

		JMenuItem JMenuItem_modificarProducto = new JMenuItem("Modificar Producto");
		JMenuItem_modificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				ModificarProducto ventanaContacto = new ModificarProducto();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Productos.add(JMenuItem_modificarProducto);

		JMenuItem JMenuItem_eliminarProducto = new JMenuItem("Eliminar Producto");
		JMenuItem_eliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				EliminarProducto ventanaContacto = new EliminarProducto();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Productos.add(JMenuItem_eliminarProducto);

		// Menu Caja
		JMenu Jmenu_Caja = new JMenu("Cajas");
		menuBar.add(Jmenu_Caja);

		JMenuItem JMenuItem_abrirCaja = new JMenuItem("Abrir Caja");
		JMenuItem_abrirCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				AbrirCaja ventanaContacto = new AbrirCaja();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Caja.add(JMenuItem_abrirCaja);

		JMenuItem JMenuItem_cerrarCaja = new JMenuItem("Cerrar Caja");
		JMenuItem_cerrarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				CierroCaja ventanaContacto = new CierroCaja();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Caja.add(JMenuItem_cerrarCaja);

		// Menu Venta
		JMenu Jmenu_Venta = new JMenu("Ventas");
		menuBar.add(Jmenu_Venta);

		JMenuItem JMenuItem_InicioVenta = new JMenuItem("Inicio Venta");
		JMenuItem_InicioVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				InicioVenta ventanaContacto = new InicioVenta();
				ventanaContacto.setVisible(true);

			}
		});
		Jmenu_Venta.add(JMenuItem_InicioVenta);

		JMenuItem JMenuItem_CierroVenta = new JMenuItem("Cierro Venta");
		JMenuItem_CierroVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				CierroVenta ventanaContacto = new CierroVenta();
				ventanaContacto.setVisible(true);
			}

		});

		JMenuItem JMenuItem_EscaneoProductos = new JMenuItem("Escanear Productos");
		JMenuItem_EscaneoProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				EscaneoProducto ventanaContacto = new EscaneoProducto();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Venta.add(JMenuItem_EscaneoProductos);
		Jmenu_Venta.add(JMenuItem_CierroVenta);

		JMenu Jmenu_Informes = new JMenu("Informes");
		menuBar.add(Jmenu_Informes);

		JMenuItem JMenuItem_InfomeStock = new JMenuItem("Informe Stock Minimo");
		JMenuItem_InfomeStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// cuando hago click
				InformeStock ventanaContacto = new InformeStock();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Informes.add(JMenuItem_InfomeStock);

		JMenuItem JMenuItem_ConsultarVenta = new JMenuItem("Consultar Venta");
		JMenuItem_ConsultarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				ReporteVenta ventanaContacto = new ReporteVenta();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Informes.add(JMenuItem_ConsultarVenta);

		JMenuItem JMenuItem_ConsultarCaja = new JMenuItem("Consultar Caja");
		JMenuItem_ConsultarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cuando hago click
				ReporteCaja ventanaContacto = new ReporteCaja();
				ventanaContacto.setVisible(true);
			}
		});
		Jmenu_Informes.add(JMenuItem_ConsultarCaja);

		// Menu Salir
		JMenu Jmenu_Salir = new JMenu("Salir");
		menuBar.add(Jmenu_Salir);

		JButton btnSalir = new JButton("Salir del Sistema");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnSalir, "�Esta seguro de salir del sistema?", "Salir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		Jmenu_Salir.add(btnSalir);

		JLabel lblNewLabel_logo1 = new JLabel("");
		lblNewLabel_logo1.setBounds(532, 38, 473, 465);
		lblNewLabel_logo1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_logo1.setIcon(new ImageIcon("src/imagenes/java.png"));
		contentPane.add(lblNewLabel_logo1);

		JLabel lblNewLabel_logo2 = new JLabel("");
		lblNewLabel_logo2.setBounds(15, 38, 507, 465);
		lblNewLabel_logo2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_logo2.setIcon(new ImageIcon("src/imagenes/supermercado.png"));
		contentPane.add(lblNewLabel_logo2);

	}
}
