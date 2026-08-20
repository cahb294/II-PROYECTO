/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;

/**
 * Clase que representa a la persona que arrienda una vivienda.
 * 
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 */
public class Inquilino {
      
    private String cedInqui;        // Cedula Unica
    private String nomInqui;        // Nombre completo del inquilino
    private String genero;          // Genero: Masculino / Femenino
    private LocalDate fechNac;      // Fecha nacimiento 
    private String direccion;        // Direccion de residencia
    private String telefono;         // Numero telefonico
    private String email;            // Correo electrónico
    private String ocupacion;        // Ocupacion Inquilino

    /**
     * Constructor
     * @param cedInqui Cedula
     * @param nomInqui Nombre completo
     * @param genero Genero
     * @param fechNac Fecha nacimiento 
     * @param direccion Direccion
     * @param telefono Telefono
     * @param email Correo
     * @param ocupacion Ocupacion
     */
    public Inquilino(String cedInqui, String nomInqui, String genero, LocalDate fechNac, String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }


/** @return Cedula del inquilino */
    public String getCedInqui() { return cedInqui; }

    /** @return Nombre completo del inquilino */
    public String getNomInqui() { return nomInqui; }

    /** @return Genero del inquilino */
    public String getGenero() { return genero; }

    /** @return Fecha de nacimiento */
    public LocalDate getFechNac() { return fechNac; }

    /** @return Direccion de residencia */
    public String getDireccion() { return direccion; }

    /** @return Numero telefono */
    public String getTelefono() { return telefono; }

    /** @return Correo electronico */
    public String getEmail() { return email; }

    /** @return Ocupacion */
    public String getOcupacion() { return ocupacion; }


    /** @param cedInqui Nueva cedula a asignar */
    public void setCedInqui(String cedInqui) { 
        this.cedInqui = cedInqui; }

    /** @param nomInqui Nuevo nombre completo */
    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui; }

    /** @param genero Nuevo genero */
    public void setGenero(String genero) { 
        this.genero = genero; }

    /** @param fechNac Nueva fecha de nacimiento */
    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac; }

    /** @param direccion Nueva direccion */
    public void setDireccion(String direccion) { 
        this.direccion = direccion; }

    /** @param telefono Nuevo telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono; }

    /** @param email Nuevo correo electronico */
    public void setEmail(String email) { 
        this.email = email; }

    /** @param ocupacion Nueva ocupacion */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion; }
    
     @Override
    public String toString() {
        return cedInqui + " - " + nomInqui;
    }
}
