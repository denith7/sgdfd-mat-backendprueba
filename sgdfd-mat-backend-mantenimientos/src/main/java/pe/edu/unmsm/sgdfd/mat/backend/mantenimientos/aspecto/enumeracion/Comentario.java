package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion;

public enum Comentario {

	/*Aplicación*/
    CONSULTA_TODOS("Se intenta consultar todos los(as) datos de %s"),
    CONSULTA_POR_CRITERIO("Se intenta consultar información filtrada por Criterio de %s"),
    CONSULTA_POR_ID("Se intenta consultar información filtrada por Identificador de %s"),
    
    Consulta("Se intenta consultar los(as) datos de %s"),
    CONSULTA_POR_NUMERO_DOCUMENTO("Se intenta consultar por Tipo de Documento los(as) datos de %s"),
    ConsultaDetalle("Se intenta consultar el Detalle de los(as) datos de %s"),
    ConsultaComisiones("Se intenta consultar las Comisiones de los(as) datos de %s"),
    ConsultaNoConciliada("Se intenta consultar las Transacciones No Conciliadas de los(as) datos de %s"),
    REGISTRO("Se intenta registrar el(a) %s %s"),
    ACTUALIZACION("Se intenta actualizar el(a) %s con los datos %s"),
    ELIMINACION("Se intenta eliminar el(a) %s %s"),
    Reporte("Se intenta generar el(a) reporte de %s"),
    VISITA("Se intenta visitar la página de %s"),
    VisitaConsulta("Se intenta visitar la página de CONSULTA de %s"),
    Ejecucion("Se intenta ejecutar el proceso de %s %s"),
    OperacionWebService("Se intenta realizar una operación mediante WS"),
    
    /*LOGIN*/
    CredencialCorrecta("El USUARIO ha accedido al sistema exitosamente"),
    CredencialIncorrecta("El USUARIO intenta acceder al sistema con credenciales incorrectas"),
    NoActivo("El usuario %s intenta acceder al sistema con una cuenta bloqueada"),
    UsuarioNoEncontrado("El USUARIO intenta acceder al sistema con un usuario no encontrado"),
    ErrorActiveDirectory("Ocurrió un error de conexión durante la autenticación del usuario con el Active Directory"),
    Logout("El usuario ha salido del sistema"),
    
    Ninguno(""), 
    ConsultaPorUsuario("Un usuario intenta consultar sus solicitudes"), 
    
    CONSULTA_POR_CRITERIOS("CONSULTA por criterios");
    
    
    private final String nombre;       

    private Comentario(String s) {
        nombre = s; 
    }

    public String toString() {
       return this.nombre;
    }  
}
