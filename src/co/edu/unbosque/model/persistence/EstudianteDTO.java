package co.edu.unbosque.model.persistence;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1> <br>
 * Clase para definir un objeto de tipo Estudiante
 */
public class EstudianteDTO {
    /**
     * Atributo para definir el identificador de la matrícula
     */
    private int matricula;
    /**
     * Atributo para definir los nombres
     */
    private String nombres;
    /**
     * Atributo para definir los atributos
     */
    private String apellidos;
    /**
     * Atributo para definir el sexo
     */
    private String sexo;
    /**
     * Atributo para definir la edad
     */
    private int edad;
    /**
     * Atributo para definir el curso
     */
    private String curso;

    /**
     * Método constructor para definir los atributos
     * @param matricula
     * @param nombres
     * @param apellidos
     * @param sexo
     * @param edad
     * @param curso
     */
    public EstudianteDTO(int matricula, String nombres, String apellidos, String sexo, int edad, String curso) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.edad = edad;
        this.curso = curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
