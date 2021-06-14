package Unidad4_ejercicio2;

public class NodoHijo {
    NodoGeneral direccionHijo;
    NodoHijo ant, sig;
    
    public NodoHijo(NodoGeneral HijoApuntar){
        direccionHijo = HijoApuntar;
        ant = sig = null;
    }
}
