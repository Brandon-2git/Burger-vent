package com.burguerVent.eventos;

import org.springframework.stereotype.Service;

@Service
public class NavigationService {
    private Runnable onPagoCompletado;
    private Runnable onRegresarMenu;

    public void setOnPagoCompletado(Runnable action) {
        this.onPagoCompletado = action;
    }

    public void setOnRegresarMenu(Runnable action) {
        this.onRegresarMenu = action;
    }

    public void notifyPagoCompletado() {
        if (onPagoCompletado != null) {
            onPagoCompletado.run();
        }
    }

    public void notifyRegresarMenu() {
        if (onRegresarMenu != null) {
            onRegresarMenu.run();
        }
    }
} 