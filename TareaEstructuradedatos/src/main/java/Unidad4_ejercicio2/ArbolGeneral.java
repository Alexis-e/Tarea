package Unidad4_ejercicio2;

public class ArbolGeneral {
    NodoGeneral raiz;
    NodoGeneral padreV;
    int count;
    
    public ArbolGeneral(){
        raiz = null;
        count = 0;
    }
    public boolean insertar(char dato,String path){
        
        if(raiz == null){
            raiz = new NodoGeneral(dato);
            if(raiz == null) return false;
            return true;
        }
        if (path.isEmpty()) return false;
        
        NodoGeneral padre = buscarNodo(path);
        if(padre == null) return false;
        
        NodoGeneral hijoYaExiste = buscarNodo(path+"/"+dato);
        
        if(hijoYaExiste !=null) return false;
        
        NodoGeneral nuevo = new NodoGeneral(dato);
        return padre.enlazar(nuevo);
    }

    private NodoGeneral buscarNodo(String path) {
        path = path.substring(1);
        String vector[] = path.split("/");
        
        if(vector[0].charAt(0) == raiz.dato ){
            if(vector.length == 1) return raiz;
            NodoGeneral padre = raiz;
            
            for(int i = 1; i < vector.length; i++){
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre == null) return null;
            }
            return padre;
        }
        return null;
    }
    
    public boolean eliminar(String path){
        if(raiz == null) return false;
        
        NodoGeneral hijo = buscarNodo(path);
        if(hijo == null)return false; 
        
        if(!hijo.esHoja()) return false;
        
        if(hijo == raiz){
            raiz = null;
            return true;
        }
        
        String pathPadre = obtenerPathPadre(path);
        NodoGeneral padre = buscarNodo(path);
        
        return padre.desenlazar(hijo);
    }

    private String obtenerPathPadre(String path) {
        int posicionUltimaDiagonal = path.lastIndexOf("/")-1;
        return path.substring(0, posicionUltimaDiagonal);
    }
    
    public boolean comprobarCamino(ArbolGeneral arbol, String[] vector, int longitud){
        int count2 = 0;
        if(count2 == 0){
            this.padreV = this.raiz;
            count2++;
        }
        
        if(this.padreV == null){
            return false;
        }
        
        String[] vector2;
        
        if(arbol.padreV.esHoja() == false){       
            if(arbol.padreV.obtenerHijo(vector[1].charAt(0)) != null){
                arbol.padreV = arbol.padreV.obtenerHijo(vector[1].charAt(0));

                vector2 = new String[vector.length -1];

                for(int i = 1; i < vector.length; i++){
                    vector2[i] = vector[i];
                }

                comprobarCamino(arbol,vector2,longitud);
            }else{
                return false;
            }
        }    
        
        return true;
    }
}
