%{
#include <stdio.h>
%}

%%
[ \t\n]+ {printf(" ");}
[^ \t\n]+ {printf("%s", yytext);}
%%

int main(){
    yylex();
    return 0;
}