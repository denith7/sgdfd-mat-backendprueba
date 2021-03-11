package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion;

public enum Tipo {

	/*Mantenimiento*/
    AMBIENTE("Ambiente"),
    HORARIO("Horario"),
    CONTRATO("contrato"),
    UBICACION("Ubicación"),
    RECURSO("Recurso"),
    CATEGORIA_SERVICIO("Categoria Servicio"),
    CATEGORIA_RECURSO("Tipo recurso"),
    ADMINISTRATIVO("Administrativo"),
    PERSONA("Persona"),
    DOCENTE("Docente"),
    EXTERNO("Externo"),
    ALUMNO("Alumno"),
    FACULTAD("Facultad"),
    ESCUELA_PROFESIONAL("EscuelaProfesional"),
    MATERIAL("Material"),
    MULTI_TAB_CAB("Tabla de tablas"),
    MULTI_TAB_DET("Detalle de tabla de tablas"),
    INFRACCION("Infraccion"),
    PRESTAMO("Prestamo"),
    PRESTAMO_DETALLE("Detalle de prestamo"),
    SOLICITANTE("Solicitantes"),
    INSUMO("Insumo"),
    
    
    
    PERMISO("Permiso"),
    ROL("Rol"),
    SUPERVISOR("Supervisor"),
    TIPOAMBIENTE("Tipo Ambiente"),
    TRATAMIENTO("Tratamiento"),
    TURNO("Turno"),
    UBIGEO("Ubigeo"),
    OPERADOR("Operador"),
   
    ASISTENCIA(""),
    PROCEDIMIENTO("procedimiento"),
    PROCEDIMIENTO_INSUMO("procedimiento insumo"),
    PROGRAMACION_CURSOS("programacion cursos"),
    SERVICIO("servicio"),
    
    /*Módulo Almacen*/
    ABASTECIMIENTO("Abastecimiento"),
    ABASTECIMIENTO_INSUMO("Insumo Abastecimiento"),
    
    /*LOGIN*/
    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
    
    /*Seguridad*/
    Perfil("Perfil"),
    Recurso(""),
    USUARIO("USUARIO"),
    CATEGORIARECURSO("Categoria Recurso"),
    
    ENTREGA_INSUMOS_OPERADOR("Entrega de insumos al operador"),
    ENTREGA_INSUMOS_AMBIENTE("Entrega de insumos al ambiente"),
    
    /*Pacientes*/
    ASIGNACION("Asignación"),
    HISTORIA_CLINICA("Historia Clínica"),
    PACIENTE("Paciente"),
    
    
    /*Módulo Sistema*/
    AREA_TRABAJO("Área de Trabajo"),
    ESTADO_TABLA("Estado de Tablas"),
    LOCAL("Local"),
    OFICINA("Oficina"),
    PARAMETRO_SISTEMA("Parámetro de Sistema"),
    
    /*Movimientos*/
    INSUMO_EXISTENCIA("Insumo Existencia"),
    COMPROBANTE("Comprobante"),
    CITA("Cita"),
    CITA_SERVICIO("Cita Servicio"),
    COMPROBANTE_DETALLE("Comprobante Detalle"),
    NINGUNO(""), 
    
	/*Servicio Web*/
	RENIEC("Consulta RENIEC");
    
    private final String nombre;

    private Tipo(String nombre)
    {
        this.nombre = nombre;
    }
 
    public String toString()
    {
        return this.nombre;
    }
}
