package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.Component;
import java.awt.event.ActionEvent;

public class AbrirCaja extends JFrame {

	private JPanel contentPane;
	private JTextField textField_numeroCaja;
	private JTextField textField_nombreCajero;
	private JTextField textField_saldoInicialEfectivo;
	private JTextField textField_fecha;

	public AbrirCaja() {
		setTitle("Abrir Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeroCaja = new JLabel("Numero Caja : ");
		lblNumeroCaja.setBounds(51, 196, 150, 14);
		contentPane.add(lblNumeroCaja);

		JLabel lblNombreCajero = new JLabel("Nombre Cajero");
		lblNombreCajero.setBounds(51, 301, 150, 14);
		contentPane.add(lblNombreCajero);

		JLabel lblSaldoInicialEfectivo = new JLabel("Saldo Inicial Efectivo : ");
		lblSaldoInicialEfectivo.setBounds(51, 406, 150, 14);
		contentPane.add(lblSaldoInicialEfectivo);

		textField_numeroCaja = new JTextField();
		textField_numeroCaja.setBounds(247, 192, 150, 20);
		contentPane.add(textField_numeroCaja);
		textField_numeroCaja.setColumns(10);

		textField_nombreCajero = new JTextField();
		textField_nombreCajero.setBounds(247, 298, 300, 20);
		contentPane.add(textField_nombreCajero);
		textField_nombreCajero.setColumns(10);

		textField_saldoInicialEfectivo = new JTextField();
		textField_saldoInicialEfectivo.setBounds(247, 404, 150, 20);
		contentPane.add(textField_saldoInicialEfectivo);
		textField_saldoInicialEfectivo.setColumns(10);

		textField_fecha = new JTextField();
		textField_fecha.setEditable(false);
		textField_fecha.setBounds(247, 88, 150, 20);
		contentPane.add(textField_fecha);
		textField_fecha.setColumns(10);

		JButton btnAbrirCaja = new JButton("Abrir Caja");

		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = fecha.format(formatter);

		textField_fecha.setText(formattedString);
		contentPane.add(textField_fecha);

		btnAbrirCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_numeroCaja.getText().isEmpty() || textField_nombreCajero.getText().isEmpty()
						|| textField_saldoInicialEfectivo.getText().isEmpty()) {

					JOptionPane.showMessageDialog(textField_numeroCaja, "Complete todos los campos");
				} else {
					try {
						CajaView caja = Supermercado.getInstancia().buscarCajaView(textField_numeroCaja.getText()
								);
						if (caja == null) {

							float saldoInicial = Float.parseFloat(textField_saldoInicialEfectivo.getText());

							// Abro caja
							
							Supermercado.getInstancia().abrirCaja(fecha, textField_numeroCaja.getText(),
									textField_nombreCajero.getText(), saldoInicial);

							JOptionPane.showMessageDialog(null, "Se abrio la caja");

							textField_nombreCajero.setText("");
							textField_numeroCaja.setText("");
							textField_saldoInicialEfectivo.setText("");

						} else {
							if (caja.getEstado() == "0") {
								JOptionPane.showMessageDialog(null, "La Caja se encuentra cerrada");
							} else {
								JOptionPane.showMessageDialog(null, "La Caja se encuentra abierta");
							}

						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros en el saldo inicial", "",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnAbrirCaja.setBounds(771, 222, 150, 23);
		contentPane.add(btnAbrirCaja);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(771, 335, 150, 23);
		contentPane.add(btnCerrar);

		JLabel lblFechaDeApertura = new JLabel("Fecha de Apertura");
		lblFechaDeApertura.setBounds(51, 91, 150, 14);
		contentPane.add(lblFechaDeApertura);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/caja.png"));
		contentPane.add(lblNewLabel);

	}
}
