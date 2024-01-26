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

        PasarelaPago p = new PasarelaPago();

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
                    usuario(TPV, catalogo, carrito, p);
                }

                case 1 -> { //Modo Administrador

                }
            }

        } while (repeticion);
    }

    public static void usuario(TPV TPV, Catalogo c, Carrito carrito, PasarelaPago p) {

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
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(0).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(0).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(0), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Entrecot")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(1).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
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
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(1), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Solomillo")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(13).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
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
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
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
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(2).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
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
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(2), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Lasaña")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(15).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
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
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(15), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Pasta al pesto")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(16).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
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
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(16), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                    }

                    case 2 -> { //Ver Mariscos
                        Object[] botonesCar = {"Gambas al pil-pil", "Ostras", "Almejas finas",};

                        Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                                botonesCar, botonesCar[0]);

                        if (opcion.equals("Gambas al pil-pil")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(3).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(3).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(3), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Ostras")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(17).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(17).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(17), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Almejas finas")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(18).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(18).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(18), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }
                    }

                    case 3 -> { //Volver

                    }
                }

            }
            // ------------------------------------------------------------------------------------------------------------------------------
            case 1 -> { //Ver bebidas
                String[] botonesC = {"Refrescos", "Zumos", "Bebidas Alcohólicas"};

                int eleccionBeb = JOptionPane.showOptionDialog(null,
                        " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesC, botonesC[0]);
                switch (eleccionBeb) {
                    case 0 -> { //Ver Refrescos
                        Object[] botonesCar = {"Coca-Cola", "Fanta Naranja", "Fanta Limón",};

                        Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                                botonesCar, botonesCar[0]);

                        if (opcion.equals("Coca-Cola")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(4).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(4).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(4), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Fanta Naranja")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(5).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(5).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(5), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Fanta Limón")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(6).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(6).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(6), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }
                    }

                    case 1 -> { //Ver Zumos 
                        Object[] botonesCar = {"Manzana", "Naranja", "Piña",};

                        Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                                botonesCar, botonesCar[0]);

                        if (opcion.equals("Manzana")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(7).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(7).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(7), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Naranja")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(8).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(8).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(8), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Piña")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(9).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(9).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(9), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }
                    }

                    case 2 -> { //Ver Alcohol
                        Object[] botonesCar = {"Cerveza", "Vino tinto", "Vino blanco",};

                        Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                                botonesCar, botonesCar[0]);

                        if (opcion.equals("Cerveza")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(10).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(10).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(10), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Vino tinto")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(11).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(11).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(11), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }

                        if (opcion.equals("Vino Blanco")) {
                            String[] botonesConf = {"Añadir", "Cancelar"};

                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(12).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (confirmar) {
                                case 0 -> {
                                    boolean valido = true;
                                    int cantidad = 0;
                                    do {
                                        try {
                                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                            if (cantidad < 0 || cantidad > c.obtener(12).getStock()) {
                                                JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                                valido = false;
                                            }

                                        } catch (IllegalArgumentException iae) {
                                            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                        }
                                    } while (!valido);
                                    carrito.añadirCarrito(c.obtener(12), cantidad);
                                }

                                case 1 -> {
                                    //Aquí debe volver atrás
                                }
                            }
                        }
                    }

                    case 3 -> { //Volver

                    }
                }
            }
            // ------------------------------------------------------------------------------------------------------------------------------
            case 2 -> { //Ver postres
                Object[] botonesCar = {"Crepes", "Tarta de queso", "Flan",};

                Object opcion = JOptionPane.showInputDialog(null, "¿Qué quieres pedir?", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
                        botonesCar, botonesCar[0]);

                if (opcion.equals("Crepes")) {
                    String[] botonesConf = {"Añadir", "Cancelar"};

                    int confirmar = JOptionPane.showOptionDialog(null, c.obtener(19).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                    switch (confirmar) {
                        case 0 -> {
                            boolean valido = true;
                            int cantidad = 0;
                            do {
                                try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(19).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                        valido = false;
                                    }

                                } catch (IllegalArgumentException iae) {
                                    JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                }
                            } while (!valido);
                            carrito.añadirCarrito(c.obtener(19), cantidad);
                        }

                        case 1 -> {
                            //Aquí debe volver atrás
                        }
                    }
                }

                if (opcion.equals("Tarta de queso")) {
                    String[] botonesConf = {"Añadir", "Cancelar"};

                    int confirmar = JOptionPane.showOptionDialog(null, c.obtener(20).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                    switch (confirmar) {
                        case 0 -> {
                            boolean valido = true;
                            int cantidad = 0;
                            do {
                                try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(20).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                        valido = false;
                                    }

                                } catch (IllegalArgumentException iae) {
                                    JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                }
                            } while (!valido);
                            carrito.añadirCarrito(c.obtener(20), cantidad);
                        }

                        case 1 -> {
                            //Aquí debe volver atrás
                        }
                    }
                }

                if (opcion.equals("Flan")) {
                    String[] botonesConf = {"Añadir", "Cancelar"};

                    int confirmar = JOptionPane.showOptionDialog(null, c.obtener(21).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                    switch (confirmar) {
                        case 0 -> {
                            boolean valido = true;
                            int cantidad = 0;
                            do {
                                try {
                                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Qué cantidad quieres pedir?"));
                                    if (cantidad < 0 || cantidad > c.obtener(21).getStock()) {
                                        JOptionPane.showMessageDialog(null, "Introduce una cantidad correcta");
                                        valido = false;
                                    }
                                } catch (IllegalArgumentException iae) {
                                    JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                }
                            } while (!valido);
                            carrito.añadirCarrito(c.obtener(21), cantidad);
                        }

                        case 1 -> {
                            //Aquí debe volver atrás
                        }
                    }
                }
            }
            // ------------------------------------------------------------------------------------------------------------------------------
            case 3 -> { //Ver carrito
                String[] botonesConf = {"Comprar", "Volver atrás"};

                int confirmar = JOptionPane.showOptionDialog(null, carrito.toString(), "Carrito", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                switch (confirmar) {
                    case 0 -> { //Comprar
                        boolean pagoHecho = p.pasarelaPagoB(carrito);
                        if (pagoHecho == true) {
                            Ticket t = new Ticket(carrito);
                            TPV.ventaHecha(t);
                            carrito.vaciarCarrito();
                        }
                        if (pagoHecho == false) {
                            String[] botonesCance = {"Cancelar", "Volver atrás"};

                            int cance = JOptionPane.showOptionDialog(null, "¿Quieres cancelar el pedido?", "Pedido",
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                            switch (cance) {
                                case 0 -> { //Cancelar la compra
                                    carrito.vaciarCarrito();

                                }

                                case 1 -> { //Seguir intentándolo
                                    
                                }
                            }
                        }
                    }

                    case 1 -> {//Volver atrás
                        
                    }
                }
            }

        }
    }
}
