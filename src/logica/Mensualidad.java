/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;

/**
 * Clase que representa un recibo mensual de pago.
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 */
public class Mensualidad {
 
    private int consecutivo;         // Numero unico del recibo
    private int numAlquiler;         // Numero del contrato de alquiler asociado
    private LocalDate fechCreacion;  // Fecha en que se genera el recibo
    private String nomInquilino;      // Nombre del inquilino para mostrar en el recibo
    private int mesCobro;             // Mes de cobro
    private int anioActual;           // Año de cobro
    private double descuento;         // Porcentaje de descuento dada por la temporada
    private double montoMes;          // Monto final a pagar
    private String estado;            // Estado del recibo

    /**
     * Constructor
     * @param consecutivo Nmero unico del recibo
     * @param numAlquiler Nmero del contrato asociado
     * @param fechCreacion Fecha que se genero el recibo
     * @param nomInquilino Nombre del inquilino
     * @param mesCobro Mes correspondiente al cobro
     * @param anioActual Año correspondiente
     * @param descuento Porcentaje de descuento aplicado
     * @param montoMes Monto final a pagar
     * @param estado Situacion del recibo
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

    /** @return Numero unico consecutivo del recibo */
    public int getConsecutivo() {
        return consecutivo; }

    /** @return Numero del contrato de alquiler asociado */
    public int getNumAlquiler() { 
        return numAlquiler; }

    /** @return Fecha en que se genero el recibo */
    public LocalDate getFechCreacion() {
        return fechCreacion; }

    /** @return Nombre del inquilino */
    public String getNomInquilino() {
        return nomInquilino; }

    /** @return Mes del cobro */
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
    
    /** @param consecutivo Nuevo numero unico */
    public void setConsecutivo(int consecutivo) { 
        this.consecutivo = consecutivo; }

    /** @param numAlquiler Nuevo numero de contrato asociado */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler; }

    /** @param fechCreacion Nueva fecha de generacion */
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

    /**
     * @param estado Nuevo estado del recibo
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Nuevo estado a Cancelado
     */
    public void marcarComoCancelado() {
        this.estado = "Cancelado";
    }
}
