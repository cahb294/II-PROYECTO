/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;

/**
 *
 * @author cahb294
 */
public class Alquiler {
  // ATRIBUTOS
    private int numAlquiler;             // Numero Unico 
    private LocalDate fechContrato;     // Fecha de contrato 
    private int cantMeses;               // Duración del contrato en meses
    private int numAdultos;              // Cantidad de personas adultas que habitan
    private int numNinos;                // Cantidad de menores de edad que habitan
    private double depositoGarantia;     // Dinero entregado como garantía al firmar
    private double precioAlquiler;       // Precio mensual acordado
    private double porcIncremAnual;      // Porcentaje de aumento anual (rango permitido: 1% a 30%)
    private String cedInquilino;         // Cédula del inquilino que firma el contrato
    private String idVivienda;            // Código de la vivienda que se alquila
    private String estado;               // Estado del contrato: Vigente, Vencido, Cancelado

    /**
     * Constructor: crea un objeto Alquiler con todos los datos del contrato
     * @param numAlquiler Número único consecutivo
     * @param fechContrato Fecha de firma del contrato (convertida desde JDatePicker)
     * @param cantMeses Duración del contrato en meses
     * @param numAdultos Cantidad de adultos
     * @param numNinos Cantidad de niños
     * @param depositoGarantia Monto de garantía
     * @param precioAlquiler Precio mensual acordado
     * @param porcIncremAnual Porcentaje de incremento anual
     * @param cedInquilino Cédula del inquilino
     * @param idVivienda Código de la vivienda
     * @param estado Situación del contrato
     */
    public Alquiler(int numAlquiler, LocalDate fechContrato, int cantMeses, int numAdultos,
                    int numNinos, double depositoGarantia, double precioAlquiler,
                    double porcIncremAnual, String cedInquilino, String idVivienda, String estado) {
        this.numAlquiler = numAlquiler;
        this.fechContrato = fechContrato;
        this.cantMeses = cantMeses;
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
        this.depositoGarantia = depositoGarantia;
        this.precioAlquiler = precioAlquiler;
        this.porcIncremAnual = porcIncremAnual;
        this.cedInquilino = cedInquilino;
        this.idVivienda = idVivienda;
        this.estado = estado;
    }

    // ==== GETTERS: Leer valor de cada atributo ====
    /** @return Número único del contrato */
    public int getNumAlquiler() { return numAlquiler; }

    /** @return Fecha de firma del contrato */
    public LocalDate getFechContrato() { return fechContrato; }

    /** @return Duración en meses */
    public int getCantMeses() { return cantMeses; }

    /** @return Cantidad de adultos */
    public int getNumAdultos() { return numAdultos; }

    /** @return Cantidad de niños */
    public int getNumNinos() { return numNinos; }

    /** @return Monto de garantía */
    public double getDepositoGarantia() { return depositoGarantia; }

    /** @return Precio mensual acordado */
    public double getPrecioAlquiler() { return precioAlquiler; }

    /** @return Porcentaje de incremento anual */
    public double getPorcIncremAnual() { return porcIncremAnual; }

    /** @return Cédula del inquilino */
    public String getCedInquilino() { return cedInquilino; }

    /** @return Código de la vivienda */
    public String getIdVivienda() { return idVivienda; }

    /** @return Estado actual del contrato */
    public String getEstado() { return estado; }

    // ==== SETTERS: Modificar valor de cada atributo ====
    /** @param numAlquiler Nuevo número único */
    public void setNumAlquiler(int numAlquiler) { this.numAlquiler = numAlquiler; }

    /** @param fechContrato Nueva fecha del contrato */
    public void setFechContrato(LocalDate fechContrato) { this.fechContrato = fechContrato; }

    /** @param cantMeses Nueva duración en meses */
    public void setCantMeses(int cantMeses) { this.cantMeses = cantMeses; }

    /** @param numAdultos Nueva cantidad de adultos */
    public void setNumAdultos(int numAdultos) { this.numAdultos = numAdultos; }

    /** @param numNinos Nueva cantidad de niños */
    public void setNumNinos(int numNinos) { this.numNinos = numNinos; }

    /** @param depositoGarantia Nuevo monto de garantía */
    public void setDepositoGarantia(double depositoGarantia) { this.depositoGarantia = depositoGarantia; }

    /** @param precioAlquiler Nuevo precio mensual */
    public void setPrecioAlquiler(double precioAlquiler) { this.precioAlquiler = precioAlquiler; }

    /** @param porcIncremAnual Nuevo porcentaje de incremento */
    public void setPorcIncremAnual(double porcIncremAnual) { this.porcIncremAnual = porcIncremAnual; }

    /** @param cedInquilino Nueva cédula de inquilino */
    public void setCedInquilino(String cedInquilino) { this.cedInquilino = cedInquilino; }

    /** @param idVivienda Nuevo código de vivienda */
    public void setIdVivienda(String idVivienda) { this.idVivienda = idVivienda; }

    /** @param estado Nuevo estado del contrato */
    public void setEstado(String estado) { this.estado = estado; }  
}
