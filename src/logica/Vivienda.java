/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/*
 * Clase que representa la casa disponible para alquiler.
 * @author cahb294
 */
public class Vivienda {
//  ATRIBUTOS
    private String idVivienda;          // ID Unico
    private String descripcion;          // descripción de la propiedad
    private String direccion;            // Direccion de ubicación
    private double mtsConstruct;         // Metros cuadrados de construccion
    private double mtsLote;              // Metros cuadrados del lote
    private String tipoConstruccion;     // Material: Block, Baldosa, super block, madera, mixta
    private boolean cochera;             // true = tiene cochera, false = no tiene
    private int cantHabitac;             // Cantidad de habitaciones 
    private double cantBanios;           // Cantidad de baños 
    private String carretera;            // Vía de acceso: lastre, pavimentada, adoquinada
    private double precioBase;           // Precio base mensual de alquiler
    private double depositoGarantia;     // Monto de garantia 
    private Propietario propietario;    // Objeto Propietario: dueño de la propiedad
    private String estado;               // Estado actual: disponible, alquilada, inactiva

    /**
     * Constructor
     * @param idVivienda ID Unico 
     * @param descripcion descripcion de la propiedad
     * @param direccion Direccion exacta de la ubicacion
     * @param mtsConstruct Metros cuadrados de construccion
     * @param mtsLote Metros cuadrados del terreno
     * @param tipoConstruccion Material de construccion
     * @param cochera Indica si tiene o no cochera
     * @param cantHabitac Cantidad de habitaciones
     * @param cantBanios Cantidad de baños
     * @param carretera Tipo de via de acceso
     * @param precioBase Precio base mensual de alquiler
     * @param depositoGarantia Monto entregado como garantia
     * @param propietario Objeto Propietario dueño
     * @param estado Situación actual de la vivienda
     */
    public Vivienda(String idVivienda, String descripcion, String direccion, double mtsConstruct,
                    double mtsLote, String tipoConstruccion, boolean cochera, int cantHabitac,
                    double cantBanios, String carretera, double precioBase, double depositoGarantia,
                    Propietario propietario, String estado) {
        this.idVivienda = idVivienda;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mtsConstruct = mtsConstruct;
        this.mtsLote = mtsLote;
        this.tipoConstruccion = tipoConstruccion;
        this.cochera = cochera;
        this.cantHabitac = cantHabitac;
        this.cantBanios = cantBanios;
        this.carretera = carretera;
        this.precioBase = precioBase;
        this.depositoGarantia = depositoGarantia;
        this.propietario = propietario;
        this.estado = estado;
    }

    /** @return ID Unico de la vivienda */
    public String getIdVivienda() { 
        return idVivienda; }

    /** @return Descripcion de la vivienda */
    public String getDescripcion() { 
        return descripcion; }

    /** @return Direccion completa */
    public String getDireccion() {
        return direccion; }

    /** @return Metros cuadrados de construccion */
    public double getMtsConstruct() {
        return mtsConstruct; }

    /** @return Metros cuadrados del terreno */
    public double getMtsLote() {
        return mtsLote; }

    /** @return Tipo de material de construccion */
    public String getTipoConstruccion() {
        return tipoConstruccion; }

    /** @return true si tiene cochera, false si no */
    public boolean isCochera() {
        return cochera; }

    /** @return Cantidad de habitaciones */
    public int getCantHabitac() {
        return cantHabitac; }

    /** @return Cantidad de baños */
    public double getCantBanios() {
        return cantBanios; }

    /** @return Tipo de acceso */
    public String getCarretera() {
        return carretera; }

    /** @return Precio base mensual */
    public double getPrecioBase() { 
        return precioBase; }

    /** @return Monto garantia */
    public double getDepositoGarantia() {
        return depositoGarantia; }

    /** @return Objeto Propietario dueño de la vivienda */
    public Propietario getPropietario() {
        return propietario; }

    /** @return Estado actual de la vivienda */
    public String getEstado() { 
        return estado; }

    
    /** @param idVivienda Nuevo ID Unico */
    public void setIdVivienda(String idVivienda) {
        this.idVivienda = idVivienda; }

    /** @param descripcion Nueva descripcion */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; }

    /** @param direccion Nueva direccion */
    public void setDireccion(String direccion) {
        this.direccion = direccion; }

    /** @param mtsConstruct Nuevos metros de construccion */
    public void setMtsConstruct(double mtsConstruct) { 
        this.mtsConstruct = mtsConstruct; }

    /** @param mtsLote Nuevos metros de terreno */
    public void setMtsLote(double mtsLote) { 
        this.mtsLote = mtsLote; }

    /** @param tipoConstruccion Nuevo tipo de construccion */
    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion; }

    /** @param cochera Nuevo valor indicando si tiene cochera */
    public void setCochera(boolean cochera) { 
        this.cochera = cochera; }

    /** @param cantHabitac Nueva cantidad de habitaciones */
    public void setCantHabitac(int cantHabitac) {
        this.cantHabitac = cantHabitac; }

    /** @param cantBanios Nueva cantidad de baños */
    public void setCantBanios(double cantBanios) { 
        this.cantBanios = cantBanios; }

    /** @param carretera Nuevo tipo de via */
    public void setCarretera(String carretera) { 
        this.carretera = carretera; }

    /** @param precioBase Nuevo precio base mensual */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase; }

    /** @param depositoGarantia Nuevo monto de garantia */
    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia; }

    /** @param propietario Nuevo objeto Propietario */
    public void setPropietario(Propietario propietario) { 
        this.propietario = propietario; }

    /** @param estado Nuevo estado de la vivienda */
    public void setEstado(String estado) { 
        this.estado = estado; }
}
