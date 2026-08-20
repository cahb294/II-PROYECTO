/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Vivienda;
import logica.Propietario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Almacena, valida y gestiona la lista de viviendas registradas.
 *
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 *
 */
public class AlmacenamientoViviendas {

    /**
     * Lista que almacena todos los objetos Vivienda
     */
    private List<Vivienda> listaViviendas;

    /**
     * Constructor que inicializa la lista como vacia
     */
    public AlmacenamientoViviendas() {
        listaViviendas = new ArrayList<>();
    }


    /**
     * Lee un numero entero AUNQUE venga con DECIMAL 
     */
    private int leerEntero(String texto) {
        try {
            return (int) Double.parseDouble(texto.trim());
        } catch (Exception e) {
            System.out.println(" No se pudo leer número entero: " + texto);
            return 0;
        }
    }

    /**
     * Lee un numero decimal sin problema
     */
    private double leerDecimal(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (Exception e) {
           System.out.println("️ No se pudo leer número decimal: " + texto);
            return 0.0;
        }
    }

    /**
     * Al guardar → escribe SIN .0 si es entero: 25000.0 → "25000" Si es decimal
     * lo deja igual: 1.5 → "1.5"
     */
    private String limpiarNumero(double valor) {
        if (valor == (int) valor) {
            return String.valueOf((int) valor);
        } else {
            return String.valueOf(valor);
        }
    }


    /**
     * Devuelve la lista completa de viviendas registradas
     * @return Lista con todos los objetos Vivienda
     */
    public List<Vivienda> getListaViviendas() {
        return listaViviendas;
    }

    /**
     * Agrega una nueva vivienda a la lista,esta verifica primero que el ID no este registrado.
     * @param vivienda Objeto con los datos de la vivienda a agregar
     * @return true si se guarda correctamente, false si el ID ya existe
     */
    public boolean agregarVivienda(Vivienda vivienda) {
        if (existeIdVivienda(vivienda.getIdVivienda())) {
            return false;
        }
        listaViviendas.add(vivienda);
        return true;
    }

    /**
     * Verifica si un ID de vivienda ya se encuentra registrada
     * @param idVivienda Codigo identificador a consultar
     * @return true si el ID ya existe, false si no esta
     */
    public boolean existeIdVivienda(String idVivienda) {
        for (Vivienda v : listaViviendas) {
            if (v.getIdVivienda().equals(idVivienda)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca y devuelve una vivienda segun ID.
     * @param idVivienda Codigo identificador de la vivienda a encontrar
     * @return Objeto Vivienda si lo encuentra, null si no
     */
    public Vivienda buscarVivienda(String idVivienda) {
        for (Vivienda v : listaViviendas) {
            if (v.getIdVivienda().equals(idVivienda)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Elimina de la lista la vivienda que coincide con el ID indicado
     * @param idVivienda Codigo identificador a eliminar
     * @return true si fue eliminada, false si no se encontro
     */
    public boolean eliminarVivienda(String idVivienda) {
        return listaViviendas.removeIf(v -> v.getIdVivienda().equals(idVivienda));
    }

    /**
     * Obtiene la cantidad total de viviendas registradas en el sistema
     * @return numero entero con la cantidad de registros
     */
    public int cantidadTotalViviendas() {
        return listaViviendas.size();
    }

    /**
     * Busca un propietario por su nombre completo...
     * @param nombreCompleto Nombre del propietario
     * @return objeto PROPIETARIO si lo encuentra, null si no existe
     */
    public Propietario buscarPropietarioPorNombre(String nombreCompleto) {
        for (Vivienda v : listaViviendas) {
            if (v.getPropietario() != null
                    && v.getPropietario().getNomPropiet().equals(nombreCompleto)) {
                return v.getPropietario();
            }
        }
        return null;
    }

    /**
     * Guarda todas las viviendas registradas en un archivo de txt
     */
    public void guardarArchivo() {
        try {
            java.io.File archivo = new java.io.File("Viviendas.txt");
            java.io.FileWriter escritorArchivo = new java.io.FileWriter(archivo);
            java.io.PrintWriter salida = new java.io.PrintWriter(escritorArchivo);

            for (Vivienda vivienda : listaViviendas) {
                salida.println(
                        vivienda.getIdVivienda() + ","
                        + vivienda.getDescripcion() + ","
                        + vivienda.getDireccion() + ","
                        + limpiarNumero(vivienda.getMtsConstruct()) + "," + 
                        limpiarNumero(vivienda.getMtsLote()) + ","+
                        vivienda.getTipoConstruccion() + ","
                        + vivienda.isCochera() + ","
                        + limpiarNumero(vivienda.getCantHabitac()) + "," + 
                        limpiarNumero(vivienda.getCantBanios()) + "," + 
                        vivienda.getCarretera() + ","
                        + limpiarNumero(vivienda.getPrecioBase()) + "," + 
                        limpiarNumero(vivienda.getDepositoGarantia()) + "," + 
                        (vivienda.getPropietario() != null? vivienda.getPropietario().getNomPropiet(): "Sin propietario") + ","
                        + vivienda.getEstado()
                );
            }

            salida.close();
            System.out.println(" Viviendas guardadas en archivo correctamente"); // VALIDAR SI SE GUARDA EN UN SYSTEMOUTPRINT -FUNCIONA CAHB294

        } catch (java.io.IOException e) {
            System.out.println(" Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee el archivo Viviendas.txt y carga todos los registros en la lista
     */
    public void cargarArchivo() {
        listaViviendas.clear();

        try {
            java.io.File archivo = new java.io.File("Viviendas.txt");

            if (!archivo.exists()) {
                System.out.println("Archivo de viviendas no encontrado. Se crea al guardar.");
                return;
            }

            java.io.FileReader lectorArchivo = new java.io.FileReader(archivo);
            java.io.BufferedReader entrada = new java.io.BufferedReader(lectorArchivo);

            String linea;
            while ((linea = entrada.readLine()) != null) {
                String[] campos = linea.split(",");

                if (campos.length >= 14) {
                    Propietario propietarioCargado = null;

                    Vivienda viviendaCargada = new Vivienda(
                            campos[0], // idVivienda
                            campos[1], // descripcion
                            campos[2], // direccion
                            leerDecimal(campos[3]), //  mtsConstruc
                            leerDecimal(campos[4]), //  mtsLote
                            campos[5], // tipoConstruccion
                            Boolean.parseBoolean(campos[6]), // cochera
                            leerEntero(campos[7]), //  cantHabitac
                            leerDecimal(campos[8]), //  cantBanos -- HAY QUE VALIDAR DECIMAL ACA, MARIAGALLO
                            campos[9], // carretera
                            leerDecimal(campos[10]), //  precioBase
                            leerDecimal(campos[11]), // depositoGarantia
                            propietarioCargado, // objeto Propietario
                            campos[13] // estado
                    );
                    listaViviendas.add(viviendaCargada);
                }
            }

            entrada.close();
            System.out.println("Viviendas cargadas: " + listaViviendas.size() + " registro(s)");

        } catch (java.io.IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println(" Error al convertir numeros del archivo: " + e.getMessage());
        }
    }

}
