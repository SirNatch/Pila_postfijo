package postfijo;

import postfijo.Pila;


public class Posfijo {
    
    public boolean esOperador(char x){
        if(x == '+' || x == '-' || x == '*' || x == '/' || x == '^')
            return true;
        else 
            return false;
    }
    
    public int prioridad(char x){
        
        if(x == '^')
            return 3;
        else if(x == '*' || x == '/')
            return 2;
        else if(x == '+' || x == '-')
            return 1;
        else return 0;
             
    }
    
    public String conv_posfija(String ecuacion){
        char [] sim = ecuacion.toCharArray();
        int i = 0;
        Pila lista = new Pila();
        String epos = "";
          
        while( i < sim.length ){
            char aux = sim[i];
            i++;
            if(aux == '('){
                lista.push(aux);
            }else{
                if(aux==')'){
                    while(lista.peek().getDato() != '('){
                    epos = epos+lista.pop().getDato();
                                        
                }
                    lista.pop();
                }else{
                    if(!esOperador(aux)){
                        epos = epos + aux;
                    }else{
                        while(!lista.vacia() && prioridad(aux)<= prioridad(lista.peek().getDato())){
                            epos = epos+lista.pop().getLiga();

                        }
                        lista.push(aux);
                    }
                }
            }
        }
        
        while(!lista.vacia()){
            epos = epos + lista.pop().getDato();
 
        }
        return epos;
    }      
}
