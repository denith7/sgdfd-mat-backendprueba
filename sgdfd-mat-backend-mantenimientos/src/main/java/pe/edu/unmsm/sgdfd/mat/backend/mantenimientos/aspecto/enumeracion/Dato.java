package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion;

public enum Dato {

	/*Módulo Académico*/
    FACULTAD(""),
    ESCUELA_PROFESIONAL("  Escuela_Profesional = #escuela.idEscuela"
    		          + ", Nombre              = #escuela.nombre"),
    
	PROGRAMACION_CURSOS(""),
    
	
    /*Módulo Almacén*/
    INSUMO(""),
    ABASTECIMIENTO_INSUMO(""),
    
    ABASTECIMIENTO("  Id_Abastecimiento    = #idAbastecimiento "
    		     + ", Descripcion          = #descripcion"
    		     + ", Fecha_Abastecimiento = #fechaAbastecimiento"
    		     + ", Estado 			   = #estado"),
    
    INSUMO_EXISTENCIA(""),
    ENTREGA_INSUMOS_AMBIENTE(""),
    
    /*Módulo Horarios*/
    AMBIENTE(""),
    HORARIO_AMBIENTE(""),
    HORARIO(""),
    HORARIO_OPERADOR(""),
    TIPO_AMBIENTE(""),
    TURNO(""),
    
    /*Módulo Asistencia*/
    ASISTENCIA(""),
  
    /*Módulo Citas*/
    CITA(""),
    CITA_SERVICIO(""),
    
    /*Módulo Clinicas*/
    ASIENTO_DENTAL(""),
    ENTREGA_INSUMOS_OPERADOR(""),
    ESTADO_CLINICA(""),
    PAPELETA(""),
    
    /*Módulo Pacientes*/
    ASIGNACION(""),  
    HISTORIA_CLINICA("Historia Clínica"),
    PACIENTE("Paciente"),
    /*Módulo Personal*/
    ADMINISTRATIVO(""),
    OPERADOR(""),
    PERSONA(""),
    SUPERVISOR(""),
    
    /*Módulo Reportes*/
    REPORTE_ASISTENCIA(""),
    REPORTE_CITAS(""),
    REPORTE_INDICADORES_POR_CLINICA(""),
    REPORTE_INDICADORES_POR_OPERADOR(""),
       
    /*Módulo Seguridad*/
    CATEGORIA_RECURSO(""),
    PERMISO(""),
    RECURSO(""),
    ROL(""),
    USUARIO(""),
    
    /*Módulo Servicios Odontológicos*/
    CATEGORIA_SERVICIO(""),
    COMPROBANTE(""),
    COMPROBANTE_DETALLE(""),
    CONTRATO(""),
    PROCEDIMIENTO(""),
    PROCEDIMIENTO_INSUMO(""),
    SERVICIO(""),
    TRATAMIENTO(""),
    
    /*Módulo Sistema*/
    AREA_TRABAJO(""),
    ESTADO_TABLA(""),
    LOCAL(""),
    MULTI_TAB_CAB(""),
    MULTI_TAB_DET(""),
    PARAMETRO_SISTEMA(""),
    UBIGEO(""),
    RENIEC(""),
    
    
    NINGUNO("");
    
	private final String nombre;

    private Dato(String nombre)
    {
        this.nombre = nombre;
    }

    public String toString()
    {
        return this.nombre;
    } 
}
