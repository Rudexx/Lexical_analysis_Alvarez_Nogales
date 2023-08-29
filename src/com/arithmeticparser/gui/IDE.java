package com.arithmeticparser.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IDE extends JFrame {
	
	private JButton loadFile;
	private JTextArea code;
	private JScrollPane sp;
	
	public IDE() {
		this.setTitle("Arithmetic Lexical Analyzer");
		this.setSize(300,300);
		this.setLayout(new GridLayout(4,1));
		this.buildComponents();
		this.getContentPane().add(this.loadFile);
		this.getContentPane().add(this.sp);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void buildComponents() {
		this.code = new JTextArea();
		this.sp = new JScrollPane(this.code);
		
		this.loadFile = new JButton("Load File");
		this.loadFile.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(null);
				File f = jfc.getSelectedFile();
				try {
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					String line = "";
					while((line = br.readLine())!=null) {
						code.append(line+"\n");
						
					}
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}							
			}
		});		
	}	
}
