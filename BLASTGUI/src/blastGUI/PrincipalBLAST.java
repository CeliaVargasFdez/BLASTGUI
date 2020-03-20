package blastGUI;

import javax.swing.*;
import java.awt.*;

public class PrincipalBLAST {

	public static void createAndShowGUI() {
		JFrame myFrame = new JFrame("BLAST GUI");
		VistaBLAST vista= new VistaBLAST();
		
		ControlBLAST control = new ControlBLAST(vista);
		vista.Controller(control);

		myFrame.setContentPane(vista);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.setSize(1300,700);

	}


	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}
}
