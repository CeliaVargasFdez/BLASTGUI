package blastGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import blast.BlastController;

public class ControlBLAST implements ActionListener {
	private VistaBLAST vista;

	ControlBLAST(VistaBLAST v){
		vista = v;
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(vista.getbBuscar())){
			parametrosCorrectos();
		}
	}

	public void parametrosCorrectos() {

		if (vista.getCbSecuencias().getSelectedItem()==null) {
			vista.gettResultados().setText("No se ha introducido "
					+ "ninguna secuencia.");
		}
		
		else if ((vista.gettPorcentaje().getText().equals(""))) {
			vista.gettResultados().setText("No se ha introducido ningún "
					+ "porcentaje de similitud.");

		}
		
		else if (((Float.parseFloat(vista.gettPorcentaje().getText()))>1.0) 
				|| ((Float.parseFloat(vista.gettPorcentaje().getText()))<0.1)) {
			vista.gettResultados().setText("El porcentaje de similitud introducido "
					+ "está fuera de los rangos.");
		}
		
		else if (tipoBusqueda()=='s') {
			vista.gettResultados().setText("La búsqueda de secuencias "
					+ "de nucleótidos no está disponible.");
		}

		else {
			String secuencia = vista.getCbSecuencias().getSelectedItem().toString().toUpperCase();
			int aparece = 0;
			for(int i=0; i < (vista.getCbSecuencias().getItemCount()); i++) {
				if ((secuencia == (vista.getCbSecuencias().getItemAt(i).toString()))) {
					aparece++;
				}
				i++;
			}
			if (aparece<1) {
				vista.getCbSecuencias().addItem(secuencia);
			}
			
			vista.gettResultados().setText(Busqueda());
		}	
	}

	public char tipoBusqueda() {
		char tipoBusq;
		if (vista.getbProteinas().isSelected()) {
			tipoBusq = 'p';
		}
		else {
			tipoBusq = 's';
		}
		return tipoBusq;
	}
	
	public String Busqueda () {
		char tipoBusq = tipoBusqueda();
		String seq = vista.getCbSecuencias().getSelectedItem().toString().toUpperCase();
		float porcent = Float.parseFloat(vista.gettPorcentaje().getText());
		String bbddSeq = vista.getCbBBDDProtSec().getSelectedItem().toString();
		String bbddIndex = vista.getCbBBDDIndex().getSelectedItem().toString();
		
		BlastController control = new BlastController();
		String resultadoBusqueda = null;
		
		try{
			resultadoBusqueda = control.blastQuery(tipoBusq, bbddSeq, bbddIndex, porcent, seq);

		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}
		return resultadoBusqueda;
	}

}
