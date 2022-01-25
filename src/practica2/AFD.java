package practica2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class AFD implements Proceso,Cloneable{
    private String estadoInicial;
    private ArrayList<String> estadosFinales;
    private ArrayList<TransicionAFD> transiciones;
    
    /**
     * Inicializa las variables
     */
    public AFD(){
        transiciones=new ArrayList();
    }
    
    /**
     * Añade una nueva transición
     * @param e1 estadoInicial
     * @param simbolo simbolo
     * @param e2 estadoFinal
     */
    public void agregarTransicion(String e1,char simbolo,String e2){
        TransicionAFD f=new TransicionAFD(e1, simbolo, e2);
        transiciones.add(f);
    }
    
    /**
     * Método encargado de buscar y devolver el siguiente estado a través de un estado inicial y un símbolo ya dados
     * @param estado estadoInicial
     * @param simbolo 
     * @return estadoFinal o 'Error' si no encuentra la transición
     */
    public String transicion(String estado,char simbolo){
        boolean encontrado=false;
        String resultado="Error";
        int i =0;
        do{
            if(estado.equals(transiciones.get(i).getInicial())){
                if(simbolo==transiciones.get(i).getSimbolo()){
                    resultado=transiciones.get(i).getFin();
                    encontrado=true;
                }
            } i++; 
        }while(!encontrado && i<transiciones.size());
        return resultado;
    }
    
    /**
     * Método encargado de comprobar si el último estado es uno de los estados finales del autómata 
     * @param estado
     * @return true si lo encuentra, false si no lo hace
     */
    @Override
    public boolean esFinal(String estado){
        boolean encontrado=false;
        int i=0;
        do{
            if(estado.equals(estadosFinales.get(i))) encontrado=true;
            else i++;
        }while(!encontrado && i<estadosFinales.size());
        return encontrado;
    }
    
    /**
     * obtener transiciones
     * @return transiciones
     */
    public final ArrayList<TransicionAFD> getTransiciones(){
        return transiciones;
    }
    
    /**
     * A través de una cadena de carácteres o números comprueba si el autómata acepta o rechaza esa secuencia
     * @param cadena
     * @return true si el último estado pertenece a uno de los estados finales del autómata, de lo 
     * contrario devuelve false
     */
    @Override
    public boolean reconocer (String cadena){
        char[]simbolo=cadena.toCharArray();
        String estado=estadoInicial;
        for (int i = 0; i < simbolo.length; i++) {
            estado=transicion(estado,simbolo[i]);
        }
        return esFinal(estado);
    }
    
    /**
     * poner estado inicial
     * @param ini estadoInicial
     */
    public void setEstadoInicial(String ini){
        estadoInicial=ini;
    }
    
    /**
     * poner estado final
     * @param estados estadosFinales del autómata
     */
    public void setEstadosFinales(ArrayList<String> estados){
        estadosFinales=estados;
    }
    
    /**
     * obtener estado inicial
     * @return estadoInicial
     */
    public final String getEstadoIni(){
        return estadoInicial;
    }
    
    /**
     * obtener estado final
     * @return estadosFinales
     */
    public final ArrayList<String> getEstadosFinales(){
        return estadosFinales;
    }
    
    /**
     * Clona el objeto
     * @return objeto clonado
     */
    public Object Cloneable(){
        AFD obj=null;
        try{
            obj=(AFD)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("No se puede duplicar");
        }
        obj.estadosFinales=(ArrayList)this.estadosFinales.clone();
        obj.transiciones=(ArrayList)this.transiciones.clone();
        return obj;
    }
    
    /**
     * Método estático que lee el fichero pasado por parámetro y asigna el estado inicial, los estados finales
     * y las transiciones a las variables de la clase
     * @param archivo
     * @return objeto AFD
     */
    public static AFD pedir(String archivo){
        AFD a=new AFD();
        try{
            BufferedReader leer=new BufferedReader(new FileReader(archivo));
            String fila;
            boolean encontrado=false;
            while((fila=leer.readLine())!=null){
                if(!fila.equals("FIN")){
                    if(encontrado){
                        String [] separar=fila.split(" ");
                        a.agregarTransicion(separar[0].trim(), separar[1].trim().charAt(1), separar[2].trim());
                    }else{
                        String [] separar=fila.split(" ");
                        switch(separar[0].trim()){
                            case ("TRANSICIONES:"):
                                encontrado=true;
                                break;
                            case "INICIAL:":
                                a.setEstadoInicial(separar[1].trim());
                                break;
                            case ("FINALES:"):
                                ArrayList<String> estados=new ArrayList();
                                for (int i = 1; i < separar.length; i++) {
                                    estados.add(separar[i].trim());
                                }
                                a.setEstadosFinales(estados);
                                break;
                        }
                    }
                }
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("No se ha encontrado el fichero que pedía");
        }catch (IOException ex){
            System.out.println("No se pueden leer lineas correctamente");
        }
      return a;      
    }

    
}
