/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juana
 */
public class TareasCompletadas {
    List<Tarea> completadas;

    public TareasCompletadas() {
        this.completadas = new ArrayList<>();
    }

    public void agregarTareaCompletada(Tarea tarea) {
        completadas.add(tarea);
        System.out.println("Tarea completada: " + tarea.getTitulo());
    }

    public void mostrarTareasCompletadas() {
        if (completadas.isEmpty()) {
            System.out.println("No hay tareas completadas.");
        } else {
            System.out.println("Tareas completadas:");
            for (Tarea tarea : completadas) {
                System.out.println(tarea);
            }
        }
    }
}
