
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
        String[] botones = {" Modo Usuario", " Modo Administrador", "Salir"};

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

        PasarelaPago p = new PasarelaPago();
        p.rellenarTarjetas();

        // Variable que sirve para comprobar si repetir o no el programa ( Apagar el
        // TPV o no)
        boolean repeticion = false;

        // do-while para controlar cuando salir o no del TPV
        do {
            // Switch para controlar las distintas opciones de inicio del TPV.
            // El método menúInicial nos dará un tipo int con la opción elegida
            switch (menuInicial()) {

                case 0 -> { //Modo Usuario
                    boolean modoUser = usuario(TPV, catalogo, carrito, p);
                    repeticion = modoUser;
                }

                case 1 -> { //Modo Administrador
                   
                    repeticion = true;
                }

                case 2 -> { //Salir
                    repeticion = false;
                }
            }

        } while (repeticion);
    }

    public static boolean usuario(TPV TPV, Catalogo c, Carrito carrito, PasarelaPago p) {

        boolean menuPrincipal = false;

// Menú Principal ---------------------------------------------------------------------------------------------------------------------
        do {
            menuPrincipal = false;
            String[] botones = {"Ver Comida", "Ver Bebidas", "Ver Postres", "Ver Carrito", "Volver"};

            int eleccion = JOptionPane.showOptionDialog(null,
                    " ¿Qué quieres ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

            switch (eleccion) {

// Comida -----------------------------------------------------------------------------------------------------------------------------
                case 0 -> { //Ver Comidas
                    boolean menuComidas = false;
                    do {
                        String[] botonesC = {"Carnes", "Pastas", "Mariscos", "Volver"};

                        int eleccionComida = JOptionPane.showOptionDialog(null,
                                " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesC, botonesC[0]);
                        switch (eleccionComida) {

                            case 0 -> { //Ver Carnes
                                menuComidas = false;
                                boolean menuCarne = false;

                                do {
                                    String[] botonesMar = {"Hamburguesa", "Entrecot", "Solomillo", "Volver"};

                                    int opcion = JOptionPane.showOptionDialog(null,
                                            " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesMar, botonesMar[0]);
                                    switch (opcion) {

                                        case 0 -> {
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(0).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuCarne = false; //Para no volver al menú de carne
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuCarne = true; //Para que vuelva al menu de Comidas
                                                    menuPrincipal = false; //Para que no vuelva al menú principal
                                                }
                                            }
                                        }

                                        case 1 -> {
                                            menuPrincipal = false; //Para no volver al menú principal
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(1).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuCarne = false; //Para no volver al menú de carne
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuCarne = true; //Para volver al menú de carne
                                                }
                                            }
                                        }

                                        case 2 -> { //Solomillo
                                            menuPrincipal = false; //Para no volver al menú principal
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(13).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> { //Añadimos la cantidad que queramos
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuCarne = true; //Para volver al menú de carne
                                                }
                                            }
                                        }

                                        case 3 -> {
                                            menuPrincipal = true; //Para volver al menú principal
                                            menuCarne = false; //Para no volver al menú de carne
                                        }
                                    }
                                } while (menuCarne);
                            }

                            case 1 -> { //Ver Pastas 
                                menuComidas = false;
                                boolean menuPasta = false;

                                do {
                                    String[] botonesMar = {"Pasta Carbonara", "Lasaña", "Pasta al pesto", "Volver"};

                                    int opcion = JOptionPane.showOptionDialog(null,
                                            " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesMar, botonesMar[0]);
                                    switch (opcion) {
                                        case 0 -> {
                                            menuPrincipal = false; //Para que no vuelva al menú principal
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(2).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuPasta = false; //Para que vuelva al menú de pasta
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPasta = true; //Para que vuelva al menú de pasta

                                                }
                                            }
                                        }

                                        case 1 -> {
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(15).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuPasta = false; //Para que no vuelva al menú de pasta
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPasta = true; //Para que vuelva al menú de pasta
                                                }
                                            }
                                        }

                                        case 2 -> {
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(16).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuPasta = false; //Para que no vuelva al menú de pasta
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPasta = true; //Para que vuelva al menú de pasta
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            menuPasta = false; //Para que no vuelva al menú de pasta
                                            menuPrincipal = true; //Para que vuelva al menú principal
                                        }
                                    }
                                } while (menuPasta);
                            }

                            case 2 -> { //Ver Mariscos
                                menuComidas = false;
                                boolean menuMariscos = false;
                                menuPrincipal = false; //Para que no vuelva al menú
                                do {
                                    String[] botonesMar = {"Gambas al pil-pil", "Ostras", "Almejas finas", "Volver"};

                                    int opcion = JOptionPane.showOptionDialog(null,
                                            " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesMar, botonesMar[0]);
                                    switch (opcion) {
                                        case 0 -> {
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(3).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuMariscos = false; //Para que no vuelva al menu de mariscos
                                                    menuComidas = false; //Para que no vuelva al menu de Comidas

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
                                                    menuPrincipal = true;
                                                }

                                                case 1 -> {
                                                    menuMariscos = true; //Para que vuelva al menu de mariscos
                                                }
                                            }
                                        }

                                        case 1 -> {
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(17).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuMariscos = false; //Para que no vuelva al menu de mariscos
                                                    menuComidas = false; //Para que no vuelva al menu de Comidas

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
                                                    menuPrincipal = true;
                                                }

                                                case 1 -> {
                                                    menuMariscos = true; //Para que vuelva al menu de mariscos
                                                    menuComidas = false; //Para que vuelva al menu de Comidas
                                                }
                                            }
                                        }

                                        case 2 -> {
                                            String[] botonesConf = {"Añadir", "Cancelar"};

                                            int confirmar = JOptionPane.showOptionDialog(null, c.obtener(18).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                            switch (confirmar) {
                                                case 0 -> {
                                                    menuMariscos = false; //Para que no vuelva al menu de mariscos
                                                    menuComidas = false; //Para que no vuelva al menu de Comidas

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
                                                    menuPrincipal = true; //Para ir al menú principal tras pedir
                                                }

                                                case 1 -> {
                                                    menuMariscos = true; //Para que vuelva al menu de mariscos
                                                    menuComidas = false; //Para que vuelva al menu de Comidas
                                                }

                                            }

                                        }

                                        case 3 -> {
                                            menuComidas = true; //Para que vuelva al menu de Comidas
                                            menuPrincipal = false; //Para que no vuelva al menú principal
                                        }
                                    }
                                } while (menuMariscos);
                            }

                            case 3 -> {
                                menuComidas = false; //Para que vuelva al menu de Comidas
                                menuPrincipal = true; //Para que no vuelva al menú principal
                            }

                        }

                    } while (menuComidas);
                }

// Bebida ------------------------------------------------------------------------------------------------------------------------------
                case 1 -> { //Ver bebidas
                    boolean menuBebidas = false;
                    do {
                        String[] botonesC = {"Refrescos", "Zumos", "Bebidas Alcohólicas", "Volver"};

                        int eleccionBeb = JOptionPane.showOptionDialog(null,
                                " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesC, botonesC[0]);
                        switch (eleccionBeb) {
                            case 0 -> { //Ver Refrescos
                                menuBebidas = false;
                                boolean menuRefrescos = false;
                                do {
                                    menuPrincipal = false; //Para que no vuelva al menú
                                    String[] botonesBeb = {"Coca-Cola", "Fanta Naranja", "Fanta Limón", "Volver"};

                                    int eleccionBebida = JOptionPane.showOptionDialog(null,
                                            " ¿Qué quieres ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesBeb, botonesBeb[0]);

                                    switch (eleccionBebida) {
                                        case 0 -> {
                                            menuBebidas = false; //Para que no vuelva a elegir bebida
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
                                                    menuPrincipal = true; //Para  volver al menú principal                                               
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuRefrescos = true; //Para volver al menú de bebidas
                                                }
                                            }
                                        }
                                        case 1 -> {
                                            menuBebidas = false; //Para que no vuelva a elegir bebida
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
                                                    menuPrincipal = true; //Para no volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuRefrescos = true; //Para volver al menú de bebidas
                                                }
                                            }
                                        }
                                        case 2 -> {
                                            menuBebidas = false; //Para que no vuelva a elegir bebida
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuRefrescos = true; //Para volver al menú de bebidas
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            menuPrincipal = false; //Para no volver al menú principal
                                            menuBebidas = true; //Para volver al menú de bebidas
                                        }

                                    }
                                } while (menuRefrescos);
                            }

                            case 1 -> { //Ver Zumos 
                                menuBebidas = false;
                                boolean menuZumos = false;
                                do {
                                    menuPrincipal = false; //Para que no vuelva al menú
                                    String[] botonesBeb = {"Manzana", "Naranja", "Piña", "Volver"};

                                    int eleccionBebida = JOptionPane.showOptionDialog(null,
                                            " ¿Qué quieres ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesBeb, botonesBeb[0]);

                                    switch (eleccionBebida) {
                                        case 0 -> {
                                            menuBebidas = false; //Para que no vuelva al menú de bebidas
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuZumos = true; //Para volver al menú de zumos
                                                }
                                            }
                                        }
                                        case 1 -> {
                                            menuBebidas = false; //Para que no vuelva al menú de bebidas
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuZumos = true; //Para volver al menú de zumos
                                                }
                                            }
                                        }
                                        case 2 -> {
                                            menuBebidas = false; //Para que no vuelva al menú de bebidas
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuZumos = true; //Para volver al menú de zumos
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            menuPrincipal = false; //Para no volver al menú principal
                                            menuBebidas = true; //Para volver al menú de bebidas
                                        }
                                    }
                                } while (menuZumos);
                            }

                            case 2 -> { //Ver Alcohol
                                menuBebidas = false;
                                boolean menuAlcohol = false;
                                do {
                                    menuPrincipal = false; //Para que no vuelva al menú
                                    String[] botonesBeb = {"Cerveza", "Vinto Tinto", "Vino Blanco", "Volver"};

                                    int eleccionBebida = JOptionPane.showOptionDialog(null,
                                            " ¿Qué quieres ver?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesBeb, botonesBeb[0]);

                                    switch (eleccionBebida) {
                                        case 0 -> {
                                            menuBebidas = false; //Para que no vuelva al menú de bebidas
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para no volver al menú principal
                                                    menuAlcohol = true; //Para volver al menú de alcohol
                                                }
                                            }
                                        }

                                        case 1 -> {
                                            menuBebidas = false; //Para que no vuelva al menú de bebidas
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para volver al menú principal
                                                    menuAlcohol = true; //Para volver al menú de alcohol
                                                }
                                            }
                                        }

                                        case 2 -> {
                                            menuBebidas = false; //Para que no vuelva al menú de bebidas
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
                                                    menuPrincipal = true; //Para volver al menú principal
                                                }

                                                case 1 -> {
                                                    menuPrincipal = false; //Para volver al menú principal
                                                    menuAlcohol = true; //Para volver al menú de alcohol
                                                }
                                            }
                                        }

                                        case 3 -> {
                                            menuPrincipal = false; //Para no volver al menú principal
                                            menuBebidas = true; //Para volver al menú de bebidas
                                        }
                                    }
                                } while (menuAlcohol);
                            }

                            case 3 -> {
                                menuBebidas = false; //Para no volver al menú de bebidas
                                menuPrincipal = true; //Para volver al menú principal
                            }
                        }
                    } while (menuBebidas);
                }
// Postre ------------------------------------------------------------------------------------------------------------------------------

                case 2 -> { //Ver postres
                    boolean menuPostres = false;
                    do {

                        String[] botonesCar = {"Crepes", "Tarta de queso", "Flan", "Volver"};

                        int opcion = JOptionPane.showOptionDialog(null,
                                " ¿Qué quieres pedir?", "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesCar, botonesCar[0]);

                        switch (opcion) {
                            case 0 -> {
                                menuPostres = false;
                                menuPrincipal = false; //Para que no vuelva al menú
                                String[] botonesConf = {"Añadir", "Cancelar"};

                                int confirmar = JOptionPane.showOptionDialog(null, c.obtener(19).toString(), "Catálogo",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                switch (confirmar) {
                                    case 0 -> {
                                        menuPostres = false; //Para que no vuelva atrás
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
                                        menuPrincipal = true; //Para volver al menú principal
                                    }

                                    case 1 -> {
                                        menuPostres = true; //Para que vuelva atrás
                                        menuPrincipal = false; //Para no volver al menú principal
                                    }
                                }
                            }

                            case 1 -> {
                                menuPostres = false;
                                menuPrincipal = false; //Para que no vuelva al menú
                                String[] botonesConf = {"Añadir", "Cancelar"};

                                int confirmar = JOptionPane.showOptionDialog(null, c.obtener(20).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                switch (confirmar) {
                                    case 0 -> {
                                        menuPostres = false;//Para que no vuelva atrás
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
                                        menuPrincipal = true; //Para volver al menú principal
                                    }

                                    case 1 -> {
                                        menuPrincipal = false; //Para no volver al menú principal
                                        menuPostres = true;//Para que vuelva atrás
                                    }
                                }
                            }
                            case 2 -> {
                                menuPostres = false;
                                menuPrincipal = false; //Para que no vuelva al menú
                                String[] botonesConf = {"Añadir", "Cancelar"};

                                int confirmar = JOptionPane.showOptionDialog(null, c.obtener(21).toString(), "Catálogo", JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                switch (confirmar) {
                                    case 0 -> {
                                        menuPostres = false;//Para que no vuelva atrás
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
                                        menuPrincipal = true; //Para volver al menú principal
                                    }

                                    case 1 -> {
                                        menuPostres = true;//Para que vuelva atrás
                                        menuPrincipal = false;
                                    }
                                }
                            }
                            case 3 -> {
                                menuPostres = false; //Para que no vuelva atrás (menú de postres)
                                menuPrincipal = true; //Para que vuelva al menú
                            }
                        }
                    } while (menuPostres);
                }
// Carrito ------------------------------------------------------------------------------------------------------------------------------

                case 3 -> { //Ver carrito
                    String[] botonesConf = {"Comprar", "Volver atrás"};

                    int confirmar = JOptionPane.showOptionDialog(null, carrito.toString(), "Carrito", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                    switch (confirmar) {
                        case 0 -> { //Comprar
                            menuPrincipal = false; //Para que no vuelva al menú

                            //Pasarela de pago es el método que nos comprobará los datos de la tarjeta y el saldo, 
                            // dará true o false dependiendo si se completa o no el pago
                            boolean pagoHecho = p.pasarelaPagoB(carrito);

                            //Si el pago se ha realizado correctamente
                            if (pagoHecho == true) {
                                Ticket t = new Ticket(carrito);
                                TPV.ventaHecha(t);
                                System.out.println("Venta añadida a la TPV " + TPV.getVentasCompletadas());
                                carrito.vaciarCarrito();
                            }

                            //Si el pago no se ha realizado correctamente
                            if (pagoHecho == false) {
                                String[] botonesCance = {"Cancelar y salir", "Seguir con la compra"};

                                int cance = JOptionPane.showOptionDialog(null, "Ha habido un fallo en el pago \n ¿Quieres cancelar el pedido?", "Pedido",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesConf, botonesConf[0]);

                                switch (cance) {
                                    case 0 -> { //Cancelar la compra
                                        carrito.vaciarCarrito();

                                    }

                                    case 1 -> { //Seguir intentándolo
                                        menuPrincipal = true;
                                    }
                                }
                            }
                        }

                        case 1 -> {//Volver atrás
                            menuPrincipal = true; //Para que vuelva al menú
                        }
                    }
                }

                case 4 -> {
                    return true;
                }
            }

        } while (menuPrincipal);
        return true;
    }
}
