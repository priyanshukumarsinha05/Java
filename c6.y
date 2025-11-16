%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int yylex();
void yyerror(const char *s);

int tempCount =1;
char *newTemp(){
    static char temp[10];
    sprintf(temp, "t%d", tempCount++);
    return strdup(temp);
}
%}

%union{
    char* str;
}

%token <str> ID
%type <str> expr
%left '+''-'
%left '*''/'

%%
stmt: ID'='expr '\n' {
    printf("%s=%s\n", $1, $3);
}
;
expr: expr '+' expr {
    char* temp = newTemp();
    printf("%s=%s+%s\n", temp, $1, $3);
    $$ = temp;
}
| expr '-' expr {
    char* temp = newTemp();
    printf("%s=%s-%s\n", temp, $1, $3);
    $$ = temp;
}
| expr '*' expr {
    char* temp = newTemp();
    printf("%s=%s*%s\n", temp, $1, $3);
    $$ = temp;
}
| expr '/' expr {
    char* temp = newTemp();
    printf("%s=%s/%s\n", temp, $1, $3);
    $$ = temp;
} 
| '('expr')' {
    $$ = $2;
}
| ID {
    $$=$1;
}
;
%%

int main(){
    printf("Enter an assignment expression : \n");
    return yyparse();
}

void yyerror(const char*s){
    fprintf(stderr, "Error: %s\n", s);
}

