package com.arithmeticparser.main;


import com.arithmeticparser.tokens.LexerException;
import com.arithmeticparser.tokens.Token;
import com.arithmeticparser.tokens.Tokenizer;

import java.util.ArrayList;

import com.arithmeticparser.gui.ReadFiles;
public class TokenizerTest {
    public static void main(String[] args) {
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
        
        
        try {
            tokenizer.tokenize(read.getSourceCodeText());            

            System.out.println("\n=========TOKEN LIST==========\n");

            for (Token tok : tokenizer.getTokens()) {
                System.out.println("[Token:" + tok.token + " Lexema:" + tok.lexeme + " Posicion:" + tok.pos + "]");
            }
        } catch (LexerException e) {
            System.out.println(e.getMessage());
        }
        
    }
    

}
