/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Inquilino;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de almacenamiento y gestion de Inquiñlinos Registrados
 *
 * @author cahb294
 * @author BrianOrozco
 * @author MariaGallo
 */
public class AlmacenamientoInquilinos {

    /**
     * Lista que almacena todos los objetos Inquilino registrados
     */
    private List<Inquilino> listaInquilinos;

    /**
     * Constructor que inicializa la lista como vacía.
     */
    public AlmacenamientoInquilinos() {
        listaInquilinos = new ArrayList<>();
    }

    /**
     * Devuelve la lista completa de inquilinos registrados
     * @return Lista con todos los objetos Inquilino
     */
    public List<Inquilino> getListaInquilinos() {
        return listaInquilinos;
    }

    /**
     * Agrega un nuevo inquilino a la lista, verificando primero que su cedula --ID UNICO
     * @param inquilino Objeto con los datos del inquilino a agregar
     * @return true si se guardo correctamente, false si la cedula ya existe
     */
    public boolean agregarInquilino(Inquilino inquilino) {
        if (existeCedula(inquilino.getCedInqui())) {
            return false;
        }
        listaInquilinos.add(inquilino);
        return true;
    }

    /**
     * Verifica si una cedula ya se encuentra registrada en la lista
     * @param cedInqui nuimero de cedula que se desea consultar
     * @return true si la cedula ya existe en caso contario false
     */
    public boolean existeCedula(String cedInqui) {
        for (Inquilino i : listaInquilinos) {
            if (i.getCedInqui().equals(cedInqui)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca y devuelve un inquilino segun su cedula
     * @param cedInqui Cedula del inquilino que se desea encontrar
     * @return Objeto Inquilino si lo encuentra, null si no existe
     */
    public Inquilino buscarCedula(String cedInqui) {
        for (Inquilino i : listaInquilinos) {
            if (i.getCedInqui().equals(cedInqui)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Elimina de la lista el inquilino que coincide con la cedula indicada
     * @param cedInqui Cedula del inquilino a eliminar
     * @return true si fue eliminado, false si no se encontro
     */
    public boolean eliminarInquilino(String cedInqui) {
        return listaInquilinos.removeIf(i -> i.getCedInqui().equals(cedInqui));
    }

    /**
     * Obtiene la cantidad total de inquilinos registrados en el sistema
     * @return Numero entero con la cantidad de registros
     */
    public int cantidadTotal() {
        return listaInquilinos.size();
    }

    /**
     * Guarda todos los inquilinos registrados en un archivo txt
     */
    public void guardarArchivo() {
        try {
            java.io.File archivo = new java.io.File("Inquilinos.txt");
            java.io.FileWriter escritorArchivo = new java.io.FileWriter(archivo);
            java.io.PrintWriter salida = new java.io.PrintWriter(escritorArchivo);

            for (Inquilino inquilino : listaInquilinos) {
                salida.println(
                        inquilino.getCedInqui() + ","
                        + inquilino.getNomInqui() + ","
                        + inquilino.getGenero() + ","
                        + inquilino.getFechNac() + ","
                        + inquilino.getDireccion() + ","
                        + inquilino.getTelefono() + ","
                        + inquilino.getEmail() + ","
                        + inquilino.getOcupacion()
                );
            }

            salida.close();
            System.out.println(" Inquilinos guardados en archivo correctamente");

        } catch (java.io.IOException e) {
            System.out.println(" Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee el archivo de texto Inquilinos.txt
     */
    public void cargarArchivo() {
        listaInquilinos.clear(); // Limpia la lista antes de cargar nuevos datos

        try {
            java.io.File archivo = new java.io.File("Inquilinos.txt");

            if (!archivo.exists()) {
                System.out.println("Archivo de inquilinos no encontrado, Se crearon al guardar.");
                return;
            }

            java.io.FileReader lectorArchivo = new java.io.FileReader(archivo);
            java.io.BufferedReader entrada = new java.io.BufferedReader(lectorArchivo);

            String linea;
            while ((linea = entrada.readLine()) != null) {
                String[] campos = linea.split(",");

                if (campos.length >= 8) {
                    Inquilino inquilinoCargado = new Inquilino(
                            campos[0], // Cedula
                            campos[1], // Nombre
                            campos[2], // Genero
                            java.time.LocalDate.parse(campos[3]), // Fecha de nacimiento
                            campos[4], // Direccion
                            campos[5], // Telefono
                            campos[6], // Correo
                            campos[7] // Ocupacion
                    );
                    listaInquilinos.add(inquilinoCargado);
                }
            }

            entrada.close();
            System.out.println(" Inquilinos cargados: " + listaInquilinos.size() + " registro(s)");

        } catch (java.io.IOException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
        }
    }
}
