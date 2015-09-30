package email;


import java.io.FileReader;

import java_cup.runtime.SimpleSymbolFactory;
import java_cup.runtime.SymbolFactory;
import email.Lexer;
import email.Parser;

public class Main {

	static public void main(String argv[]) {    
    try {
    	String name;
    	if (argv.length == 1) {
    		name = argv[0];
    	} else {
    		name = "test.txt";
    	}
    	SymbolFactory csf = new SimpleSymbolFactory ();
    	Lexer l = new Lexer(new FileReader(name));
    	l.setSymbolFactory(csf);
    	Parser p = new Parser(l, csf);
    	p.setServer(new EmailServer());
    	p.parse();      
    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
}


