package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Supermercado;
import negocio.ProveedorView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Font;

public class AltaProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_cuit;
	private JTextField textField_razonSocial;
	private JTextField textField_telefono;
	private JTextField textField_domicilio;
	private JTextField textField_mail;
	private JTextField textField_estado;

	public AltaProveedor() {
		setTitle("Alta Proveedor");
		// vuelvo al menu principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiquetas
		JLabel lblCuit = new JLabel("Cuit :");
		lblCuit.setBounds(34, 61, 46, 14);
		contentPane.add(lblCuit);

		JLabel lblRazonSocial = new JLabel("Razon Social :");
		lblRazonSocial.setBounds(34, 136, 115, 14);
		contentPane.add(lblRazonSocial);

		JLabel lblDomicilio = new JLabel("Domicilio :");
		lblDomicilio.setBounds(34, 286, 107, 14);
		contentPane.add(lblDomicilio);

		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(34, 211, 115, 14);
		contentPane.add(lblTelefono);

		JLabel lblMail = new JLabel("Mail :");
		lblMail.setBounds(34, 361, 46, 14);
		contentPane.add(lblMail);

		// Cajas de Texto
		textField_cuit = new JTextField();
		textField_cuit.setBounds(127, 56, 150, 20);
		contentPane.add(textField_cuit);
		textField_cuit.setColumns(10);

		textField_razonSocial = new JTextField();
		textField_razonSocial.setBounds(127, 132, 300, 20);
		contentPane.add(textField_razonSocial);
		textField_razonSocial.setColumns(10);

		textField_telefono = new JTextField();
		textField_telefono.setBounds(127, 208, 300, 20);
		contentPane.add(textField_telefono);
		textField_telefono.setColumns(10);

		textField_domicilio = new JTextField();
		textField_domicilio.setBounds(127, 284, 150, 20);
		contentPane.add(textField_domicilio);
		textField_domicilio.setColumns(10);

		textField_mail = new JTextField();
		textField_mail.setBounds(127, 360, 300, 20);
		contentPane.add(textField_mail);
		textField_mail.setColumns(10);

		// Botones

		// Listener para crear proveedor
		JButton btnCrearProveedor = new JButton("Crear Proveedor");
		btnCrearProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_cuit.getText().isEmpty() || textField_razonSocial.getText().isEmpty()
						|| textField_telefono.getText().isEmpty() || textField_domicilio.getText().isEmpty()
						|| textField_mail.getText().isEmpty() || textField_estado.getText().isEmpty()) {
					JOptionPane.showMessageDialog(textField_cuit, "Complete todos los campos");
				} else {
					ProveedorView proveedor = Supermercado.getInstancia().buscarProveedorView(textField_cuit.getText());
					if (proveedor == null) {
						
						Supermercado.getInstancia().crearNuevoProveedor(textField_cuit.getText(), textField_razonSocial.getText(),
								textField_domicilio.getText(), textField_telefono.getText(), textField_mail.getText());

						JOptionPane.showMessageDialog(null, "Alta efectuada");
						textField_cuit.setText("");
						textField_razonSocial.setText("");
						textField_telefono.setText("");
						textField_domicilio.setText("");
						textField_mail.setText("");
									} else {
						JOptionPane.showMessageDialog(null, "Proveedor ya registrado");
					}

				}
			}
		});
		btnCrearProveedor.setBounds(592, 207, 150, 23);
		contentPane.add(btnCrearProveedor);

		// Listener para cancelar
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(592, 282, 150, 23);
		contentPane.add(btnCancelar);

		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(34, 436, 46, 14);
		contentPane.add(lblEstado);

		textField_estado = new JTextField();
		textField_estado.setEditable(false);
		textField_estado.setText("0");
		textField_estado.setBounds(127, 436, 86, 20);
		contentPane.add(textField_estado);
		textField_estado.setColumns(10);

		JLabel lblDescripcion = new JLabel("1 : Posee productos asociados | 0 : No posee productos asociados | 2 : Baja logica");
		lblDescripcion.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblDescripcion.setBounds(224, 439, 441, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(780, 11, 225, 169);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("src/imagenes/proveedor.png"));
		contentPane.add(lblNewLabel);
	}
}
