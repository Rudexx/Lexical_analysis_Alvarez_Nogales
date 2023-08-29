package com.arithmeticparser.main;

import com.arithmeticparser.tokens.LexerException;
import com.arithmeticparser.tokens.Token;
import com.arithmeticparser.tokens.Tokenizer;

import com.arithmeticparser.gui.PanelPrincipal;
import com.arithmeticparser.gui.ReadFiles;
public class TokenizerTest {
    public static void main(String[] args) {
    	funcionar();
    }
    
    private static void funcionar(){
    	
        Tokenizer tokenizer = new Tokenizer();    

        //tokenizer.add("ClassRoom|Begin|End|ln|sqrt", Token.FUNCTION); 
        //tokenizer.add("\\(", Token.OPEN_BRACKET); 
        //tokenizer.add("\\)", Token.CLOSE_BRACKET); 
        //tokenizer.add("[+-]", Token.PLUSMINUS); 
        //tokenizer.add("[*/]", Token.MULTDIV); 
        //tokenizer.add("\\^", Token.RAISED); 
        //tokenizer.add("[0-9]+", Token.NUMBER);
        //tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", Token.VARIABLE);
        
        ReadFiles read = new ReadFiles();
        
        for (int i = 0; i < read.getTokenText().size(); i++) {
        	String[] number =read.getTokenText().get(i).split(";");
        	tokenizer.add(number[0], Integer.parseInt(number[1]));
        	
		}
        int filas = 0;
        try {
            tokenizer.tokenize(read.getSourceCodeText());            
//            System.out.println("\n=========TOKEN LIST==========\n");
            for (Token tok : tokenizer.getTokens()) {
//                System.out.println("[Token:" + tok.token + " Lexema:" + tok.lexeme + " Posicion:" + tok.pos + "]");
                filas = filas + 1;
            }
            String matriz[][] = new String[3][filas];
            filas = 0;
            for(Token tok : tokenizer.getTokens()) {
            	matriz[0][filas] = "Token: " + tok.token;
            	matriz[1][filas] = "Lexema: " + tok.lexeme;
            	matriz[2][filas] = "Posicion: " + tok.pos;
            	filas++;
            }
            PanelPrincipal pantalla = new PanelPrincipal(filas);
            pantalla.setSize(400, 600); // Configura el tamaño de la ventana
            pantalla.setVisible(true);
            pantalla.llenarlexema(matriz, filas);
            
        } catch (LexerException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
