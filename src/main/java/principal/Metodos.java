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
    public static void encenderTPV(TPV TPV) {

        Catalogo catalogo = new Catalogo();
        catalogo.listaProductos();

        Carrito carrito = new Carrito();

        // Variable que sirve para comprobar si repetir o no el programa ( Apagar el
        // TPV o no)
        boolean repeticion = true;

        // do-while para controlar cuando salir o no del TPV
        do {
            // Switch para controlar las distintas opciones de inicio del TPV.
            // El método menúInicial nos dará un tipo int con la opción elegida
            switch (menuInicial()) {

                case 0 -> { //Modo Usuario
                    usuario(catalogo, carrito);
                }

                case 1 -> { //Modo Administrador

                }
            }

        } while (repeticion);
    }

    public static void usuario(Catalogo c, Carrito carrito) {

        String[] botones = {"Ver Comida", "Ver Bebidas", "Ver Postres", "Ver Carritos"};

        int eleccion = JOptionPane.showOptionDialog(null,
                " ¿Qué quieres ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

        switch (eleccion) {

            // ------------------------------------------------------------------------------------------------------------------------------
            case 0 -> { //Ver Comidas
                String[] botonesC = {"Carnes", "Pastas", "Mariscos", "Volver"};

                int eleccionComida = JOptionPane.showOptionDialog(null,
                        " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesC, botonesC[0]);
                switch (eleccionComida) {

                    case 0 -> { //Ver Carnes
                        Object[] botonesCar = {"Hamburguesa", "Entrecot", "Nuggets",};

                        Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                                botonesCar, botonesCar[0]);

                        if (opcion.equals("Hamburguesa")) {
                            String[] botonesConf = {"Sí", "No"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(0).toString() + "\n ¿Estás seguro que quieres pedirlo?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    carrito.añadirCarrito(c.obtener(0), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Entrecot")) {
                            String[] botonesConf = {"Sí", "No"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(1).toString() + "\n ¿Estás seguro que quieres pedirlo?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                 case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                    try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(1).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                    }
                                    } catch (IllegalArgumentException iae) {
                                        JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                    }
                                    }while (!valido );
                                    carrito.añadirCarrito(c.obtener(1), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Solomillo")) {
                            String[] botonesConf = {"Sí", "No"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(13).toString() + "\n ¿Estás seguro que quieres pedirlo?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                 case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                    try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(13).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                    }
                                    } catch (IllegalArgumentException iae) {
                                        JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                    }
                                    }while (!valido );
                                    carrito.añadirCarrito(c.obtener(13), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                    }

                    case 1 -> { //Ver Pastas 
                        Object[] botonesCar = {"Pasta carbonara", "Lasaña", "Pasta al pesto",};

                        Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                                botonesCar, botonesCar[0]);

                        if (opcion.equals("Pasta Carbonara")) {
                            String[] botonesConf = {"Sí", "No"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(2).toString() + "\n ¿Estás seguro que quieres pedirlo?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                 case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                    try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(2).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                    }
                                    } catch (IllegalArgumentException iae) {
                                        JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                    }
                                    }while (!valido );
                                    carrito.añadirCarrito(c.obtener(2), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Lasaña")) {
                            String[] botonesConf = {"Sí", "No"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(15).toString() + "\n ¿Estás seguro que quieres pedirlo?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                    try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(15).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                    }
                                    } catch (IllegalArgumentException iae) {
                                        JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                    }
                                    }while (!valido );
                                    carrito.añadirCarrito(c.obtener(15), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Pasta al pesto")) {
                            String[] botonesConf = {"Sí", "No"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(16).toString() + "\n ¿Estás seguro que quieres pedirlo?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                    try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(16).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                    }
                                    } catch (IllegalArgumentException iae) {
                                        JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                    }
                                    }while (!valido );
                                    carrito.añadirCarrito(c.obtener(16), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
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

                    case 3 -> { //Volver

                    }
                }

            }
            // ------------------------------------------------------------------------------------------------------------------------------
            case 1 -> { //Ver bebidas
                String[] botonesC = {"Carnes", "Pastas", "Mariscos"};

                int eleccionComida = JOptionPane.showOptionDialog(null,
                        " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesC, botonesC[0]);
                switch (eleccionComida) {
                    case 0 -> { //Ver Refrescos
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

                    case 3 -> { //Volver

                    }
                }
            }
            // ------------------------------------------------------------------------------------------------------------------------------
            case 2 -> { //Ver postres

            }
            // ------------------------------------------------------------------------------------------------------------------------------
            case 3 -> { //Ver carrito

            }

        }
    }
}
