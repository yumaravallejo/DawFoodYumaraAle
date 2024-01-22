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
 * @author yumara
 */
public class TPV {
    
    private Random rd = new Random();
    private final UUID id;
    private String ubicacion;
    private LocalDateTime fechHorSis;
    private String contraAdmin;
    private int ventasCompletadas;
    private ArrayList<Productos> carrito;

    public TPV(String ubicacion) {
        this.id = UUID.randomUUID();
        this.ubicacion = ubicacion;
        this.fechHorSis = LocalDateTime.now();
        this.ventasCompletadas = 0;
        this.contraAdmin = ;
        this.carrito = new ArrayList<>();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("id=").append(id);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", fechHorSis=").append(fechHorSis);
        sb.append('}');
        return sb.toString();
    }
}
