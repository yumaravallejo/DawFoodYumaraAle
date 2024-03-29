/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import static java.lang.Math.random;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 *
 * Una minúscula (a - z) Una mayúscula (A - Z) Un número (0 - 9) Uno de los
 * siguientes caracteres especiales: # $ % & ( ) * + , - . : ; < = > @
 *
 *
 * @author yumara
 */
public class TPV {

    private Random rd = new Random();
    private final UUID id;
    private String ubicacion;
    private LocalDateTime fechHorSis;
    private String contraAdmin;
    private ArrayList<Ticket> ventasCompletadas;
    private ArrayList<Productos> carrito;

    public TPV(String ubicacion) {
        this.id = UUID.randomUUID();
        this.ubicacion = ubicacion;
        this.fechHorSis = LocalDateTime.now();
        this.ventasCompletadas = new ArrayList<>();
        this.carrito = new ArrayList<>();
        this.contraAdmin = crearContraseña();
    }

    public void ventaHecha (Ticket t){
        this.ventasCompletadas.add(t);
    }
    public void ventasTotales (){
        for(int i=0; i<ventasCompletadas.size();i++){
            System.out.println(i+". ");
            System.out.println(ventasCompletadas.get(i));
        }
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public UUID getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public LocalDateTime getFechHorSis() {
        return fechHorSis;
    }

    public String getContraseña() {
        return this.contraAdmin;
    }

    public String crearContraseña() {
        boolean valido = true;
        String contra = "";
        do {
            try {
        char minusculas = (char) rd.nextInt(97, 123);
        char mayusculas = (char) rd.nextInt(65, 91);
        char numeros = (char) rd.nextInt(48, 57);
        char[] simbolos = {35, 36, 37, 38, 40, 41, 42, 43, 44, 45, 46, 58, 59, 60, 61, 62, 64};
        int simbolo5 = rd.nextInt(1, 5);
        int simbolo6 = rd.nextInt(1, 5);

        char[] contraseña = new char[6];

        contraseña[0] = minusculas;
        contraseña[1] = mayusculas;
        contraseña[2] = numeros;
        contraseña[3] = simbolos[rd.nextInt(0, 17)];
        switch (simbolo5) {
            case 1 -> {
                contraseña[4] = minusculas;
            }

            case 2 -> {
                contraseña[4] = mayusculas;
            }

            case 3 -> {
                contraseña[4] = numeros;
            }

            case 4 -> {
                contraseña[4] = simbolos[rd.nextInt(0, 17)];
            }
        }

        switch (simbolo6) {
            case 1 -> {
                contraseña[5] = minusculas;
            }

            case 2 -> {
                contraseña[5] = mayusculas;
            }

            case 3 -> {
                contraseña[5] = numeros;
            }

            case 4 -> {
                contraseña[6] = simbolos[rd.nextInt(0, 17)];
            }
        }
        contra = new String(contraseña);
        valido = true;
            } catch (IndexOutOfBoundsException ioobe) {
                valido = false;
            }
            
        } while (!valido);
        return contra;
    }

    public String getContraAdmin() {
        return contraAdmin;
    }


    public ArrayList<Ticket> getVentasCompletadas() {
        return ventasCompletadas;
    }

    public void setVentasCompletadas(ArrayList<Ticket> ventasCompletadas) {
        this.ventasCompletadas = ventasCompletadas;
    }

    public ArrayList<Productos> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Productos> carrito) {
        this.carrito = carrito;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV: ");
        sb.append("id= ").append(id);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", fechHorSis=").append(fechHorSis);
        sb.append(", contraAdmin=").append(contraAdmin);
        sb.append(", ventasCompletadas= ").append(ventasCompletadas.size());
        sb.append('}');
        return sb.toString();
    }

}
