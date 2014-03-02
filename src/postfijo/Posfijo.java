package postfijo;


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
        else
            return 1;
             
    }
    
    public String conv_posfija(String ecuacion){
        char [] sim = ecuacion.toCharArray();
        int i = 0;
        Cola cola = new Cola();
        String epos = "";
          
        while( i < sim.length ){
            char aux = sim[i];
            i++;
            if(aux == '('){
                cola.push(aux);
            }else{
                if(aux == ')'){
                    while(cola.peek() != '('){
                     epos = epos + cola.pop();
                    }
                    cola.pop();
                }else{
                    if(!esOperador(aux)){
                        epos = epos + aux;
                    }else{
                        //llamar pila_vacia
                        while(!cola.vacia() && prioridad(aux)< prioridad(cola.peek()) ){

                            epos = epos + cola.pop();
                        //llamar pila_vacia
                        }
                        cola.push(aux);
                    }  
                }
            }
        }
        //llmara pila vacia
        while(!cola.vacia()){
            epos = epos + cola.pop();
        }
        return epos;
    }      
}
