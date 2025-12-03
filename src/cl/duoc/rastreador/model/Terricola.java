package cl.duoc.rastreador.model;

/**
 * Representa a un habitante del planeta Tierra.
 */
public class Terricola extends Guerrero {
    private boolean tieneArma;

    /**
     * Constructor de Terrícola.
     * @param nombre Nombre del sujeto.
     * @param kiBase Ki detectado.
     * @param tieneArma Indica si porta armamento tecnológico.
     */
    public Terricola(String nombre, int kiBase, boolean tieneArma) {
        super(nombre, kiBase);
        this.tieneArma = tieneArma;
    }

    public boolean isTieneArma() {
        return tieneArma;
    }

    /**
     * Implementación específica para Terrícolas.
     * Su poder aumenta ligeramente si tienen armas.
     * <p>
     * APLICACIÓN DE SOBREESCRITURA (@Override).
     */
    @Override
    public double calcularPoderDePelea() {
        if (tieneArma) {
            return kiBase * 1.5; // Bonus del 50% por armas
        }
        return kiBase;
    }

    @Override
    public String obtenerInfoRaza() {
        String armamento = tieneArma ? "Sujeto Armado (Peligro Variable)" : "Sin Armas (Inofensivo)";
        return "[RAZA: TERRÍCOLA] - Habitante promedio de bajo Ki. Estado: " + armamento;
    }
}