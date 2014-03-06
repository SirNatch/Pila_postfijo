package postfijo;

import postfijo.Nodo;

public class Pila {
    Nodo raiz;
    Nodo fondo;

    public boolean vacia(){
        if(raiz == null)
            return true;
        else
            return false;
    }
    
    public void push(char dato){
        Nodo nuevo = new Nodo(dato);
        if(vacia()){
            raiz = nuevo;                       
            fondo = nuevo;
        }else{
            fondo.setLiga(nuevo);
            fondo = nuevo;
        }
    }
    
    public Nodo pop(){ 
        
        if(vacia())
            return null;
        else{
            if(raiz == fondo){
                Nodo res = new Nodo(raiz.getDato());
                raiz = null;
                fondo = null;
                return res;
            }else{
                Nodo p = raiz;
                while(p.getLiga()!=fondo){
                    p=p.getLiga();
                }
                Nodo q = new Nodo(fondo.getDato());
                fondo = p;
                fondo.setLiga(null);
                return q;
            }
        }
        
    }
    
    public Nodo peek(){ 
           return fondo; 
    }
    
    public String imprimir(){
        String aux = "";
        while(!vacia()){
            aux = aux + pop().getDato();
        }
        return aux;
    }
}
