package practica2;

/**
 *
 * @author Adrian
 */
public class TransicionAFND {
    private String inicial, fin;
    private char simbolo;
    
    /**
     * Inicializa las variables
     * @param e1 estadoInicial
     * @param simbolo simbolo
     * @param e2 estadoFinal
     */
    public TransicionAFND(String e1,char simbolo,String e2){
        inicial=e1;
        fin=e2;
        this.simbolo=simbolo;
    }
    
    /**
     * poner final
     * @param fin estadoFinal
     */
    public void setFin(String fin){
        this.fin=fin;
    }
    
    /**
     * poner inicial
     * @param ini estadoInicial
     */
    public void setInicial(String ini){
        inicial=ini;
    }
    
    /**
     * poner simbolo
     * @param sim Simbolo
     */
    public void setSimbolo(char sim){
        simbolo=sim;
    }
    
    /**
     * obtener final
     * @return estadoFinal
     */
    public final String getFin(){
        return fin;
    }
    
    /**
     * obtener inicial
     * @return estadoInicial
     */
    public final String getInicial(){
        return inicial;
    }
    
    /**
     * obtener simbolo
     * @return Simbolo
     */
    public final char getSimbolo(){
        return simbolo;
    }
}
