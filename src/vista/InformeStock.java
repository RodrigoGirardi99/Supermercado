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
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

public class InformeStock extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;

	public InformeStock() {
		setTitle("Informe de Stock Minimo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Genero Informe

		// Array de ‘String’ con los titulos de las columnas
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Codigo");
		columnNames.add("Descripcion");
		columnNames.add("Stock Actual");
		columnNames.add("Stock Minimo");
		columnNames.add("Pedido Reposicion");
		columnNames.add("Precio ($) ");

		// Pedir los datos al supermercado
		Vector<Vector<String>> datos = Supermercado.getInstancia().consultarStockMinimo();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 11, 950, 385);
		contentPane.add(scrollPane);

		DefaultTableModel jTable1Model = new DefaultTableModel(datos, columnNames);
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setModel(jTable1Model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setLocation(new Point(9, 9));
		table.getTableHeader().setVisible(true);
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		btnCerrar.setBounds(438, 431, 140, 23);
		contentPane.add(btnCerrar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(843, 406, 140, 97);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/stock.png"));
		contentPane.add(lblNewLabel);

		JLabel lblLeyenda = new JLabel("Productos con menos Stock del minimo seteado");
		lblLeyenda.setBounds(33, 435, 329, 14);
		contentPane.add(lblLeyenda);
	}
}
