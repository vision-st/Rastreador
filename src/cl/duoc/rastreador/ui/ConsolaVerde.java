package cl.duoc.rastreador.ui;

/**
 * Clase utilitaria para manejar los códigos de color ANSI en la consola.
 * Simula la estética de un rastreador antiguo.
 */
public class ConsolaVerde {
    // Códigos de escape ANSI para colores
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Imprime un mensaje en la consola en color verde y luego resetea el color.
     * @param mensaje El texto a imprimir.
     */
    public static void println(String mensaje) {
        System.out.println(ANSI_GREEN + mensaje + ANSI_RESET);
    }

    /**
     * Imprime un mensaje sin salto de línea en color verde.
     * @param mensaje El texto a imprimir.
     */
    public static void print(String mensaje) {
        System.out.print(ANSI_GREEN + mensaje + ANSI_RESET);
    }
}