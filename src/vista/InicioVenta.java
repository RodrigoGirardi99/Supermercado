package vista;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.CajaView;
import negocio.VentaView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class InicioVenta extends JFrame {

	private JPanel contentPane;
	private JTextField textField_fecha;
	private JTextField textField_numeroCaja;
	private JTextField textField_codigoVenta;

	public InicioVenta() {
		setTitle("Inicio Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_fecha = new JTextField();
		textField_fecha.setEditable(false);
		textField_fecha.setColumns(10);
		textField_fecha.setBounds(160, 379, 144, 20);
		contentPane.add(textField_fecha);

		JLabel lblFechaDeVenta = new JLabel("Fecha de Venta : ");
		lblFechaDeVenta.setBounds(56, 382, 150, 14);
		contentPane.add(lblFechaDeVenta);

		textField_numeroCaja = new JTextField();
		textField_numeroCaja.setColumns(10);
		textField_numeroCaja.setBounds(160, 246, 144, 20);
		contentPane.add(textField_numeroCaja);

		JLabel lblNumeroCaja = new JLabel("Numero Caja : ");
		lblNumeroCaja.setBounds(56, 250, 130, 14);
		contentPane.add(lblNumeroCaja);

		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = fecha.format(formatter);

		textField_fecha.setText(formattedString);
		contentPane.add(textField_fecha);

		JButton btnCrearVenta = new JButton("Crear Venta");
		btnCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_codigoVenta.getText().isEmpty() || textField_fecha.getText().isEmpty()
						|| textField_numeroCaja.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_codigoVenta, "Complete todos los campos");
				} else {
					// Busco y muestro

					VentaView venta = Supermercado.getInstancia().buscarVentaView(textField_codigoVenta.getText());
					CajaView caja = Supermercado.getInstancia().buscarCajaView(textField_numeroCaja.getText());

					if (venta == null) {
						if (caja != null) {

							// Creo venta

							Supermercado.getInstancia().inicioVenta(fecha, textField_numeroCaja.getText(),
									caja.getNombreCajero(), textField_codigoVenta.getText());

							JOptionPane.showMessageDialog(textField_codigoVenta, "Venta creada");
							textField_codigoVenta.setText("");
							textField_numeroCaja.setText("");

						} else {
							JOptionPane.showMessageDialog(textField_codigoVenta, "Caja Cerrada/Inexistente");

						}

					} else {
						JOptionPane.showMessageDialog(textField_codigoVenta, "Venta ya se encuentra creada");

					}
				}
			}
		});
		btnCrearVenta.setBounds(590, 197, 130, 23);
		contentPane.add(btnCrearVenta);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(590, 376, 130, 23);
		contentPane.add(btnCerrar);

		JLabel lblCodigoVenta = new JLabel("Codigo Venta");
		lblCodigoVenta.setBounds(56, 118, 86, 14);
		contentPane.add(lblCodigoVenta);

		textField_codigoVenta = new JTextField();
		textField_codigoVenta.setBounds(160, 113, 144, 20);
		contentPane.add(textField_codigoVenta);
		textField_codigoVenta.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(593, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/venta.png"));
		contentPane.add(lblNewLabel);
	}
}
