/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;

/**
 * Clase que representa un recibo mensual de pago.
 * @author cahb294
 */
public class Mensualidad {
   // ==== ATRIBUTOS ====
    private int consecutivo;         // Número único del recibo
    private int numAlquiler;         // Número del contrato de alquiler asociado
    private LocalDate fechCreacion;  // Fecha en que se generó el recibo
    private String nomInquilino;      // Nombre del inquilino para mostrar en el recibo
    private int mesCobro;             // Mes de cobro: 1=Enero, 2=Febrero ... 12=Diciembre
    private int anioActual;           // Año del cobro (4 dígitos ej: 2026)
    private double descuento;         // Porcentaje de descuento según temporada
    private double montoMes;          // Monto final a pagar con descuento incluido
    private String estado;            // Estado del recibo: Pendiente, Cancelado

    /**
     * Constructor: crea un objeto Mensualidad con los datos del recibo
     * @param consecutivo Número único del recibo
     * @param numAlquiler Número del contrato asociado
     * @param fechCreacion Fecha de generación del recibo
     * @param nomInquilino Nombre del inquilino
     * @param mesCobro Mes correspondiente al cobro
     * @param anioActual Año correspondiente
     * @param descuento Porcentaje de descuento aplicado
     * @param montoMes Monto final a pagar
     * @param estado Situación del recibo
     */
    public Mensualidad(int consecutivo, int numAlquiler, LocalDate fechCreacion, String nomInquilino,
                       int mesCobro, int anioActual, double descuento, double montoMes, String estado) {
        this.consecutivo = consecutivo;
        this.numAlquiler = numAlquiler;
        this.fechCreacion = fechCreacion;
        this.nomInquilino = nomInquilino;
        this.mesCobro = mesCobro;
        this.anioActual = anioActual;
        this.descuento = descuento;
        this.montoMes = montoMes;
        this.estado = estado;
    }

    // ==== GETTERS: Leer valor de cada atributo ====
    /** @return Número único consecutivo del recibo */
    public int getConsecutivo() {
        return consecutivo; }

    /** @return Número del contrato de alquiler asociado */
    public int getNumAlquiler() { 
        return numAlquiler; }

    /** @return Fecha en que se generó el recibo */
    public LocalDate getFechCreacion() {
        return fechCreacion; }

    /** @return Nombre del inquilino */
    public String getNomInquilino() {
        return nomInquilino; }

    /** @return Mes del cobro (1-12) */
    public int getMesCobro() { 
        return mesCobro; }

    /** @return Año del cobro */
    public int getAnioActual() { 
        return anioActual; }

    /** @return Porcentaje de descuento aplicado */
    public double getDescuento() {
        return descuento; }

    /** @return Monto final a pagar */
    public double getMontoMes() {
        return montoMes; }

    /** @return Estado del recibo */
    public String getEstado() {
        return estado; }
    
    /** @param consecutivo Nuevo número único */
    public void setConsecutivo(int consecutivo) { 
        this.consecutivo = consecutivo; }

    /** @param numAlquiler Nuevo número de contrato asociado */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler; }

    /** @param fechCreacion Nueva fecha de generación */
    public void setFechCreacion(LocalDate fechCreacion) { 
        this.fechCreacion = fechCreacion; }

    /** @param nomInquilino Nuevo nombre de inquilino */
    public void setNomInquilino(String nomInquilino) {
        this.nomInquilino = nomInquilino; }

    /** @param mesCobro Nuevo mes de cobro */
    public void setMesCobro(int mesCobro) { 
        this.mesCobro = mesCobro; }

    /** @param anioActual Nuevo año */
    public void setAnioActual(int anioActual) {
        this.anioActual = anioActual; }

    /** @param descuento Nuevo porcentaje de descuento */
    public void setDescuento(double descuento) {
        this.descuento = descuento; }

    /** @param montoMes Nuevo monto final */
    public void setMontoMes(double montoMes) {
        this.montoMes = montoMes; }

    /** @param estado Nuevo estado del recibo */
    public void setEstado(String estado) {
        this.estado = estado; }  
}
