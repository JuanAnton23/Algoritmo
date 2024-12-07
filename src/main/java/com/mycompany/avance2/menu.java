/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avance2;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author juana
 */

public class menu {

    public static void main(String[] args) {
        TareasPendientes tareasPendientes = new TareasPendientes();
        TareasEnProgreso tareasEnProgreso = new TareasEnProgreso();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Tarea tarea1 = new Tarea("Revision de calidad", "Comprobar tolerancias", 2, sdf.parse("20/12/2024"));
            Tarea tarea2 = new Tarea("Informe mensual", "Elaborar reporte de pruebas", 1, sdf.parse("25/12/2024"));
            tareasPendientes.agregarTarea(tarea1);
            tareasPendientes.agregarTarea(tarea2);

            while (true) {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Ver tareas pendientes");
                System.out.println("2. Ver tareas en progreso");
                System.out.println("3. Ordenar tareas pendientes por prioridad y fecha");
                System.out.println("4. Ordenar tareas en progreso por prioridad y fecha");
                System.out.println("5. Agregar nueva tarea");
                System.out.println("6. Mover tarea de pendientes a en progreso");
                System.out.println("7. Completar tarea en progreso");
                System.out.println("8. Salir");
                System.out.print("Opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        tareasPendientes.mostrarTareas();
                        break;
                    case 2:
                        tareasEnProgreso.mostrarTareas();
                        break;
                    case 3:
                        tareasPendientes.ordenarPorPrioridadYFecha();
                        break;
                    case 4:
                        tareasEnProgreso.ordenarPorPrioridadYFecha();
                        break;
                    case 5:
                        System.out.print("\nNombre de la tarea: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Descripción de la tarea: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Prioridad (1-5): ");
                        int prioridad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Fecha de vencimiento (dd/MM/yyyy): ");
                        String fecha = scanner.nextLine();

                        try {
                            Tarea nuevaTarea = new Tarea(nombre, descripcion, prioridad, sdf.parse(fecha));
                            tareasPendientes.agregarTarea(nuevaTarea);
                        } catch (Exception e) {
                            System.out.println("Error al ingresar la tarea: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Seleccionar tarea de pendientes para mover a en progreso:");
                        tareasPendientes.mostrarTareas();
                        System.out.print("Seleccione el índice de la tarea (1 a n): ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();
                        Tarea tareaAMover = tareasPendientes.moverTarea(indice - 1);
                        if (tareaAMover != null) {
                            tareasEnProgreso.agregarTarea(tareaAMover);
                        }
                        break;
                    case 7:
                        Tarea completada = tareasEnProgreso.completarTarea();
                        if (completada != null) {
                            System.out.println("Tarea completada: " + completada.getTitulo());
                        }
                        break;
                    case 8:
                        System.out.println("Gracias por usar el programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

