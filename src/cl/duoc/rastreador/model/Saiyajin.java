package cl.duoc.rastreador.model;

/**
 * Representa a un guerrero de la raza Saiyajin.
 * <p>
 * APLICACIÓN DE HERENCIA (Extends): Hereda atributos y métodos de Guerrero.
 */
public class Saiyajin extends Guerrero {
    private int nivelTransformacion; // 0=Base, 1=SSJ, etc.

    /**
     * Constructor principal para un Saiyajin.
     * @param nombre Nombre del guerrero.
     * @param kiBase Ki en estado normal.
     * @param nivelTransformacion Nivel de fase (0, 1, 2, 3).
     */
    public Saiyajin(String nombre, int kiBase, int nivelTransformacion) {
        super(nombre, kiBase);
        this.nivelTransformacion = nivelTransformacion;
    }

    /**
     * Constructor sobrecargado para crear un Saiyajin en estado base por defecto.
     * <p>
     * APLICACIÓN DE SOBRECARGA (Overloading): Mismo nombre de constructor, distintos parámetros.
     * @param nombre Nombre del guerrero.
     * @param kiBase Ki en estado normal.
     */
    public Saiyajin(String nombre, int kiBase) {
        super(nombre, kiBase);
        this.nivelTransformacion = 0; // Por defecto estado base
    }

    public int getNivelTransformacion() {
        return nivelTransformacion;
    }

    /**
     * Implementación específica del cálculo de poder para Saiyajines.
     * Multiplica el ki base brutalmente si está transformado.
     * <p>
     * APLICACIÓN DE SOBREESCRITURA (@Override): Redefine el comportamiento del método abstracto del padre.
     */
    @Override
    public double calcularPoderDePelea() {
        if (nivelTransformacion == 0) {
            return kiBase;
        } else {
            // Fórmula simple: KiBase * (50 veces el nivel de transformación)
            return kiBase * (50.0 * nivelTransformacion);
        }
    }

    @Override
    public String obtenerInfoRaza() {
        String estado = (nivelTransformacion == 0) ? "Estado Base" : "Super Saiyajin Fase " + nivelTransformacion;
        return "[RAZA: SAIYAJIN] - Clase guerrera con capacidad de transformación. Estado actual: " + estado;
    }
}