package com.arithmeticparser.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JFrame {
	
	public PanelPrincipal(int filas) {
        // Configura el título y el cierre de la ventana
        setTitle("Pantalla Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura el diseño de la ventana como GridLayout
        setLayout(new GridLayout(filas, 3)); // Cambia las dimensiones según tus necesidades

        // Crea y agrega los paneles en la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(panel);
            }
        }

        // Configura y agrega el menú
        JMenuBar menuBar = new JMenuBar();
        JMenu archivoMenu = new JMenu("Archivo");
//        JMenuItem NuevaConsulta = new JMenuItem("Nuevo");   
        
        JMenuItem salirItem = new JMenuItem("Salir");
        salirItem.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra el programa cuando se seleccione "Salir"
                System.exit(0);
            }
        });

//        archivoMenu.add(NuevaConsulta);
        archivoMenu.addSeparator();
        archivoMenu.add(salirItem);

        menuBar.add(archivoMenu);
        setJMenuBar(menuBar);

	}
	
	public void llenarlexema(String tokens[][],int nfilas) {
		Component[] panels = getContentPane().getComponents();
		int posicion = 0;
		for(int filas=0; filas < nfilas ;filas++) {
			for(int columnas=0; columnas < 3 ;columnas++) {
				((JPanel) panels[posicion]).add(new JLabel(tokens[columnas][filas]));
				posicion++;
			}
		}
	}
	
}
