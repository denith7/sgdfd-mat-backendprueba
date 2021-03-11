package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import java.util.Date;

import lombok.Data;

@Data
public class ReniecResponse {

	private String codigoError;
	private String message;
	private String apellidoPrimero;
	private String apellidoPaterno;
	private String apellidoSegundo;
	private String apellidoMaterno;
	private String nombres;
	private String estadoCivil;
	private String genero;
	private String codigoDepartamentoNacimiento;
	private String codigoProvinciaNacimiento;
	private String codigoDistritoNacimiento;
	private String nombreDepartamentoNacimiento;
	private String nombreProvinciaNacimiento;
	private String nombreDistritoNacimiento;
	private String fechaNacimiento;
	private String fechaCaducidad;
	
	private String fechaNacimientoTexto;

	private Date fechaNacimientoProcesada;
	private Date fechaCaducidadProcesada;
	
}
