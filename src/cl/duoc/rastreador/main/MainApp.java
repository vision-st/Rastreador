package cl.duoc.rastreador.main;

import cl.duoc.rastreador.ui.MenuSistema;

/**
 * Punto de entrada de la aplicación.
 */
public class MainApp {

    public static void main(String[] args) {
        // Se instancia el menú y se inicia el sistema.
        MenuSistema sistemaRastreador = new MenuSistema();
        sistemaRastreador.iniciar();
    }
}