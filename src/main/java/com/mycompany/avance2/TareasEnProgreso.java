/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance2;

/**
 *
 * @author juana
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TareasEnProgreso {
    private Stack<Tarea> pila;

    public TareasEnProgreso() {
        this.pila = new Stack<>();
    }

    public void agregarTarea(Tarea tarea) {
        pila.push(tarea);
        System.out.println("Tarea agregada a la pila: " + tarea.getTitulo());
    }
    
    public Tarea completarTarea() {
        if (pila.isEmpty()) {
            System.out.println("No hay tareas en progreso para completar.");
            return null;
        }
        return pila.pop();
    }

    public void mostrarTareas() {
        if (pila.isEmpty()) {
            System.out.println("No hay tareas en progreso.");
        } else {
            System.out.println("Tareas en progreso:");
            for (Tarea tarea : pila) {
                System.out.println(tarea);
            }
        }
    }
    
    public void ordenarPorPrioridadYFecha() {
    List<Tarea> lista = new LinkedList<>(pila);

    lista.sort((a, b) -> {
        int comparacionPrioridad = Integer.compare(a.getPrioridad(), b.getPrioridad());
        if (comparacionPrioridad != 0) {
            return comparacionPrioridad;
        }
        return a.fechaVencimiento.compareTo(b.fechaVencimiento);
    });

    pila = new Stack<>();
    pila.addAll(lista);

    System.out.println("Tareas en progreso ordenadas por prioridad y fecha.");
}


}
