package postfijo;

/**
 *
 * @author Francisco Ignacio Nuñez Valdivieso
 */
public class Menu {

    
    public static void main(String[] args) {
        Posfijo prueba = new Posfijo();
        String cadena ="(5-2)*3*(3+7)";
        System.out.println(prueba.conv_posfija(cadena));
    }
    
}
