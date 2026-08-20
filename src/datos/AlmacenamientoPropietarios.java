/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.ArrayList;
import java.util.List;
import logica.Propietario;

/**
 * Almacena, valida y gestiona la lista de Propietarios registradas
 *
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 */
public class AlmacenamientoPropietarios {

    /**
     * Lista que almacena todos los objetos Propietario registrados
     */
    private List<Propietario> listaPropietarios;

    /**
     * Constructor que inicializa la lista como vacia
     */
    public AlmacenamientoPropietarios() {
        listaPropietarios = new ArrayList<>();
    }

    /**
     * Devuelve la lista completa de propietarios registrados
     * @return Lista con todos los objetos Propietario
     */
    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    /**
     * Agrega un nuevo propietario a la lista, verificando primero que su cedula no esté registrada --ID UNICO
     * @param propietario Objeto con los datos del propietario a agregar
     * @return true si se guardó correctamente, false si la cédula ya existe
     */
    public boolean agregarPropietario(Propietario propietario) {
        if (existeCedula(propietario.getCedPropiet())) {
            return false; // ️ Cedula duplicada --- [NO se guarda]
        }
        listaPropietarios.add(propietario);
        return true;
    }

    /**
     * Verifica si una cédula ya se encuentra registrada en la lista
     * Regla ----- cedula UNICA
     * @param cedula numero de cedula a consultar
     * @return true si la cedula ya existe, false si no esta 
     */
    public boolean existeCedula(String cedula) {
        for (Propietario p : listaPropietarios) {
            if (p.getCedPropiet().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca y devuelve un propietario segun cedula
     * @param cedula Cedula de propietario a encontrar
     * @return Objeto PROPETARIO si lo encuentra, null si no existe
     */
    public Propietario buscarCedula(String cedula) {
        for (Propietario p : listaPropietarios) {
            if (p.getCedPropiet().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Elimina de la lista el propietario que coincide con la cedula indicada
     * @param cedula Cedula del propietario a eliminar
     * @return true si fue eliminado, false si no 
     */
    public boolean eliminarPropietario(String cedula) {
        return listaPropietarios.removeIf(p -> p.getCedPropiet().equals(cedula));
    }

    /**
     * Obtiene la cantidad total de propietarios registrados
     * @return cantidad de registros
     */
    public int cantidadTotal() {
        return listaPropietarios.size();
    }

    /**
     * Guarda todos los propietarios registrados en un archivo txt
     */
    public void guardarArchivo() {
        try {
            java.io.File archivo = new java.io.File("Propietarios.txt");
            java.io.FileWriter escritorArchivo = new java.io.FileWriter(archivo);
            java.io.PrintWriter salida = new java.io.PrintWriter(escritorArchivo);

            for (Propietario propietario : listaPropietarios) {
                salida.println(
                        propietario.getCedPropiet() + ","
                        + propietario.getNomPropiet() + ","
                        + propietario.getGenero() + ","
                        + propietario.getDireccion() + ","
                        + propietario.getTelefono() + ","
                        + propietario.getEmail()
                );
            }

            salida.close();
            System.out.println("Propietarios guardados en archivo correctamente");

        } catch (java.io.IOException e) {
            System.out.println(" Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee el archivo de texto Propietarios.txt
     */
    public void cargarArchivo() {
        listaPropietarios.clear(); // Limpia la lista antes de cargar nuevos datos

        try {
            java.io.File archivo = new java.io.File("Propietarios.txt");

            if (!archivo.exists()) {
                System.out.println(" Archivo de propietarios no encontrado. Se creará al guardar.");
                return;
            }

            java.io.FileReader lectorArchivo = new java.io.FileReader(archivo);
            java.io.BufferedReader entrada = new java.io.BufferedReader(lectorArchivo);

            String linea;
            while ((linea = entrada.readLine()) != null) {
                String[] campos = linea.split(",");

                // Verifica que tenga TODOS los campos esperados (6 campos)
                if (campos.length >= 6) {
                    Propietario propietarioCargado = new Propietario(
                            campos[0], // Cedula
                            campos[1], // Nombre
                            campos[2], // Genero
                            campos[3], // Direccion
                            campos[4], // Telefono
                            campos[5] // Correo Electronico
                    );
                    listaPropietarios.add(propietarioCargado);
                }
            }

            entrada.close();
            System.out.println(" Propietarios cargados: " + listaPropietarios.size() + " registro(s)");

        } catch (java.io.IOException e) {
            System.err.println("️ Error al leer el archivo: " + e.getMessage());
        }
    }
}
