/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

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
            int eleccion = menuInicial();

            switch (eleccion) {
                case 0 -> {
                    System.out.println("Modo Usuario");

                }
                case 1 -> {
                    System.out.println("Modo Administrador");

                }
            }
        } while (repeticion);
    }
}
