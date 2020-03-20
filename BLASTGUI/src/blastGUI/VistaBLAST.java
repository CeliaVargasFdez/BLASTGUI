package blastGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VistaBLAST extends JPanel{
	//Atributos para el panel de eleccion de Bases de Datos
	private JPanel panelBasesdeDatos;
	private JComboBox<String> cbBBDDProtSec;
	private JComboBox<String> cbBBDDIndex;
	private JLabel labelBBDDProtSec;
	private JLabel labelBBDDIndex;
	
	//Atributos para el Panel Botones de radio
	private JPanel panelBotonesRadio;
	private JRadioButton bProteinas;
	private JRadioButton bSeqNuc;
	private ButtonGroup botonesTipoBusqueda;
	private JLabel labelTipoBusq;
	
	//Atributos para el panel Combo Box
	private JPanel panelComboBox;
	private JComboBox<String> cbSecuencias;
	private JLabel labelIntrSeq;
	
	//Atributos para el panel Caja de Texto
	private JPanel panelTextArea;
	private JTextArea tPorcentaje;
	private JLabel labelPorcent;
	
	//Atributos para el panel de los resultados
	private JPanel panelResultados;
	private JLabel labelResult;
	private JTextArea tResultados;
	private JScrollPane scrollResult;
	
	//Boton buscar
	private JButton bBuscar;
	
	//Declaramos un panel auxiliar
	private JPanel panelAux1;
	
	
	public VistaBLAST() {
		
		//Panel eleccion Bases de Datos
		panelBasesdeDatos = new JPanel();
		panelBasesdeDatos.setLayout(new GridLayout(2,2));
		panelBasesdeDatos.setOpaque(false);
		
		String[] BBDDProtSec = {"yeast.aa"};
		String[] BBDDIndex = {"yeast.aa.indexs"};
		
		cbBBDDProtSec = new JComboBox<String>(BBDDProtSec);
		cbBBDDProtSec.setBackground(Color.white);
		cbBBDDIndex = new JComboBox<String>(BBDDIndex);
		cbBBDDIndex.setBackground(Color.white);
		
		labelBBDDProtSec = new JLabel("Selecciona el archivo de búsqueda:");
		labelBBDDIndex = new JLabel("Selecciona el archivo de índices:");
		
		panelBasesdeDatos.add(labelBBDDProtSec);
		panelBasesdeDatos.add(cbBBDDProtSec);
		panelBasesdeDatos.add(labelBBDDIndex);
		panelBasesdeDatos.add(cbBBDDIndex);
		
		
		//Panel Botones de Radio Tipo de Busqueda
		panelBotonesRadio = new JPanel();
		panelBotonesRadio.setLayout(new BorderLayout());
		panelBotonesRadio.setOpaque(false);

		labelTipoBusq = new JLabel("Tipo de búsqueda:");
		bProteinas = new JRadioButton("Proteínas");
		bProteinas.setOpaque(false);
		bSeqNuc = new JRadioButton("Secuencias de nucleótidos");
		bSeqNuc.setOpaque(false);
		botonesTipoBusqueda = new ButtonGroup();
		botonesTipoBusqueda.add(bProteinas);
		botonesTipoBusqueda.add(bSeqNuc);
		bProteinas.setSelected(true);
		
		panelBotonesRadio.add(labelTipoBusq, BorderLayout.NORTH);
		panelBotonesRadio.add(bProteinas, BorderLayout.CENTER);
		panelBotonesRadio.add(bSeqNuc, BorderLayout.SOUTH);
		
		//Panel ComboBox Secuencias
		panelComboBox = new JPanel();
		panelComboBox.setLayout(new BorderLayout());
		panelComboBox.setOpaque(false);

		cbSecuencias = new JComboBox<String>();
		cbSecuencias.setEditable(true);
		labelIntrSeq = new JLabel("Introduzca la secuencia "
				+ "que desee buscar:");
		
		panelComboBox.add(labelIntrSeq, BorderLayout.NORTH);
		panelComboBox.add(cbSecuencias, BorderLayout.SOUTH);
		
		//Panel Area de Texto Porcentaje
		panelTextArea = new JPanel();
		panelTextArea.setOpaque(false);

		labelPorcent = new JLabel("Introduzca un porcentaje de "
				+ "similitud entre 0.0 y 1.0");
		tPorcentaje = new JTextArea("",1,3);
		tPorcentaje.setEditable(true);
		
		panelTextArea.add(labelPorcent);
		panelTextArea.add(tPorcentaje);
		
		//Panel Resultados
		panelResultados = new JPanel();
		panelResultados.setLayout(new BorderLayout());
		panelResultados.setOpaque(false);

		tResultados = new JTextArea(300,100);
		tResultados.setEditable(false);
		labelResult = new JLabel("El resultaod de su búsqueda es:");
		labelResult.setForeground(Color.WHITE);
		
		scrollResult = new JScrollPane(tResultados);
		scrollResult.setPreferredSize(new Dimension(800,500));
		
		panelResultados.add(labelResult, BorderLayout.NORTH);
		panelResultados.add(scrollResult, BorderLayout.CENTER);
		
		//Boton Buscar
		bBuscar = new JButton("Buscar");
		
		//Panel Auxiliar
		panelAux1 = new JPanel();
		panelAux1.setBackground(Color.YELLOW);
		
		panelAux1.add(panelBasesdeDatos);
		panelAux1.add(panelBotonesRadio);
		panelAux1.add(panelComboBox);
		panelAux1.add(panelTextArea);
		panelAux1.add(bBuscar);
		
		//Añadimos los paneles a la vista
		add(panelAux1, "North");
		add(panelResultados, "Center");
		setBackground(Color.RED);
		
	}
	
	public JTextArea gettResultados() {
		return tResultados;
	}


	public JComboBox<String> getCbBBDDProtSec() {
		return cbBBDDProtSec;
	}


	public JComboBox<String> getCbBBDDIndex() {
		return cbBBDDIndex;
	}


	public JRadioButton getbProteinas() {
		return bProteinas;
	}


	public JRadioButton getbSeqNuc() {
		return bSeqNuc;
	}


	public JComboBox<String> getCbSecuencias() {
		return cbSecuencias;
	}


	public JTextArea gettPorcentaje() {
		return tPorcentaje;
	}


	public JButton getbBuscar() {
		return bBuscar;
	}
	
	public void Controller (ActionListener al) {
		bBuscar.addActionListener(al);
	}
	
}
