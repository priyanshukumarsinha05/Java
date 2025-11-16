
%{
    #include <stdio.h>
    #include <string.h>
    #include <stdlib.h>

    int digit_sum(const char *s){
        int sum = 0;
        for(int i=0; i<strlen(s); i++){
            sum+=s[i]-'0';
        }
        return sum;
    }

    int is_ascending(const char *s){
        for(int i=1; i<strlen(s); i++){
            if(s[i-1]>s[i]){
                return 0;
            }
        }
        return 1;
    }

    int at_least_two_fives(const char *s){
        int len = strlen(s);
        if(len < 5){
            return 0;
        }
        for(int i=0; i<=len-5; i++){
            int count = 0;
            for(int j=0; j<5; j++){
                if(s[i+j] == '5') count++;
            }
            if(count<2){
                return 0;
            }
        }
        return 1;
    }

    int modulo5(const char *s){
        int rem = 0;
        for(int i=0; i<strlen(s); i++){
            rem = (rem*2+(s[i]-'0'))%5;
        }
        return rem;
    }
%}

%%
[0-9]+ {
    char *s = strdup(yytext);
    int len = strlen(s);
    
    // 1. Ends with 00
    if(len>=2 && s[len-2] == '0' && s[len-1] == '0'){
        printf("Ends with 00: %s\n", s);
    }

    // 2. Contains three Consecutive 222's (i.e 222222)
    if(strstr(s, "222222")){
        printf("Contains three Consecutive 222's: %s\n", s);
    }

    // 3. Every block of 5 has at least two 5's
    if(at_least_two_fives(s)){
        printf("Valid: Every block of 5 Contains at least two 5's: %s\n", s);
    }

    // 4. Starts with 1 and binary values divisible by 5
    if(s[0] == '1' && modulo5(s) == '0'){
        printf("Binary String divisible by 5: %s \n", s);
    }

    // 5. 10th Symbol from right is 1
    if(len>=10 && s[len-10]=='1'){
        printf("10th symbol from the right is 1:%s\n", s);
    }

    // 6. 4-digit number with digit sum 9
    if(len == 4 && digit_sum(s) == 9){
        printf("4-digit number with digit sum 9: %s\n", s);
    }

    // 7. 4-digit number with digits in ascending order
    if(len == 4 && is_ascending(s)){
        printf("4 digit number with digits in ascending order : %s\n", s);
    }

    free(s);

}

.|\n {
    //Ignore
}
%%


int main(){
    yylex();
    return 0;
}