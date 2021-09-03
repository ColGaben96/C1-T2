package co.edu.unbosque.model.persistence;

import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1> <br>
 * Clase para conectar a la "base de datos"
 */
public class DBConn {
    /**
     * Atributo para definir la ruta
     */
    private final String path;
    /**
     * Atributo según documentación de Jackcess para obtener y añadir datos.
     */
    private Database db;

    /**
     * Método constructor para definir la ruta del archivo
     * @param path
     */
    public DBConn(String path) {
        this.path = path;
    }

    /**
     * Método para conectar a la base de datos
     * @return
     */
    public int connect() {
        try {
            db = DatabaseBuilder.open(new File(path));
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    /**
     * Método para obtener todos los estudiantes separados por comas
     * @return
     */
    public ArrayList<String> getEstudiantes() {
        ArrayList<String> val = new ArrayList<>();
        try {
            Table t = db.getTable("Estudiante");
            for (Row reg : t) {
                val.add(reg.get("Matricula") + ";" + reg.getString("Nombres") +";"
                        + reg.getString("Apellidos")+ ";" + reg.getString("Sexo")+ ";"
                        + reg.get("Edad")+ ";" + reg.getString("Curso"));
            }
        } catch (Exception e) {
            val = null;
        }
        return val;
    }

    /**
     * Método para añadir un estudiante a la base de datos
     * @param matricula
     * @param nombres
     * @param apellidos
     * @param sexo
     * @param edad
     * @param curso
     */
    public void addEstudiante(int matricula, String nombres, String apellidos, String sexo, int edad, String curso) {
        try {
            Table t = db.getTable("Estudiante");
            t.addRow(matricula, apellidos, nombres, sexo, edad, curso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para finalizar la conexión
     * @return
     */
    public int finishConnection() {
        try {
            db.close();
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }
}
