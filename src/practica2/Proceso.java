package practica2;

/**
 *
 * @author Adrian
 */
public interface Proceso {
    public abstract boolean esFinal(String estado);
    public abstract boolean reconocer(String cadena);
    public abstract String toString();
}
