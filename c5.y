%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
int yyerror(const char * msg);
%}

%token NUMBER

%%
program:
    program expr '\n' {printf("Result = %d\n", $2);}
    | /* empty */ ;

    expr:
    expr '+' term { $$=$1+$3; }
    | expr '-' term { $$=$1-$3; }
    | term
    ;

    term:
    term '*' factor { $$=$1*$3; }
    | term '/' factor { 
        if($3==0){
            printf("Error: Division by zero\n");
            exit(1);
        }
        $$=$1/$3;
    }
    | factor { $$=$1; }
    ;

    factor:
    '('expr')' {$$=$2;}
    | NUMBER { $$=$1; }
    ;
%%


int main(){
    printf("Simple Calculator (type expressions, press Enter)\n");
    yyparse();
    return 0;
}

int yyerror(const char *msg){
    fprintf(stderr, "Parse error: %s\n", msg);
    return 1;
}