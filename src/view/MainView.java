package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


import controller.ControllerProducto;

import model.Producto;
import model.TablaProductos;

import javax.swing.JTable;

public class MainView {

	private JFrame frame;
	//private JTable tableProductos;
	private JPanel panelCenter;
	private JTextField campoNombre, campoPrecio, campoInventario;
	private TablaProductos tablaProductos = new TablaProductos();
	ControllerProducto controlador ;
	int idProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	private void construirFrame() {
		frame = new JFrame();
		frame.setTitle("Inventario de Productos");
		frame.setBounds(100, 100, 500, 600);
		frame.getContentPane().setLayout(new BorderLayout(10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private JButton construirBotonAgregarProducto() {
		JButton agregarProducto = new JButton();
		agregarProducto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		agregarProducto.setText("Agregar Producto");
		agregarProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String ValidarNombre = campoNombre.getText();
				String ValidarPrecio = campoPrecio.getText();
				String ValidarInventario = campoInventario.getText();
				ValidarNombre = ValidarNombre.replaceAll(" ", "");
				ValidarPrecio = ValidarPrecio.replaceAll(" ", "");
				ValidarInventario = ValidarInventario.replaceAll(" ", "");
				boolean isTodosCamposLLenos = ((ValidarNombre.length() == 0) || (ValidarPrecio.length() == 0)
						|| (ValidarInventario.length() == 0));

				if (!isTodosCamposLLenos) {
					String nombre = campoNombre.getText();
					Double precio = Double.parseDouble(campoPrecio.getText());
					int inventario = Integer.parseInt(campoInventario.getText());
					Producto producto = new Producto(nombre, precio, inventario);
					controlador = new ControllerProducto();

					controlador.registrar(producto);
					controlador.verProductos();

				} else {
					JOptionPane.showMessageDialog(null, "Todos los campos son Obligatorios", "WARNING_MESSAGE",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		return agregarProducto;

	}

	private void contruirPanelAgregarProducto() {

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(255, 255, 255));
		panelNorte.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 5));
		frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(2, 2));

		// panel para titulo

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(255, 255, 204));
		panelNorte.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));

		// titulo de la app
		JLabel titulo = new JLabel();
		titulo.setForeground(new Color(102, 0, 102));
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		titulo.setText("!Bienvenidos a la APP inventario");
		panelTitulo.add(titulo);

		// panel controlar los label y textFiedl
		JPanel panelAgregarProducto = new JPanel();

		panelAgregarProducto.setBackground(new Color(255, 255, 153));
		panelAgregarProducto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		panelNorte.add(panelAgregarProducto, BorderLayout.CENTER);
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

		// panel de boton agregar producto
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(new Color(255, 255, 204));
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelNorte.add(panelBoton, BorderLayout.SOUTH);

		panelBoton.add(construirBotonAgregarProducto());

		// panel lateral para style en east

		JPanel panelIsquierda = new JPanel();
		panelIsquierda.setBackground(UIManager.getColor(new Color(255, 255, 204)));
		panelIsquierda.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelNorte.add(panelIsquierda, BorderLayout.EAST);
		panelIsquierda.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 30));

		// panel lateral para style west
		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(UIManager.getColor(new Color(255, 255, 204)));
		panelDerecho.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelNorte.add(panelDerecho, BorderLayout.WEST);
		panelDerecho.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 30));

	}
	


	
	
	private void construccionTablaProductos(JTable tableProductos) {
		// CREACION TABLE

		// diseño de tabla
		tableProductos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableProductos.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelCenter.add(tableProductos.getTableHeader(), BorderLayout.PAGE_START);
		panelCenter.add(new JScrollPane(tableProductos), BorderLayout.CENTER);

	}
	

	public  void construirPanelTablaProductos(JTable tableProductos) {

		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout(5, 5));
		

		construccionTablaProductos(tableProductos);

		// panel izquierdo
		JPanel panelIsquierda = new JPanel();
		panelIsquierda.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCenter.add(panelIsquierda, BorderLayout.EAST);
		panelIsquierda.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 30));
		// Panel derecho
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCenter.add(panelDerecho, BorderLayout.WEST);
		panelDerecho.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 30));
		panelCenter.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 7));
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		

	}
	


	private JButton construirBotonActualizar() {

		JButton actualizarProducto = new JButton("Actualizar Producto");
		actualizarProducto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		actualizarProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateProduct vista = new UpdateProduct(idProducto);

			}
		});

		return actualizarProducto;

	}
	
	private void eliminarConBoton() {
		ControllerProducto controlador1 = new ControllerProducto();
		controlador1.eliminar(controlador1.obtenerProducto(idProducto));
		
	}

	private JButton construirBotonBorrar() {
		JButton borrarProducto = new JButton("Borrar Producto");
		borrarProducto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
	

		borrarProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarConBoton();
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				
			}
		});
		return borrarProducto;

	}
	
	private String mostrarInforme() {
		
		ControllerProducto controlador = new ControllerProducto();
		List<Producto> listaOrdenada=controlador.ordenarProductos();
		//los tres produscots mas caros
		String productoUno = listaOrdenada.get(0).getNombre();
		String productoDos = listaOrdenada.get(1).getNombre();
		String productoTres = listaOrdenada.get(2).getNombre();
		
		String informeProductos = productoUno +" , "+productoDos+" , "+productoTres;
		return informeProductos;
		
		
		
	}

	private JButton construirBotonInforme() {
		JButton informes = new JButton("Informes");
		informes.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		informes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, mostrarInforme());
				

			}
		});
		return informes;

	}

	private void construirPanelBotonesOperaciones() {

		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));

		panelSur.add(construirBotonBorrar());
		panelSur.add(construirBotonActualizar());
		panelSur.add(construirBotonInforme());
		panelSur.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 7));

	}
	
	private void agregarEventoTabla(TablaProductos tablaProductos) {
		JTable tableProductos = tablaProductos.getTablaProducto();
		
		tableProductos.addMouseListener(new MouseAdapter() {
			 
			 public void mouseClicked (MouseEvent e) {
				idProducto= tableProductos.rowAtPoint(e.getPoint());
				controlador = new ControllerProducto();
				
				System.out.println("row  " + idProducto );
				System.out.println("row  " + controlador.obtenerProducto(idProducto) );
	 
	 }});
		
	}

	private void initialize() {

		
		construirFrame();
		contruirPanelAgregarProducto();
	
		construirPanelTablaProductos(tablaProductos.getTablaProducto());
		agregarEventoTabla( tablaProductos);
		construirPanelBotonesOperaciones();

	}

}
