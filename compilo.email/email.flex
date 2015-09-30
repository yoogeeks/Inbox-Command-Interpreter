
%%
   
%package email
%class Lexer
%public
%line
%column
%cup


%%
[ \t\f]				{ }
[ \t\n\r]			{ }
^#.*				{ }

";"					{ return getSymbolFactory().newSymbol ("TERM", Sym.TERM); }

"send"				{ return getSymbolFactory().newSymbol ("SEND", Sym.SEND); }
"recieve"			{ return getSymbolFactory().newSymbol ("RECIEVE", Sym.RECIEVE); }
"removeFromSpam"	{ return getSymbolFactory().newSymbol ("REMOVEFROMSPAM", Sym.REMOVEFROMSPAM); }
"addToSpam"			{ return getSymbolFactory().newSymbol ("ADDTOSPAM", Sym.ADDTOSPAM); }
"inbox"				{ return getSymbolFactory().newSymbol ("INBOX", Sym.INBOX); }

[a-zA-Z][a-zA-Z0-9._]+@[a-zA-Z][a-zA-Z0-9]+.[a-zA-Z]{2,4}				{ return getSymbolFactory().newSymbol ("EMAIL", Sym.EMAIL, yytext()); }

   
[^]                 { throw new Error("Illegal character <"+yytext()+">"); }
