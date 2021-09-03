package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.DBConn;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1> <br>
 * Clase para definir la clase contenedora
 */
public class Academia {
    /**
     * Atributo para definir la clase de la conexión de la base de datos.
     */
    private DBConn db = new DBConn("./lib/C1-T2.accdb");
    /**
     * Atributo para definir el DAO de estudiantes.
     */
    private EstudianteDAO estudiantes = new EstudianteDAO();

    /**
     * Método para restaurar los estudiantes de la base de datos y agregarlos a la ejecución actual.
     */
    public void restaurar() {
        var dbEstudiantes = db.getEstudiantes();
        for (int i = 0; i < dbEstudiantes.size(); i++) {
            var estudiante = dbEstudiantes.get(i).split(";");
            //Aquí me baso de la información que obtengo en las casillas desde la base de datos
            estudiantes.crear(Integer.parseInt(estudiante[0]), estudiante[1], estudiante[2], estudiante[3],
                    Integer.parseInt(estudiante[4]), estudiante[5]);
        }
    }

    /**
     * Método para crear un estudiante y guardarlo en la base de datos.
     * @param matricula
     * @param nombres
     * @param apellidos
     * @param sexo
     * @param edad
     * @param curso
     */
    public void crear(int matricula, String nombres, String apellidos, String sexo, int edad, String curso) {
        if (estudiantes.crear(matricula, nombres, apellidos, sexo, edad, curso)) {
            db.addEstudiante(matricula, nombres, apellidos, sexo, edad, curso);
            //Validación en caso de que el ID que trae Access sea el mismo del tamaño del arreglo
        } else if (estudiantes.crear(matricula+1, nombres, apellidos, sexo, edad, curso)) {
            db.addEstudiante(matricula+1, nombres, apellidos, sexo, edad, curso);
        }
    }

    public DBConn getDb() {
        return db;
    }

    public EstudianteDAO getEstudiantes() {
        return estudiantes;
    }
}
