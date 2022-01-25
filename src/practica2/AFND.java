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
public class AFND implements Proceso, Cloneable {

    private ArrayList<String> estadosFinales;
    private String estadoInicial;
    private  ArrayList<TransicionAFND> transiciones;
    private  ArrayList<TransicionLambda> transicionesλ;

    /**
     * Inicializa las variables
     */
    public AFND() {
        transiciones = new ArrayList();
        transicionesλ = new ArrayList();
    }

    /**
     * Añade una nueva transición
     * @param e1 estadoInicial
     * @param simbolo simbolo
     * @param e2 estadoFinal
     */
    public void agregarTransicion(String e1, char simbolo, String e2) {
        TransicionAFND f = new TransicionAFND(e1, simbolo, e2);
        transiciones.add(f);
    }

    /**
     * Agrega una nueva transiciónλ 
     * @param e1 estadoInicial
     * @param e2 estadoFinal
     */
    public void agregarTransicionλ(String e1, String e2) {
        TransicionLambda f = new TransicionLambda(e1, e2);
        transicionesλ.add(f);
    }


    /**
     * Dado un ArrayList de estados actuales y un símbolo devuelve un ArrayList con los estados finales mirando 
     * las transciones de los estados actuales, también guarda en el resultado las transicionesλ que se generan
     * al obtener los estados finales, devuelve null si no encuentra ninguna transicion
     * @param macroestado ArrayList de estados actuales
     * @param simbolo
     * @return ArrayList de estados finales
     */
    public ArrayList<String> transicion(ArrayList<String> macroestado, char simbolo) {
        ArrayList<String> resul=new ArrayList<>();
        for (String macroestado1 : macroestado) {
            int i=0;
            do{
                if(macroestado1.equals(transiciones.get(i).getInicial()))
                    if(simbolo==transiciones.get(i).getSimbolo()){
                        unirArray(resul, transiciones.get(i).getFin());
                    }
                i++;
            }while(i<transiciones.size());
        }
        unirArray(resul,λ_clausura(resul));
        if(resul.isEmpty())
            return null;
        else
            return resul;
       
    }
    
    private ArrayList<String> λ_clausura(ArrayList<String> macroestado) {
        ArrayList<String> resul=new ArrayList<>();
        for (String macroestado1 : macroestado) {
            for (TransicionLambda tran : transicionesλ) {
                if(tran.getInicial().equals(macroestado1)){
                        unirArray(resul, tran.getFin());
                        unirArray(resul, transicionλ(tran.getFin()));
                }
            }                    
        }
        return resul;
    }
    

    private ArrayList<String> transicionλ(String estado) {
        ArrayList<String> resul=new ArrayList<>();
        for (TransicionLambda tran : transicionesλ) {
            if(tran.getInicial().equals(estado)){
                resul.add(tran.getFin());
                unirArray(resul, transicionλ(tran.getFin()));
            }
        }
        return  resul;
    }

    /**
     * Comprueba si el estado pasado por parámetro es una de los estados finales del autómata
     * @param estado
     * @return true si coincide con algún estado final, si no es así devuelve false
     */
    @Override
    public boolean esFinal(String estado) {
        int i = 0;
        boolean encontrado = false;
        do {
            if (estadosFinales.get(i).equals(estado)) {
                encontrado = true;
            } else {
                i++;
            }
        } while (i < estadosFinales.size() && !encontrado);
        return encontrado;
    }

    /**
     * Comprueba si alguno de los estados del ArrayList pasado por parámetro coincide con alguan de los estados finales
     * del autómata
     * @param macroestado
     * @return true si al menos 1 de ellos coincide, false si no coincide con ninguno
     */
    public boolean esFinal(ArrayList<String> macroestado) {
        int i = 0;
        boolean encontrado = false;
        do {
            if (esFinal(macroestado.get(i))) {
                encontrado = true;
            } else {
                i++;
            }
        } while (i < macroestado.size() && !encontrado);
        return encontrado;
    }

    

    /**
     * Dada una cadena de caráceteres o números comprueba si alguno de los estados últimos estados hallados coincide
     * con alguno de los estados finales
     * @param cadena
     * @return true si al menos 1 de ellos coincide, false de lo contrario
     */
    @Override
    public boolean reconocer(String cadena) {
        char [] simbolo=cadena.toCharArray();
        ArrayList<String> macroestado=new ArrayList<>();
        macroestado.add(estadoInicial);
        unirArray(macroestado,λ_clausura(macroestado));
        for (int i = 0; i < simbolo.length; i++) {
            macroestado=transicion(macroestado,simbolo[i]);
        }
        return esFinal(macroestado);

    }

    /**
     * Pones los estados finales
     * @param estados 
     */
    public void setEstadosFinales(ArrayList<String> estados) {
        estadosFinales = estados;
    }

    /**
     * pones los estados iniciales
     * @param estado 
     */
    public void setEstadoInicial(String estado) {
        estadoInicial = estado;
    }
    /**
     * 
     * @param destino
     * @param aux 
     */
    private void unirArray(ArrayList<String> destino, ArrayList<String> aux){
        for (int i = 0; i < aux.size(); i++)
            unirArray(destino, aux.get(i));
    }
    
    /**
     * 
     * @param destino
     * @param aux 
     */
    private void unirArray(ArrayList<String> destino, String aux){
        boolean encontrado=false; 
        int i=0;
        if(destino.isEmpty())
            destino.add(aux);
        else{
            do{
                if(destino.get(i).equals(aux))
                    encontrado=true;
                else
                    i++;
            }while(i<destino.size() && !encontrado);
            if(!encontrado)
                destino.add(aux);
        }
    }
    
    /**
     * Obtengo los estados iniciales
     * @return
     */
    public ArrayList<String> getEstadosIniciales(){
        ArrayList<String> resul=new ArrayList<>();
        resul.add(estadoInicial);
        unirArray(resul, λ_clausura(resul));
        return resul;
    }
    /**
     * Obtengo los estados iniciales
     * @return 
     */
    public String getEstadoIni(){
        return estadoInicial;
    }
    
    /**
     * Obtengo las transiciones
     * @return
     */
    public ArrayList<TransicionAFND> getTransiciones(){
        return transiciones;
    }
    
    /**
     * Obtengo las trnasiciones de landa
     * @return
     */
    public ArrayList<TransicionLambda> getTransicionesλ(){
        return transicionesλ;
    }
    
    /**
     * Obtengo los estados finales
     * @return 
     */
    public ArrayList<String> getEstadosFinales(){
        return estadosFinales;
    }
    
    public Object Cloneable(){
        AFND obj=null;
        try{
            obj=(AFND)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("No se puede duplicar");
        }
        obj.estadosFinales=(ArrayList)this.estadosFinales.clone();
        obj.transiciones=(ArrayList)this.transiciones.clone();
        obj.transicionesλ=(ArrayList)this.transicionesλ.clone();
        return obj;
    }

    /**
     *
     * @param archivo
     * @return
     */
    public static AFND pedir(String archivo) {
        AFND a = new AFND();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String fila;
            boolean encontrado = false, encontrado2 = false;
            while ((fila = leer.readLine()) != null) {
                if (!fila.equals("FIN")) {
                    if (encontrado) {
                        if (encontrado2) {
                            String[] separar = fila.split(" ");
                            a.agregarTransicionλ(separar[0].trim(), separar[1].trim());
                        } else {
                            if (fila.trim().equals("TRANSICIONESλ:")) {
                                encontrado2 = true;
                            } else {
                                String[] separar = fila.split(" ");
                                a.agregarTransicion(separar[0].trim(), separar[1].trim().charAt(1), separar[2].trim());
                            }
                        }
                    } else {
                        String[] separar = fila.split(" ");
                        switch (separar[0].trim()) {
                            case ("TRANSICIONES:"):
                                encontrado = true;
                                break;
                            case "INICIAL:":
                                a.setEstadoInicial(separar[1].trim());
                                break;
                            case ("FINALES:"):
                                ArrayList<String> estados = new ArrayList();
                                for (int i = 1; i < separar.length; i++) {
                                    estados.add(separar[i].trim());
                                }
                                a.setEstadosFinales(estados);
                                break;
                        }
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el fichero que pedía");
        } catch (IOException ex) {
            System.out.println("No se pueden leer lineas correctamente");
        }
        return a;
    }

}
