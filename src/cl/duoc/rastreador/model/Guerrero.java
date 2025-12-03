package cl.duoc.rastreador.model;

/**
 * Clase abstracta que define el contrato base para cualquier entidad rastreable.
 * <p>
 * APLICACIÓN DE HERENCIA (Base): Esta es la superclase de la que heredarán las razas específicas.
 * APLICACIÓN DE ABSTRACCIÓN: Define métodos abstractos que obligan a las subclases a implementar comportamientos específicos.
 */
public abstract class Guerrero {
    protected String nombre;
    protected int kiBase;

    /**
     * Constructor base.
     * @param nombre Nombre del sujeto.
     * @param kiBase Nivel de ki en reposo detectado.
     */
    public Guerrero(String nombre, int kiBase) {
        this.nombre = nombre;
        this.kiBase = kiBase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getKiBase() {
        return kiBase;
    }

    /**
     * Calcula el poder de pelea real basado en las características de la raza.
     * @return El poder total calculado.
     * APLICACIÓN DE POLIMORFISMO: Este método será invocado de forma diferente según la instancia real del objeto.
     */
    public abstract double calcularPoderDePelea();

    /**
     * Devuelve una descripción textual de la raza y sus características generales.
     * @return String con información de la raza.
     */
    public abstract String obtenerInfoRaza();
}