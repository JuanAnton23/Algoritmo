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
import java.util.Queue;

public class TareasPendientes {
    private Queue<Tarea> cola;

    public TareasPendientes() {
        this.cola = new LinkedList<>();
    }

    public void agregarTarea(Tarea tarea) {
        cola.add(tarea);
        System.out.println("Tarea agregada a la cola: " + tarea.getTitulo());
    }


    public void mostrarTareas() {
        if (cola.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            System.out.println("Tareas pendientes:");
            for (Tarea tarea : cola) {
                System.out.println(tarea);
            }
        }
    }
    
    public Tarea moverTarea(int indice) {
        if (indice < 0 || indice >= cola.size()) {
            System.out.println("Índice fuera de rango.");
            return null;
        }
        Tarea tarea = ((LinkedList<Tarea>) cola).remove(indice);
        System.out.println("Tarea movida: " + tarea.getTitulo());
        return tarea;
    }
    
    public void ordenarPorPrioridadYFecha() {
    List<Tarea> lista = new LinkedList<>(cola);

    lista.sort((a, b) -> {
        int comparacionPrioridad = Integer.compare(a.getPrioridad(), b.getPrioridad());
        if (comparacionPrioridad != 0) {
            return comparacionPrioridad;
        }
        return a.fechaVencimiento.compareTo(b.fechaVencimiento);
    });

    cola = new LinkedList<>(lista);

    System.out.println("Tareas pendientes ordenadas por prioridad y fecha.");
}

}

