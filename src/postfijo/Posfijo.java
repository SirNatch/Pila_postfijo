package postfijo;

import postfijo.Pila;

public class Posfijo<T> {
           
    public String[] dividir(String cadena){
        char [] sim = cadena.toCharArray();
        
        int n = 0;
        boolean bandera = true;
        
 
        for (int i = 0; i < sim.length; i++) {
            
            if(!esOpChar(sim[i]))
               do{
                   if(i+1<sim.length)
                       if(!esOpChar(sim[i+1]))
                        i++;
                   else
                       bandera = false;
               }while(esOpChar(sim[i]) && bandera);

            n++;
        }

        String res []= new String[n];
        int j = 0;
        bandera = true;
        
        for(int i = 0; i<res.length; i++){
           String  p = "";
           p = p + sim[j];

           if(!esOpChar(sim[j])){
               
               do{
                   if(j+1<sim.length)
                       if(!esOpChar(sim[j+1])){
                        p = p + sim[j+1];
                        j++;
                        }
                   else
                       bandera = false;
               }while(esOpChar(sim[j]) && bandera);
           }
           res[i]=p;
           j++;
        }
               
        return res;
    }
    
    public boolean esOpCad(String x){
        if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("^"))
            return true;
        else 
            return false;
    }
    
    public boolean esOpChar(char x){
        if(x=='+' || x=='-' || x=='*' || x=='/' || x=='^' || x == '(' || x == ')')
            return true;
        else 
            return false;
    }
    
    public int prioridad(String x){
        
        if(x.equals("^"))
            return 3;
        else if(x.equals("*")  || x.equals("/"))
            return 2;
        else if(x.equals("+") || x.equals("-"))
            return 1;
        else 
            return 0;
    }
    
    public String conv_posfija(String ecuacion){
        String [] sim = dividir(ecuacion);

        int i = 0;

        Pila lista = new Pila();
        String epos = "";
        
        while( i < sim.length ){
        String aux = "";
        aux = aux + sim[i];   
        i++;
            
            if(aux.equals("(")){
                lista.push(aux);
            }else{
                if(aux.equals(")")){
                    while(!(lista.peek().getDato().equals("("))){
                    epos = epos+lista.pop().getDato()+"|";   
                }
                    lista.pop();
                }else{
                    if(!esOpCad(aux)){
                        epos = epos + aux +"|";
                    }else{
                        while(!lista.vacia() && prioridad(aux)<= prioridad((String)lista.peek().getDato())){
                         
                            epos = epos+lista.pop().getDato()+"|"; 
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
