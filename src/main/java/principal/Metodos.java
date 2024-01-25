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

    public static int menuInicial() {
        String[] botones = {" Modo Usuario", " Modo Administrador"};

        int variable = JOptionPane.showOptionDialog(null,
                " ¿Que modo desea usar?", "Modo de uso", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

        return variable;
    }

    public static void encenderTPV(TPV TPV) {

        boolean repeticion = true;

        do {
            //El método menúInicial nos dará un tipo int con la opción elegida
            switch (menuInicial()) {
                //Modo Usuario
                case 0 -> {
                    usuario();
                }
                //Modo Administrador
                case 1 -> {

                }
            }
        } while (repeticion);
    }

    public static void usuario() {
        //Mostrará la pregunta con 4 botones y devolverá números según la opción elegida, empezando por el 0
        String[] botones = {" Ver comida", " Ver bebidas", " Ver postres", "Ver carrito"};

        int eleccion = JOptionPane.showOptionDialog(null,
                " ¿Qué quiere ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
        switch (eleccion) {

            case 0 -> { //Ver Comidas
                String[] botonesC = {"Carnes", "Pastas", "Mariscos"};

                int eleccionComida = JOptionPane.showOptionDialog(null,
                        " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesC, botonesC[0]);
                switch (eleccionComida) {
                    case 0 -> { //Ver Carnes
                        String[] botonesCar = {"", "", ""};

                        int eleccionCarne = JOptionPane.showOptionDialog(null,
                                " ¿Qué tipo de plato de carne quieres?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesCar, botonesCar[0]);
                        switch (eleccionCarne) {

                        }
                    }

                    case 1 -> { //Ver Pastas 
                        String[] botonesPas = {"", "", ""};

                        int eleccionPas = JOptionPane.showOptionDialog(null,
                                " ¿Qué tipo de plato de carne quieres?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesPas, botonesPas[0]);
                        switch (eleccionPas) {

                        }
                    }

                    case 2 -> { //Ver Mariscos
                        String[] botonesMar = {"", "", ""};

                        int eleccionMar = JOptionPane.showOptionDialog(null,
                                " ¿Qué tipo de plato de marisco quieres?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesMar, botonesMar[0]);
                        switch (eleccionMar) {

                        }
                    }
                }
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
