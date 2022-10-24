package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.Supermercado;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ReporteCaja extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombreCajero;
	private JTextField textField_numeroCaja;
	private JTextField textField_dia;
	private JTextField textField_mes;
	private JTextField textField_año;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_saldoInicial;
	private JTextField textField_saldoFinal;

	public ReporteCaja() {
		setTitle("Reporte Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeroCaja = new JLabel("Numero Caja : ");
		lblNumeroCaja.setBounds(69, 63, 130, 14);
		contentPane.add(lblNumeroCaja);

		JLabel lblNombreCajero = new JLabel("Nombre Cajero : ");
		lblNombreCajero.setBounds(69, 105, 130, 14);
		contentPane.add(lblNombreCajero);

		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreCajero = null;
				String numeroCaja = null;
				LocalDate fechaVenta = null;

				if (!textField_nombreCajero.getText().isEmpty()) {
					nombreCajero = textField_nombreCajero.getText();

				}

				if (!textField_numeroCaja.getText().isEmpty()) {
					numeroCaja = textField_numeroCaja.getText();
				}

				if (!textField_dia.getText().isEmpty() && !textField_mes.getText().isEmpty()
						&& !textField_año.getText().isEmpty()) {
					int dia = Integer.parseInt(textField_dia.getText());
					int mes = Integer.parseInt(textField_mes.getText());
					int año = Integer.parseInt(textField_año.getText());
					// creo fecha de venta
					fechaVenta = LocalDate.of(año, mes, dia);
				}

				// Genero Informe

				// Array de ñStringñ con los titulos de las columnas
				Vector<String> columnNames = new Vector<String>();
				columnNames.add("Nro Venta");
				columnNames.add("Total Venta");
				columnNames.add("Importe Recibido");
				columnNames.add("Vuelto");

				// Pedir los datos al supermercado
				
				Vector<Vector<String>> datos = Supermercado.getInstancia().consultarVentaFiltroCaja(fechaVenta,
						numeroCaja, nombreCajero);

				JScrollPane scrollPane = new JScrollPane();

				scrollPane.setBounds(35, 202, 692, 215);
				contentPane.add(scrollPane);

				DefaultTableModel jTable1Model = new DefaultTableModel(datos, columnNames);
				table = new JTable();
				table.setPreferredScrollableViewportSize(new Dimension(500, 80));
				table.setModel(jTable1Model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setLocation(new Point(9, 9));
				table.getTableHeader().setVisible(true);
				scrollPane.setViewportView(table);

			}
		});
		btnGenerarReporte.setBounds(762, 255, 130, 23);
		contentPane.add(btnGenerarReporte);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(762, 394, 130, 23);
		contentPane.add(btnCerrar);

		textField_nombreCajero = new JTextField();
		textField_nombreCajero.setBounds(218, 101, 86, 20);
		contentPane.add(textField_nombreCajero);
		textField_nombreCajero.setColumns(10);

		textField_numeroCaja = new JTextField();
		textField_numeroCaja.setBounds(218, 60, 86, 20);
		contentPane.add(textField_numeroCaja);
		textField_numeroCaja.setColumns(10);

		JLabel lblFiltros = new JLabel("Filtros para la generacion de reporte - Filtra de un campo a la vez");
		lblFiltros.setBounds(324, 22, 430, 14);
		contentPane.add(lblFiltros);

		JLabel lblDia = new JLabel("Dia : ");
		lblDia.setBounds(69, 162, 60, 14);
		contentPane.add(lblDia);

		textField_dia = new JTextField();
		textField_dia.setColumns(10);
		textField_dia.setBounds(139, 159, 60, 20);
		contentPane.add(textField_dia);

		textField_mes = new JTextField();
		textField_mes.setColumns(10);
		textField_mes.setBounds(327, 159, 60, 20);
		contentPane.add(textField_mes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 202, 692, 215);
		contentPane.add(scrollPane);

		JLabel lblAño = new JLabel("Año : ");
		lblAño.setBounds(432, 162, 46, 14);
		contentPane.add(lblAño);

		textField_año = new JTextField();
		textField_año.setColumns(10);
		textField_año.setBounds(488, 159, 60, 20);
		contentPane.add(textField_año);

		JLabel lblMes = new JLabel("Mes :");
		lblMes.setBounds(258, 162, 46, 14);
		contentPane.add(lblMes);

		JLabel lblFechaDeVenta = new JLabel("Fecha de Venta");
		lblFechaDeVenta.setBounds(286, 132, 150, 14);
		contentPane.add(lblFechaDeVenta);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/informe.png"));
		contentPane.add(lblNewLabel);

		JLabel lblSaldoInicial = new JLabel("Saldo Inicial : ");
		lblSaldoInicial.setBounds(35, 456, 100, 14);
		contentPane.add(lblSaldoInicial);

		textField_saldoInicial = new JTextField();
		textField_saldoInicial.setEditable(false);
		textField_saldoInicial.setColumns(10);
		textField_saldoInicial.setBounds(154, 453, 130, 20);
		contentPane.add(textField_saldoInicial);

		JLabel lblSaldoFinal = new JLabel("Saldo Final : ");
		lblSaldoFinal.setBounds(380, 456, 100, 14);
		contentPane.add(lblSaldoFinal);

		textField_saldoFinal = new JTextField();
		textField_saldoFinal.setEditable(false);
		textField_saldoFinal.setColumns(10);
		textField_saldoFinal.setBounds(517, 453, 130, 20);
		contentPane.add(textField_saldoFinal);

	}
}
