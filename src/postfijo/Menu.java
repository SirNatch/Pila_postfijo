package postfijo;

/**
 *
 * @author Francisco Ignacio Nuñez Valdivieso
 */
public class Menu {

    
    public static void main(String[] args) {
        Posfijo prueba = new Posfijo();
        Pila lista = new Pila();
        lista.push('2');
        lista.push('3');
        String cadena ="(5+3)*7";
        System.out.println(prueba.conv_posfija(cadena));
    }
    
}
