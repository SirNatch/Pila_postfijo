package postfijo;

public class Nodo<T> {
        
    private char signo;
    private Nodo<T> liga;
    
    Nodo(){
        
    }
    
    Nodo(char info){
        this.signo=info;
        this.liga=null;
    }

    /**
     * @return the dato
     */
    public char getDato() {
        return signo;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(char dato) {
        this.signo = dato;
    }

    /**
     * @return the liga
     */
    public Nodo<T> getLiga() {
        return liga;
    }

    /**
     * @param liga the liga to set
     */
    public void setLiga(Nodo<T> liga) {
        this.liga = liga;
    }
}
