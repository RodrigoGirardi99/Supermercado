package vista;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.VentaView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CierroVenta extends JFrame {

	private JPanel contentPane;
	private JTextField textField_codigoVenta;
	private JTextField textField_importeIngresado;
	private JTextField textField_vuelto;
	private JTextField textField_importeAPagar;

	public CierroVenta() {
		setTitle("Cierro Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoVenta = new JLabel("Codigo Venta : ");
		lblCodigoVenta.setBounds(67, 91, 130, 14);
		contentPane.add(lblCodigoVenta);

		JLabel lblImporteIngresado = new JLabel("Importe Ingresado : ");
		lblImporteIngresado.setBounds(67, 301, 130, 14);
		contentPane.add(lblImporteIngresado);

		textField_codigoVenta = new JTextField();
		textField_codigoVenta.setBounds(256, 86, 130, 20);
		contentPane.add(textField_codigoVenta);
		textField_codigoVenta.setColumns(10);

		textField_importeIngresado = new JTextField();
		textField_importeIngresado.setBounds(256, 298, 130, 20);
		contentPane.add(textField_importeIngresado);
		textField_importeIngresado.setColumns(10);

		JButton btnCerrarVenta = new JButton("Cerrar Venta");
		btnCerrarVenta.setEnabled(false);
		btnCerrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigoVenta.getText().isEmpty() || textField_importeIngresado.getText().isEmpty()) {

					JOptionPane.showMessageDialog(textField_codigoVenta, "Complete todos los campos");

				} else {
					VentaView venta = Supermercado.getInstancia().buscarVentaView(textField_codigoVenta.getText());
					try {
						if (venta != null) {

							if ((Float.parseFloat(textField_importeIngresado.getText())
									- venta.getImporteTotalVenta()) >= 0) {

								float vuelto = Float.parseFloat(textField_importeIngresado.getText())
										- venta.getImporteTotalVenta();
								
								Supermercado.getInstancia().cerrarVenta(venta.getFecha(), venta.getNumeroCaja(),
										venta.getNombreCajero(), venta.getCodigoVenta(), venta.getImporteTotalVenta(),
										Float.parseFloat(textField_importeIngresado.getText()), vuelto);
								
								textField_vuelto.setText(vuelto + "");

								JOptionPane.showMessageDialog(textField_codigoVenta, "Se cerro la venta");
							} else {
								JOptionPane.showMessageDialog(textField_codigoVenta,
										"ingrese un valor mayor al importe a pagar");
							}

						} else {
							textField_importeIngresado.setText("");
							textField_vuelto.setText("");
							textField_importeAPagar.setText("");
							JOptionPane.showMessageDialog(null, "Venta no encontrada");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros", "",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
		btnCerrarVenta.setBounds(595, 245, 140, 23);
		contentPane.add(btnCerrarVenta);

		JButton btnBuscarVenta = new JButton("Buscar Venta");
		btnBuscarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_codigoVenta.getText().isEmpty()) {

					JOptionPane.showMessageDialog(textField_codigoVenta, "Complete el codigo de Venta");

				} else {
					VentaView venta = Supermercado.getInstancia().buscarVentaView(textField_codigoVenta.getText());
					if (venta != null) {
						if (venta.getEstado() == "1") {

							btnCerrarVenta.setEnabled(true);

							textField_importeAPagar.setText(String.valueOf(venta.getImporteTotalVenta()));

						} else {
							textField_importeIngresado.setText("");
							textField_vuelto.setText("");
							textField_importeAPagar.setText("");
							JOptionPane.showMessageDialog(null, "Venta Cerrada");
						}

					} else {
						textField_importeIngresado.setText("");
						textField_vuelto.setText("");
						textField_importeAPagar.setText("");
						JOptionPane.showMessageDialog(null, "Venta no encontrada");
					}
				}

			}
		});
		btnBuscarVenta.setBounds(595, 111, 140, 23);
		contentPane.add(btnBuscarVenta);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(595, 379, 140, 23);
		contentPane.add(btnCerrar);

		JLabel lblVuelto = new JLabel("Vuelto : ");
		lblVuelto.setBounds(67, 406, 130, 14);
		contentPane.add(lblVuelto);

		textField_vuelto = new JTextField();
		textField_vuelto.setEditable(false);
		textField_vuelto.setBounds(256, 404, 130, 20);
		contentPane.add(textField_vuelto);
		textField_vuelto.setColumns(10);

		JLabel lblImporteAPagar = new JLabel("Importe a Pagar :");
		lblImporteAPagar.setBounds(67, 196, 130, 14);
		contentPane.add(lblImporteAPagar);

		textField_importeAPagar = new JTextField();
		textField_importeAPagar.setEditable(false);
		textField_importeAPagar.setColumns(10);
		textField_importeAPagar.setBounds(256, 192, 130, 20);
		contentPane.add(textField_importeAPagar);

		JLabel lblSimbolo1 = new JLabel("$");
		lblSimbolo1.setBounds(244, 196, 17, 14);
		contentPane.add(lblSimbolo1);

		JLabel lblSimbolo1_1 = new JLabel("$");
		lblSimbolo1_1.setBounds(244, 301, 17, 14);
		contentPane.add(lblSimbolo1_1);

		JLabel lblSimbolo1_2 = new JLabel("$");
		lblSimbolo1_2.setBounds(244, 406, 17, 14);
		contentPane.add(lblSimbolo1_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/venta.png"));
		contentPane.add(lblNewLabel);
	}
}
