package Unidad4_ejercicio2;

public class NodoGeneral {
    char dato;
    NodoHijo ini, fin;
    
    public NodoGeneral(char v){
        dato = v;
        ini = fin = null;
    }
    
    public boolean enlazar(NodoGeneral hijo){
        /////el codigo es el mismo que en lista doble
        NodoHijo enlace = new NodoHijo(hijo);
        if(enlace == null) return false;
        
        if(ini == null && fin == null){
            ini= fin = enlace;
            return true;
        }
        
        fin.sig = enlace;
        enlace.ant = fin;
        fin = enlace;
        return true;
        // PENDIENTE la construccion del codigo que enlaza al padre con el hijo
        // y que es identico a un insertar de lista doble, pero sin el valor, usando mas bien una direccion
    }
    public boolean esHoja(){
        return ini == null && fin == null;
    }
    
    
    public NodoGeneral obtenerHijo(char valorHijoBuscado){
        //pendiente
        if(esHoja())return null;
        
        for(NodoHijo buscar  = ini; buscar != null; buscar = buscar.sig){
            if(buscar.direccionHijo.dato == valorHijoBuscado) return buscar.direccionHijo;
        }
        return null;
    }

    public boolean desenlazar(NodoGeneral hijo) {
        //////////////////////el desenlazar es casi el mismo que el eliminar un dato por busqueda en lista doble
       if(ini==fin){
           if(fin.direccionHijo == hijo){
               ini = fin = null;
               return true;
           }
           return false;
       }
        NodoHijo temp = ini;
        if(temp.direccionHijo == hijo){
            ini= temp.sig;
            ini.ant = temp.sig = temp = null;
            return true;
            
        }
        if(fin.direccionHijo == hijo){
            temp = fin;
            fin = temp.ant;
            fin.sig = temp.ant = temp = null;
            return true;
        }
        temp = temp.sig;
        while(temp.direccionHijo != hijo && temp != null){
            temp = temp.sig;
        }
        if (temp == null)return false;
        temp.sig.ant = temp.ant;
        temp.ant.sig = temp.sig;
        temp.sig = temp.ant = temp = null;
        return true;
    }
}
