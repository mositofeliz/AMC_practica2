package practica2;

/**
 *
 * @author Adrian
 */
public class TransicionLambda {
    private String inicial;
    private String fin;
    
    /**
     * Inicializa las variables
     * @param e1 estadoInicial
     * @param e2 estadoFinal
     */
    public TransicionLambda(String e1,String e2){
        inicial=e1;
        fin=e2;
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
     * obtener final
     * @return estadoFinal
     */
    public final  String getFin(){
        return fin;
    }
    
    /**
     * obtener inicial
     * @return estadoInicial
     */
    public final String getInicial(){
        return inicial;
    }
    
}
