%{
#include "y.tab.h"
#include <string.h>
%}

%%
[\n] {return '\n';}
[a-zA-Z_][a-zA-Z0-9_]* {
    yylval.str = strdup(yytext);
    return ID;
}
"=" {return '=';}
"+" {return '+';}
"-" {return '-';}
"*" {return '*';}
"/" {return '/';}
"(" {return '(';}
")" {return ')';}
. {return yytext[0];}
%%

int yywrap(){
    return 1;
}

