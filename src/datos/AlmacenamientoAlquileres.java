/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Alquiler;
import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Gestiona la lista y Contratos de Alquiler 
 * Regla: una vivienda NO puede tener mas de un alquiler
 *
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 */
public class AlmacenamientoAlquileres {

    private ArrayList<Alquiler> listaAlquileres;
    private final String nombreArchivo = "Alquileres.txt";
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Inicializa lista vacia
     */
    public AlmacenamientoAlquileres() {
        listaAlquileres = new ArrayList<>();
    }

    /**
     * @return Lista completa de contratos
     */
    public ArrayList<Alquiler> getListaAlquileres() {
        return listaAlquileres;
    }

    /**
     * Agrega nuevo contrato. Verifica que vivienda no este alquilada
     * @return true = registrado, false = vivienda ya tiene contrato
     */
    public boolean agregarAlquiler(Alquiler alq) {
        if (estaAlquilada(alq.getIdVivienda())) {
            return false;
        }
        listaAlquileres.add(alq);
        guardarArchivo();
        return true;
    }

    /**
     * Elimina contrato por ID de vivienda
     * @return true si eliminó
     */
    public boolean eliminarAlquiler(String idVivienda) {
        for (int i = 0; i < listaAlquileres.size(); i++) {
            if (listaAlquileres.get(i).getIdVivienda().equals(idVivienda)) {
                listaAlquileres.remove(i);
                guardarArchivo();
                return true;
            }
        }
        return false;
    }

    /**
     * Busca contrato activo por vivienda
     */
    public Alquiler buscarAlquilerPorVivienda(String idVivienda) {
        for (Alquiler alq : listaAlquileres) {
            if (alq.getIdVivienda().equals(idVivienda)) {
                return alq;
            }
        }
        return null;
    }

    /**
     * Verifica si vivienda ya tiene contrato
     */
    public boolean estaAlquilada(String idVivienda) {
        return buscarAlquilerPorVivienda(idVivienda) != null;
    }

    /**
     * @return numero consecutivo siguiente automático
     */
    public int getSiguienteNumero() {
        int mayor = 0;
        for (Alquiler alq : listaAlquileres) {
            if (alq.getNumAlquiler() > mayor) {
                mayor = alq.getNumAlquiler();
            }
        }
        return mayor + 1;
    }

    /**
     * Guarda todos los contratos en archivo de texto
     */
    public void guardarArchivo() {
        try (PrintWriter escribir = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Alquiler alq : listaAlquileres) {
                escribir.println(
                        alq.getNumAlquiler() + "|"
                        + alq.getFechContrato().format(formatoFecha) + "|"
                        + alq.getCantMeses() + "|"
                        + alq.getNumAdultos() + "|"
                        + alq.getNumNinos() + "|"
                        + alq.getDepositoGarantia() + "|"
                        + alq.getPrecioAlquiler() + "|"
                        + alq.getPorcIncremAnual() + "|"
                        + alq.getCedInquilino() + "|"
                        + alq.getIdVivienda() + "|"
                        + alq.getEstado()
                );
            }
        } catch (IOException e) {
            System.out.println("Error al guardar Alquileres.txt: " + e.getMessage());
        }
    }

    /**
     * Carga contratos desde archivo al iniciar el sistema
     */
    public void cargarArchivo() {
        listaAlquileres.clear();
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("Archivo Alquileres.txt no existe., se creara al guardar");
            return;
        }

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = leer.readLine()) != null) {
                try {
                    String[] datos = linea.split("\\|");
                    Alquiler nuevo = new Alquiler(
                            Integer.parseInt(datos[0]),
                            LocalDate.parse(datos[1], formatoFecha),
                            Integer.parseInt(datos[2]),
                            Integer.parseInt(datos[3]),
                            Integer.parseInt(datos[4]),
                            Double.parseDouble(datos[5]),
                            Double.parseDouble(datos[6]),
                            Double.parseDouble(datos[7]),
                            datos[8], datos[9], datos[10]
                    );
                    listaAlquileres.add(nuevo);
                } catch (Exception e) {
                    System.out.println("Linea ignorada: " + linea);
                }
            }
            System.out.println("Alquileres cargados: " + listaAlquileres.size());
        } catch (IOException e) {
            System.out.println("Error al leer Alquileres.txt: " + e.getMessage());
        }
    }
}
