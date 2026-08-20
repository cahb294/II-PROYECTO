/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.time.LocalDate;
import logica.Mensualidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de almacenamiento y gestion de Mensualidades.
 *
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 */
public class AlmacenamientoMensualidad {

    private List<Mensualidad> listaMensualidades;
    private int ultimoConsecutivo; // Controla el numero consecutivo ++incrementa


    /**
     * Inicializa la lista de mensualidades y el contador de consecutivos.
     */
    public AlmacenamientoMensualidad() {
        listaMensualidades = new ArrayList<>();
        ultimoConsecutivo = 0;
    }


    /**
     * Genera una nueva mensualidad y la agrega al listado.
     *
     * @param numAlquiler numero del contrato de alquiler asociado
     * @param nomInquilino nombre del inquilino responsable del pago
     * @param mesCobro Mes que se cobra 
     * @param anioActual Año de cobro 
     * @param descuento Porcentaje de descuento por temporada
     * @param montoMes Monto total a pagar en el mes
     * @return true si se genera correctamente, false si ya existía
     */
    public boolean generarMensualidad(int numAlquiler, String nomInquilino,
            int mesCobro, int anioActual,
            double descuento, double montoMes) {
        // No permitir duplicados
        // Un duplicado es: MISMO contrato + MISMO mes + MISMO año
        if (existeMensualidad(numAlquiler, mesCobro, anioActual)) {
            return false; // Ya existe  NO se genera
        }

        // ASIGNAR CONSECUTIVO AUTO-INCREMENTAL 
        ultimoConsecutivo++;
        
        Mensualidad nueva = new Mensualidad(
                ultimoConsecutivo, 
                numAlquiler, 
                LocalDate.now(),
                nomInquilino, 
                mesCobro, 
                anioActual, 
                descuento, 
                montoMes, 
                "Pendiente"
        );
        listaMensualidades.add(nueva);
        return true;
    }

    public boolean marcarComoCancelado(int consecutivo) {
        for (Mensualidad m : listaMensualidades) {
            if (m.getConsecutivo() == consecutivo) {
                m.marcarComoCancelado();  
                return true;
            }
        }
        return false;
    }


    /**
     * Verifica si ya existe una mensualidad para ese contrato en ese mes y año.
     * @param numContrato numero del contrato de alquiler
     * @param mes Mes de cobro (1-12)
     * @param anio Año de cobro
     * @return true si ya existe, false si NO existe
     */
    public boolean existeMensualidad(int numContrato, int mes, int anio) {
        for (Mensualidad m : listaMensualidades) {
            if (m.getNumAlquiler() == numContrato
                    && m.getMesCobro() == mes
                    && m.getAnioActual() == anio) {
                return true; // Encontro coincidencia ES DUPLICADO
            }
        }
        return false; // No hay coincidencia 
    }

    /**
     * Devuelve el listado completo de mensualidades registradas
     * @return Lista completa de mensualidades
     */
    public List<Mensualidad> getTodas() {
        return listaMensualidades;
    }

    /**
     * Busca y devuelve las mensualidades que coincidan con el nombre del inquilino
     * @param nombre sea parte o todo el nombre del inquilino
     * @return Lista filtrada de mensualidades
     */
    public List<Mensualidad> filtrarPorInquilino(String nombre) {
        List<Mensualidad> resultado = new ArrayList<>();
        for (Mensualidad m : listaMensualidades) {
            if (m.getNomInquilino().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    /**
     * Devuelve unicamente las mensualidades generadas en el mes indicado
     * @param mes nmero del mes 
     * @return Lista filtrada de mensualidades del mes
     */
    public List<Mensualidad> filtrarPorMes(int mes) {
        List<Mensualidad> resultado = new ArrayList<>();
        for (Mensualidad m : listaMensualidades) {
            if (m.getMesCobro() == mes) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    /**
     * Devuelve unicamente las mensualidades generadas en el año 
     * @param anio Año de cobro
     * @return Lista filtrada de mensualidades del año
     */
    public List<Mensualidad> filtrarPorAnio(int anio) {
        List<Mensualidad> resultado = new ArrayList<>();
        for (Mensualidad m : listaMensualidades) {
            if (m.getAnioActual() == anio) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    /**
     * Guarda todas las mensualidades en un archivo de texto  Mensualidades.txt
     */
    public void guardarArchivo() {
        try {
            // Crear archivo y escritor
            java.io.File archivo = new java.io.File("Mensualidades.txt");
            java.io.PrintWriter salida = new java.io.PrintWriter(new java.io.FileWriter(archivo));

            for (Mensualidad m : listaMensualidades) {
                salida.println(
                        m.getConsecutivo() + "," + 
                        m.getNumAlquiler() + ","+ 
                        m.getFechCreacion() + ","+ 
                        m.getNomInquilino() + ","+ 
                        m.getMesCobro() + ","+ 
                        m.getAnioActual() + ","+ 
                        m.getDescuento() + ","+
                        m.getMontoMes() + ","+ 
                        m.getEstado() 
                );
            }

            salida.close();
            System.out.println(" Mensualidades guardadas correctamente");

        } catch (Exception e) {
            System.out.println(" Error al guardar mensualidades: " + e.getMessage());
        }
    }

    /**
     * Lee el archivo Mensualidades.txt
     */
    public void cargarArchivo() {
        listaMensualidades.clear();   
        ultimoConsecutivo = 0;           

        try {
            java.io.File archivo = new java.io.File("Mensualidades.txt");

            // Si el archivo no existe → termina sin error
            if (!archivo.exists()) {
                System.out.println("Archivo de mensualidades no encontrado. Se iniciará vacío.");
                return;
            }

            // Leer linea por linea
            java.io.BufferedReader entrada = new java.io.BufferedReader(new java.io.FileReader(archivo));
            String linea;

            while ((linea = entrada.readLine()) != null) {
                String[] campos = linea.split(","); // Separar por comas

                // Verificar que tenga todos los campos
                if (campos.length >= 8) {
                    // Reconstruir la mensualidad desde los datos
                    Mensualidad m = new Mensualidad(
                            Integer.parseInt(campos[0]), // Consecutivo
                            Integer.parseInt(campos[1]), // num contrato
                            LocalDate.parse(campos[2]),
                            campos[3], // Nombre inquilino
                            Integer.parseInt(campos[4]), // Mes
                            Integer.parseInt(campos[5]), // Año
                            Double.parseDouble(campos[6]), // Descuento
                            Double.parseDouble(campos[7]), // Monto
                            campos.length > 8 ? campos[8] : "Pendiente"
                    );

                    // Restaurar estado si esta Cancelado
                    if (campos.length >= 9 && campos[8].equals("Cancelado")) {
                        m.marcarComoCancelado();
                    }

                    // Agregar a la lista
                    listaMensualidades.add(m);

                    // Actualizar el contador del ultimo consecutivo
                    if (m.getConsecutivo() > ultimoConsecutivo) {
                        ultimoConsecutivo = m.getConsecutivo();
                    }
                }
            }

            entrada.close(); // Cerrar archivo
            System.out.println(" Mensualidades cargadas: " + listaMensualidades.size());

        } catch (Exception e) {
            System.err.println(" Error al cargar mensualidades: " + e.getMessage());
        }
    }

}
