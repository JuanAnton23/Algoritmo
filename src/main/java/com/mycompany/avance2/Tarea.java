/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance2;

/**
 *
 * @author juana
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tarea {
    String titulo;
    String descripcion;
    int prioridad;
    Date fechaVencimiento;

    public Tarea(String titulo, String descripcion, int prioridad, Date fechaVencimiento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        return "Tarea: " + titulo + " | Prioridad: " + prioridad + " | Vence: " + sdf.format(fechaVencimiento);
    }
}


