package com.arithmeticparser.gui;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.filechooser.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFiles {
	private File file1;
	private File file2;
	private ArrayList<String> tokenText = new ArrayList<String>();
	private String sourceCodeText = "";
	
    public ReadFiles() {
    	 FileFilter txtFileFilter = new FileFilter() {
             @Override
             public boolean accept(File file) {
                 return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
             }

             @Override
             public String getDescription() {
                 return "Text Files (*.txt)";
             }
         };
         
        JFileChooser fileChooser1 = new JFileChooser();
        JFileChooser fileChooser2 = new JFileChooser();
        
        fileChooser1.setFileFilter(txtFileFilter);
        fileChooser2.setFileFilter(txtFileFilter);
        
        // Mostrar el cuadro de diálogo y obtener la respuesta del usuario para el primer archivo
        int select1 = fileChooser1.showOpenDialog(null);

        // Mostrar el cuadro de diálogo y obtener la respuesta del usuario para el segundo archivo
        int select2 = fileChooser2.showOpenDialog(null);

        // Si el usuario selecciona ambos archivos
        if (select1 == JFileChooser.APPROVE_OPTION && select2 == JFileChooser.APPROVE_OPTION) {
            file1 = fileChooser1.getSelectedFile();
            file2 = fileChooser2.getSelectedFile();

            try {
                // Leer y mostrar contenido del primer archivo
                
                saveText();

                // Leer y mostrar contenido del segundo archivo
                

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveText() throws IOException {
        // Abrir el archivo para lectura
        FileReader lector = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(lector);
        //System.out.println("Contenido del primer archivo:");
        String line  = "";
        // Leer y mostrar cada línea del archivo
        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            tokenText.add(line);
        }
        bufferedReader.close();
        lector.close();
        lector = new FileReader(file2);
        bufferedReader = new BufferedReader(lector);
        //System.out.println("\nContenido del segundo archivo:");
        line  = "";
        
        while ((line = bufferedReader.readLine()) != null) {
        	if(line.contains("//")) {
				
			}else if(line.contains("*/") ){
				while(!line.contains("/*")){
					line =bufferedReader.readLine();
				}
			}
			else {
				//System.out.println(line);
	            sourceCodeText = sourceCodeText + line + "\n";
			}

        }
        // Cerrar los recursos después de su uso
        bufferedReader.close();
        lector.close();
    }

	public ArrayList<String> getTokenText() {
		return tokenText;
	}

	public String getSourceCodeText() {
		return sourceCodeText;
	}


    
    
}
