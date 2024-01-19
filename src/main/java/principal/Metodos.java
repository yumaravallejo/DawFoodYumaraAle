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

    public int menuInicial() {
        String[] botones = {" Modo Usuario", " Modo Administrador"};

        int variable = JOptionPane.showOptionDialog(null,
                " ¿Que modo desea usar?", "Modo de uso", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

        return variable;
    }

    public void encenderTPV() {

        boolean repeticion = true;

        do {
            //El método menúInicial nos dará un tipo int con la opción elegida
            switch (menuInicial()) {
                //Modo Usuario
                case 0 -> {

                }
                //Modo Administrador
                case 1 -> {
                    System.out.println("Modo Administrador");

                }
            }
        } while (repeticion);
    }

    public int menuOpciInicial() {

        //Mostrará la pregunta con 4 botones y devolverá números según la opción elegida, empezando por el 0
        String[] botones = {" Ver comida", " Ver bebidas", " Ver postres", "Ver carrito"};

        int eleccion = JOptionPane.showOptionDialog(null,
                " ¿Qué quiere ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

        return eleccion;
    }

    public void mostrarComida() {

    }

    public void pasarelaPago(PasarelaPago p) {

        boolean correcto = true;

        do {
            try {
                //Solicita la contraseña de la tarjeta de crédito
                String contraTexto = JOptionPane.showInputDialog(null,
                        "Introduce los últimos 4 dígitos de la contraseña");
                int contraTC = Integer.parseInt(contraTexto);
                if (contraTexto.length() != 4 ) {
                    System.out.println("Introduce 4 dígitos");
                    correcto = false;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Introduce valores correctos");
            }
        } while (!correcto);

        
    }

    public void usuario() {

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
