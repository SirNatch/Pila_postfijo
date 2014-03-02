package postfijo;

public class Cola {
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
    
    public char pop(){ 
        if( !vacia() ){
            char dato = raiz.getDato();
            if(raiz == fondo){
                raiz = null;
                fondo = null;
            }else{
                raiz = raiz.getLiga();
            }
            return dato;
        }else
            return '#';
        
    }
    
    public char peek(){ 
        if( !vacia() )
           return raiz.getDato(); 
        return '#';
    }
    
    public String imprimir(){
        String aux = "";
        while(!vacia()){
            aux = aux + pop();
        }
        return aux;
    }
    

}
