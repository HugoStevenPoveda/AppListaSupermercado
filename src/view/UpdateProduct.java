package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerProducto;
import model.Producto;

public class UpdateProduct {

	private JFrame frmMain;
	private int indiceProducto;
	private JTextField campoNombre, campoPrecio, campoInventario;
	private ControllerProducto controlador;

	public UpdateProduct(int indice) {
		this.indiceProducto = indice;
		initialize();
	}

	private void construirFrameMain() {
		frmMain = new JFrame();
		frmMain.setTitle("Actualizar Producto");
		frmMain.setBounds(100, 100, 450, 300);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(new BorderLayout(0, 0));
		frmMain.setVisible(true);

	}

	private void construirTitulo() {
		JPanel panel = new JPanel();
		frmMain.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel titulo = new JLabel("Ingrese los nuevos valores");
		titulo.setForeground(new Color(102, 0, 102));
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		panel.add(titulo);

	}

	private void construirPanelIngresoDatos() {

		JPanel panelAgregarProducto = new JPanel();

		panelAgregarProducto.setBackground(new Color(255, 255, 153));
		panelAgregarProducto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		frmMain.add(panelAgregarProducto, BorderLayout.CENTER);
		panelAgregarProducto.setLayout(new GridLayout(3, 2, 2, 2));

		JLabel nombre = new JLabel("Nombre");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel precio = new JLabel("Precio");
		precio.setHorizontalAlignment(SwingConstants.CENTER);
		precio.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel inventario = new JLabel("Invetario");
		inventario.setHorizontalAlignment(SwingConstants.CENTER);
		inventario.setFont(new Font("Tahoma", Font.BOLD, 14));
		campoNombre = new JTextField();
		campoPrecio = new JTextField();
		campoInventario = new JTextField();
		panelAgregarProducto.add(nombre);
		panelAgregarProducto.add(campoNombre);
		panelAgregarProducto.add(precio);
		panelAgregarProducto.add(campoPrecio);
		panelAgregarProducto.add(inventario);
		panelAgregarProducto.add(campoInventario);

	}

	private Producto crearProducto(int indice) {
		controlador = new ControllerProducto();
		String nuevoNombre = campoNombre.getText();
		Double nuevoPrecio = Double.parseDouble(campoPrecio.getText());
		int nuevoInventario = Integer.parseInt(campoInventario.getText());
		int codigoNuevo = controlador.obtenerProducto(indice).getCodigo();
		Producto productoActualizado = new Producto(codigoNuevo, nuevoNombre, nuevoPrecio, nuevoInventario);
		return productoActualizado;
	}

	private void actualizarProducto() {
		controlador = new ControllerProducto();
		Producto producto = crearProducto(indiceProducto);
		controlador.actualizar(producto);

	}

	private void construirBotonActualizarProducto() {
		JPanel panelBoton = new JPanel();

		panelBoton.setBackground(new Color(255, 255, 153));
		frmMain.add(panelBoton, BorderLayout.SOUTH);
		JButton actualizarProducto = new JButton("Actualizar Producto");
		actualizarProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarProducto();

			}
		});

		panelBoton.add(actualizarProducto);

	}

	private void initialize() {

		construirFrameMain();
		construirTitulo();
		construirPanelIngresoDatos();
		construirBotonActualizarProducto();

	}

}
