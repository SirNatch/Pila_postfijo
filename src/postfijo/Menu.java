package postfijo;

/**
 *
 * @author Francisco Ignacio Nuñez Valdivieso
 */
public class Menu {

    
    public static void main(String[] args) {
        Posfijo prueba = new Posfijo();
        String cadena ="(12+5)/5-(3+9)";
        System.out.println(prueba.conv_posfija(cadena));
    }
    
}
