package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.exception;


import java.sql.SQLException;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pe.edu.unmsm.commons.error.enumeration.BaseDatos;
import pe.edu.unmsm.commons.error.exception.CustomException;
import pe.edu.unmsm.commons.error.exception.RecursoNoEncontradoException;
import pe.edu.unmsm.commons.error.model.ErrorResponse;
import pe.edu.unmsm.commons.error.util.BaseDatosExcepcionUtil;
import pe.edu.unmsm.commons.error.util.ErrorResponseUtil;
import pe.edu.unmsm.commons.seguridad.backend.exception.AuthorizationException;
import pe.edu.unmsm.commons.seguridad.backend.exception.JWTVerificationException;
import pe.edu.unmsm.commons.validation.util.ValidationErrorResponseUtil;

@RestControllerAdvice
public class MantenimientoExceptionRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MantenimientoExceptionRestController.class);
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);
		return ValidationErrorResponseUtil.convertirErrorResponse(e.getBindingResult());
	}
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse onConstraintViolationException(ConstraintViolationException e) {
		logger.error(e.getMessage(), e);
		return ValidationErrorResponseUtil.convertirErrorResponse(e);
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public ErrorResponse onSqlException(SQLException e) {
		logger.error(e.getMessage(), e);
		return BaseDatosExcepcionUtil.traducirExcepcionBaseDatos(e, BaseDatos.ORACLE);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecursoNoEncontradoException.class)
	public ErrorResponse onAuthorizationException(RecursoNoEncontradoException e) {
		logger.error(e.getMessage(), e);
		return ErrorResponseUtil.convertirErrorResponse(e);
	}
	
	
}