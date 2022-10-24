package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.Supermercado;
import negocio.CajaView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CierroCaja extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_numeroCaja;
	private JTextField textField_nombreCajero;
	private JTextField textField_fecha;
	private JTextField textField_saldoInicial;
	private JTextField textField_saldoFinal;

	public CierroCaja() {
		setTitle("Cierro Caja y Reporte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha de Apertura");
		lblFecha.setBounds(22, 16, 150, 14);
		contentPane.add(lblFecha);

		JLabel lblNumeroCaja = new JLabel("Numero Caja : ");
		lblNumeroCaja.setBounds(22, 56, 100, 14);
		contentPane.add(lblNumeroCaja);

		textField_numeroCaja = new JTextField();
		textField_numeroCaja.setBounds(150, 52, 150, 20);
		contentPane.add(textField_numeroCaja);
		textField_numeroCaja.setColumns(10);

		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = fecha.format(formatter);

		textField_fecha = new JTextField();
		textField_fecha.setEditable(false);
		textField_fecha.setColumns(10);
		textField_fecha.setBounds(150, 11, 150, 20);
		contentPane.add(textField_fecha);

		textField_fecha.setText(formattedString);
		contentPane.add(textField_fecha);

		JButton btnCerrarCaja = new JButton("Cerrar Caja");
		btnCerrarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_numeroCaja.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_numeroCaja, "Complete el numero de caja");
				} else {
					CajaView caja = Supermercado.getInstancia().buscarCajaView(textField_numeroCaja.getText());
					if (caja != null) {
						if (caja.getEstado() == "1") {
							try {

								String numeroCaja = Supermercado.getInstancia()
										.buscarCaja(textField_numeroCaja.getText()).getNumeroCaja();
								textField_numeroCaja.setText(numeroCaja);
								contentPane.add(textField_numeroCaja);

								String nombreCajero = Supermercado.getInstancia()
										.buscarCaja(textField_numeroCaja.getText()).getNombreCajero();
								textField_nombreCajero.setText(nombreCajero);
								contentPane.add(textField_nombreCajero);

								String codigoVenta = Supermercado.getInstancia()
										.buscarCaja(textField_numeroCaja.getText()).getNombreCajero();

								Supermercado.getInstancia().cerrarCaja(fecha, numeroCaja, codigoVenta);

								// Genero Informe
								textField_saldoInicial.setText(String.valueOf(caja.getSaldoInicialEfectivo()));
								textField_saldoFinal.setText(String.valueOf(caja.getSaldoFinalEfectivo()));

								// Array de ‘String’ con los titulos de las columnas
								Vector<String> columnNames = new Vector<String>();

								columnNames.add("Nro Venta");
								columnNames.add("Total Venta");
								columnNames.add("Importe Recibido");
								columnNames.add("Vuelto");

								// Pedir los datos al supermercado

								Vector<Vector<String>> datos = Supermercado.getInstancia().consultarVentaCaja(fecha,
										textField_numeroCaja.getText());

								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(22, 127, 692, 301);
								contentPane.add(scrollPane);

								DefaultTableModel jTable1Model = new DefaultTableModel(datos, columnNames);
								table = new JTable();
								table.setPreferredScrollableViewportSize(new Dimension(500, 80));
								table.setModel(jTable1Model);
								table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
								table.setLocation(new Point(9, 9));
								table.getTableHeader().setVisible(true);
								scrollPane.setViewportView(table);

								JOptionPane.showMessageDialog(null, "Se cerro la caja");

							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null,
										"Debe ingresar solo numeros en la fecha y numero de caja", "",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {

							JOptionPane.showMessageDialog(null, "La Caja se encuentra cerrada");

						}

					} else {

						textField_nombreCajero.setText("");
						JOptionPane.showMessageDialog(null, "Caja no encontrada");

					}
				}
			}

		});
		btnCerrarCaja.setBounds(760, 283, 150, 23);
		contentPane.add(btnCerrarCaja);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(760, 352, 150, 23);
		contentPane.add(btnCerrar);

		JButton btnBuscarCaja = new JButton("Buscar Caja");
		btnBuscarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_numeroCaja.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_numeroCaja, "Complete el numero de caja");
				} else {
					try {
						CajaView caja = Supermercado.getInstancia().buscarCajaView(textField_numeroCaja.getText()
								);
						if (caja != null) {
							if (Supermercado.getInstancia().buscarCaja(textField_numeroCaja.getText())
									.getEstado() == "1") {
								btnCerrarCaja.setEnabled(true);

								textField_nombreCajero.setText(caja.getNombreCajero());
								textField_numeroCaja.setText(caja.getNumeroCaja());

							} else {

								textField_nombreCajero.setText("");
								JOptionPane.showMessageDialog(null, "La caja se encuentra Cerrada");

							}

						} else {

							textField_nombreCajero.setText("");
							JOptionPane.showMessageDialog(null, "Caja no encontrada");

						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros en la fecha y numero de caja",
								"", JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		});
		btnBuscarCaja.setBounds(760, 212, 150, 23);
		contentPane.add(btnBuscarCaja);

		textField_nombreCajero = new JTextField();
		textField_nombreCajero.setEditable(false);
		textField_nombreCajero.setColumns(10);
		textField_nombreCajero.setBounds(150, 92, 300, 20);
		contentPane.add(textField_nombreCajero);

		JLabel lblNombreCajero = new JLabel("Nombre Cajero : ");
		lblNombreCajero.setBounds(22, 95, 100, 14);
		contentPane.add(lblNombreCajero);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 127, 692, 301);
		contentPane.add(scrollPane);

		JLabel lblSaldoFinal = new JLabel("Saldo Final : ");
		lblSaldoFinal.setBounds(367, 450, 100, 14);
		contentPane.add(lblSaldoFinal);

		JLabel lblSaldoInicial = new JLabel("Saldo Inicial : ");
		lblSaldoInicial.setBounds(22, 450, 100, 14);
		contentPane.add(lblSaldoInicial);

		textField_saldoInicial = new JTextField();
		textField_saldoInicial.setEditable(false);
		textField_saldoInicial.setColumns(10);
		textField_saldoInicial.setBounds(141, 447, 130, 20);
		contentPane.add(textField_saldoInicial);

		textField_saldoFinal = new JTextField();
		textField_saldoFinal.setEditable(false);
		textField_saldoFinal.setColumns(10);
		textField_saldoFinal.setBounds(504, 447, 130, 20);
		contentPane.add(textField_saldoFinal);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/caja.png"));
		contentPane.add(lblNewLabel);

	}
}
