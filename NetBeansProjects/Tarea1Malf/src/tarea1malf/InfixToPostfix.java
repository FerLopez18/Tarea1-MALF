/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1malf;

/**
 *
 * @author Roberto
 */
public class InfixToPostfix {
    private char stack[];
    private int top;

    public InfixToPostfix() {
        String er = "a|(a.b)*";
        this.stack = new char[er.length()];
        this.top = -1;
        char[] infix = new char[er.length()];
        char postfix[] = new char[er.length()];
        infix = er.toCharArray();
        conversion(infix,postfix); 
        imprimir("in", infix);
        imprimir("post", postfix);     
    }
    
    private void imprimir(String tipo, char fix[]){
        System.out.println(tipo+"fix: ");
        for (int i = 0; i<fix.length; i++) {
            System.out.printf(""+fix[i]);
        }
        System.out.println("");
    }
    
    private void push(char item){
        stack[++top] = item;
    }
    
    private char pop() {
        return stack[top--]; 
    } 
    
    private int precedencia(char simbolo){
        switch(simbolo) {
            case '*': 
               return 4; 
            case '.': 
               return 3;
            case '|':
                return 2;
            case '(': 
            case ')': 
            case '#':
               return 1; 
            default:
                return 0;
         } 
        
    }
     
    private boolean esOperador(char simbolo){
        switch(simbolo){
            case '*':
            case '.':
            case '|':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }
    
    private void conversion(char infix[], char postfix[]) {
        int i, j = 0; 
        char simbolo;
        stack[++top] = '#'; 
        for(i = 0;i<infix.length;i++) {
           simbolo = infix[i]; 
           if(!esOperador(simbolo)) {
              postfix[j] = simbolo; 
              j++; 
           } else {
              if(simbolo == '(') {
                 push(simbolo); 
              }else {
                 if(simbolo == ')') {
                    while(stack[top] != '(') {
                       postfix[j] = pop(); 
                       j++; 
                    } 
                    pop();
                 }else{
                    if(precedencia(simbolo)>precedencia(stack[top])) {
                       push(simbolo); 
                    }else{
                       while(precedencia(simbolo)<=precedencia(stack[top])) {
                          postfix[j] = pop(); 
                          j++; 
                       } 
                       push(simbolo); 
                    }
                 }
              }
           }
        }
        while(stack[top] != '#') {
           postfix[j] = pop(); 
           j++; 
        } 
        postfix[j]='\0';//null terminate string. 
     } 
}
