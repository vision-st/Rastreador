package cl.duoc.rastreador.ui;

import cl.duoc.rastreador.model.Guerrero;
import cl.duoc.rastreador.model.Saiyajin;
import cl.duoc.rastreador.model.Terricola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase responsable de la interacción con el usuario y la visualización de datos.
 * Aplica SRP: Su única responsabilidad es manejar la interfaz de consola.
 */
public class MenuSistema {
    // APLICACIÓN DE DIP (Dependency Inversion Principle): Dependemos de la lista de la abstracción 'Guerrero', no de listas concretas.
    private List<Guerrero> sujetosDetectados;
    private Scanner scanner;

    public MenuSistema() {
        this.scanner = new Scanner(System.in);
        this.sujetosDetectados = new ArrayList<>();
        inicializarDatos();
    }

    /**
     * Simula la detección inicial de sujetos en el área.
     * APLICACIÓN DE POLIMORFISMO: Guardamos objetos de distintas subclases en una lista del tipo padre.
     */
    private void inicializarDatos() {
        // Usamos el constructor sobrecargado para Vegeta base
        sujetosDetectados.add(new Saiyajin("Vegeta (Explorador)", 18000));
        sujetosDetectados.add(new Saiyajin("Kakarotto", 9000, 1));
        sujetosDetectados.add(new Terricola("Granjero con escopeta", 5, true));
        sujetosDetectados.add(new Terricola("Mr. Satán", 10, false));
        sujetosDetectados.add(new Saiyajin("Broly (Peligro)", 50000, 2));
    }

    /**
     * Inicia el bucle principal del menú.
     */
    public void iniciar() {
        int opcion;
        do {
            mostrarEncabezado();
            ConsolaVerde.println("1. -> Identificar Raza");
            ConsolaVerde.println("2. -> Medir Poder de Pelea");
            ConsolaVerde.println("3. -> Información Completa (Análisis Profundo)");
            ConsolaVerde.println("0. -> Apagar Rastreador");
            ConsolaVerde.print("\nSELECCIONE OPCIÓN [Input]: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            procesarOpcion(opcion);

        } while (opcion != 0);
    }

    private void procesarOpcion(int opcion) {
        ConsolaVerde.println("\n[PROCESANDO SOLICITUD...]\n");
        switch (opcion) {
            case 1:
                mostrarInfoRazas();
                break;
            case 2:
                mostrarPoderesPelea();
                break;
            case 3:
                mostrarInfoCompletaDeepScan();
                break;
            case 0:
                ConsolaVerde.println("[APAGANDO SISTEMA...]");
                break;
            default:
                ConsolaVerde.println("¡ERROR! Opción inválida.");
        }
        if (opcion != 0) {
            ConsolaVerde.println("\n[PRESIONE ENTER PARA CONTINUAR]");
            scanner.nextLine();
        }
    }

    /**
     * Opción 1: Muestra solo la información racial.
     * APLICACIÓN DE POLIMORFISMO: Se llama al método obtenerInfoRaza() de cada objeto, y Java decide cuál ejecutar en tiempo real.
     */
    private void mostrarInfoRazas() {
        ConsolaVerde.println("--- REPORTE DE IDENTIFICACIÓN RACIAL ---");
        for (Guerrero g : sujetosDetectados) {
            ConsolaVerde.println("SUJETO: " + g.getNombre());
            ConsolaVerde.println(" > DETALLE: " + g.obtenerInfoRaza());
            ConsolaVerde.println("----------------------------------------");
        }
    }

    /**
     * Opción 2: Muestra el cálculo del poder.
     * APLICACIÓN DE POLIMORFISMO: Se llama al método sobrescrito calcularPoderDePelea().
     */
    private void mostrarPoderesPelea() {
        ConsolaVerde.println("--- REPORTE DE NIVELES DE PODER ---");
        for (Guerrero g : sujetosDetectados) {
            double poder = g.calcularPoderDePelea();
            ConsolaVerde.println("SUJETO: " + g.getNombre() + " | KI BASE: " + g.getKiBase());
            ConsolaVerde.println(" > PODER TOTAL CALCULADO: " + poder);
            if (poder > 8000) {
                System.out.println("¡¡¡ALERTA: ES DE MÁS DE 8000!!! (IT'S OVER 9000!)");
            }
            ConsolaVerde.println("----------------------------------------");
        }
    }

    /**
     * Opción 3: Muestra información detallada usando instanceof.
     * APLICACIÓN DE INSTANCEOF: Necesitamos acceder a datos específicos que no están en la clase padre Guerrero.
     */
    private void mostrarInfoCompletaDeepScan() {
        ConsolaVerde.println("--- ANÁLISIS DE ESTRUCTURA PROFUNDA (DEEP SCAN) ---");
        for (Guerrero g : sujetosDetectados) {
            ConsolaVerde.println(">> ESCANEANDO SUJETO: " + g.getNombre() + " <<");
            // Polimorfismo básico primero
            ConsolaVerde.println("Info General: " + g.obtenerInfoRaza());
            ConsolaVerde.println("Poder Estimado: " + g.calcularPoderDePelea());

            // Análisis específico con instanceof y Casting
            if (g instanceof Saiyajin) {
                Saiyajin s = (Saiyajin) g; // Downcasting seguro
                ConsolaVerde.println("[ANÁLISIS SAIYAJIN]:");
                ConsolaVerde.println(" - Nivel de transformación detectado: " + s.getNivelTransformacion());
                if (s.getNivelTransformacion() > 0) {
                    ConsolaVerde.println(" - ¡ADVERTENCIA! Sujeto en estado de combate aumentado.");
                }
            } else if (g instanceof Terricola) {
                Terricola t = (Terricola) g; // Downcasting seguro
                ConsolaVerde.println("[ANÁLISIS TERRÍCOLA]:");
                ConsolaVerde.println(" - ¿Posee armamento?: " + (t.isTieneArma() ? "SÍ (Escáner de metal positivo)" : "NO"));
            }
            ConsolaVerde.println("==========================================\n");
        }
    }

    private void mostrarEncabezado() {
        ConsolaVerde.println("\n==========================================");
        ConsolaVerde.println("   SISTEMA RASTREADOR V.7.0 - MENU PRINCIPAL");
        ConsolaVerde.println("==========================================");
    }
}