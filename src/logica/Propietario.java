/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * Clase que representa al dueño de viviendas en alquiler
 * @author cahb294
 **/
public class Propietario {
//ATRIBUTOS
    private String cedPropiet;     // N° cedula --sin repetir
    private String nomPropiet;     // Nombre completo del propietario
    private String genero;         // Genero: Masculino / Femenino
    private String direccion;       // Direccion de residencia
    private String telefono;        // Numero de contacto
    private String email;           // Correo electronico

    /**
     * Constructor
     * @param cedPropiet Cedula
     * @param nomPropiet Nombre completo
     * @param genero Genero de la persona
     * @param direccion Dirección de residencia
     * @param telefono Numero telefonico
     * @param email Correo electronico
     */
    public Propietario(String cedPropiet, String nomPropiet, String genero, String direccion, String telefono, String email) {
        this.cedPropiet = cedPropiet;
        this.nomPropiet = nomPropiet;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

  
    /** @return Cedula del propietario */
    public String getCedPropiet() {
        return cedPropiet; }
    
    /** @return Nombre completo */
    public String getNomPropiet() {
        return nomPropiet; }
    
    /** @return Genero */
    public String getGenero() {
        return genero; }
    
    /** @return Direccion de residencia */
    public String getDireccion() {
        return direccion; }
    
    /** @return Telefono */
    public String getTelefono() { 
        return telefono; }
    
    /** @return Correo electronico */
    public String getEmail() { 
        return email; }

    /** @param cedPropiet Nueva cedula */
    public void setCedPropiet(String cedPropiet) { 
        this.cedPropiet = cedPropiet; }
    
    /** @param nomPropiet Nuevo nombre */
    public void setNomPropiet(String nomPropiet) {
        this.nomPropiet = nomPropiet; }
    
    /** @param genero Nuevo genero */
    public void setGenero(String genero) { 
        this.genero = genero; }
    
    /** @param direccion Nueva direccion */
    public void setDireccion(String direccion) { 
        this.direccion = direccion; }
    
    /** @param telefono Nuevo telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono; }
    
    /** @param email Nuevo correo */
    public void setEmail(String email) {
        this.email = email; }
}