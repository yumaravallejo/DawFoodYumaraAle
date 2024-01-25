/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class Metodos {

    // Metodo que muestra el menú inicial el cual pregunta en que modo iniciar el TPV
    // el cual devuelve un int con la respuesta del cliente
    public static int menuInicial() {
        String[] botones = {" Modo Usuario", " Modo Administrador"};

        int variable = JOptionPane.showOptionDialog(null,
                " ¿Que modo desea usar?", "Modo de uso", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

        return variable;
    }

    // Metodo que controla al completo el TPV haciendo llamamientos a otros metodos
    public static void encenderTPV() {
        
        Catalogo p = new Catalogo();
        p.listaProductos();

        // Variable que sirve para comprobar si repetir o no el programa ( Apagar el
        // TPV o no)
        boolean repeticion = true;

        // do-while para controlar cuando salir o no del TPV
        do {
            // Switch para controlar las distintas opciones de inicio del TPV.
            // El método menúInicial nos dará un tipo int con la opción elegida
            switch (menuInicial()) {

                case 0 -> { //Modo Usuario
                    usuario();
                }

                case 1 -> { //Modo Administrador

                }
            }
        } while (repeticion);
    }

    public static int menuOpciInicial() {

        //Mostrará la pregunta con 4 botones y devolverá números según la opción elegida, empezando por el 0
        String[] botones = {" Ver comida", " Ver bebidas", " Ver postres", "Ver carrito"};

        int eleccion = JOptionPane.showOptionDialog(null,
                " ¿Qué quiere ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

        return eleccion;
    }

    public static void mostrarComida() {

    }

    public static void usuario() {

        switch (menuOpciInicial()) {

            case 0 -> { //Ver Comidas
                
            }
            case 1 -> { //Ver bebidas

            }

            case 2 -> { //Ver postres

            }

            case 3 -> { //Ver carrito

            }

        }
    }
}
