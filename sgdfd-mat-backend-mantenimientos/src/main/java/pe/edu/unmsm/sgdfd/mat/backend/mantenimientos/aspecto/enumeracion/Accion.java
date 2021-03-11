package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion;

public enum Accion {

	REGISTRO("I"),  
    VISITA("V"),
    ACTUALIZACION("U"), 
    ELIMINACION("D"),
    CONSULTA("S"),
    Reporte("R"),
    Ejecucion("E"),
    Acceso("A"),
    Ninguna("");
    
    private final String nombre;       

    private Accion(String s) {
        nombre = s;
    }

    public String toString() {
       return this.nombre;
    }   
}
