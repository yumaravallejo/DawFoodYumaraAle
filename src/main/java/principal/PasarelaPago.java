/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alejandro
 */
public class PasarelaPago {
 
    private ArrayList<TarjetaCredito> pasarela;
    
    //Constructor predeterminado
    public PasarelaPago() {
        this.pasarela = new ArrayList<>();
    }
    
    public void añadirTarj(TarjetaCredito tc) {
        pasarela.add(tc);
    }

    //Métodos de ordenación
    public void ordenarPorDigitos () {
        Collections.sort(pasarela,(c1,c2) -> Integer.compare(c1.getDigitos(), c2.getDigitos()));
    }
    
    public void ordenarPorCVV () {
        Collections.sort(pasarela,(c1,c2) -> Integer.compare(c1.getCVV(), c2.getCVV()));
    }
    
    public void ordenarPorFecha () {
        Collections.sort(pasarela, (c1,c2) -> (c1.getFechaCaduc().compareTo(c2.getFechaCaduc())));
    }
    
    //BinarySearch
    public int buscarElementoDig (TarjetaCredito t, int numeroBuscado){
        t.setDigitos(numeroBuscado);
        ordenarPorDigitos();
        return Collections.binarySearch(pasarela, t, (c1,c2) -> 
                Integer.compare(c1.getDigitos(), c2.getDigitos()));
    }
    
    public int buscarElementoCVV (TarjetaCredito t, int numeroBuscado){
        t.setCVV(numeroBuscado);
        ordenarPorCVV();
        return Collections.binarySearch(pasarela, t, (c1,c2) -> 
                Integer.compare(c1.getCVV(), c2.getCVV()));
    }
    
    public int buscarElementoFech (TarjetaCredito t, LocalDate fechaCad){
        t.setFechaCaduc(fechaCad);
        ordenarPorFecha();
        return Collections.binarySearch(pasarela, t, (c1,c2) -> 
                (c1.getFechaCaduc().compareTo(c2.getFechaCaduc())));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasarela de Pago: ").append(pasarela);
        return sb.toString();
    }
    
    
}
