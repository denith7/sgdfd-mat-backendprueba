package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.anotacion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Accion;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Comentario;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Dato;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Tipo;


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Audit {

	Accion accion() default Accion.Ninguna;

    Comentario comentario() default Comentario.Ninguno;

    Tipo tipo() default Tipo.NINGUNO;

    Dato datos() default Dato.NINGUNO;
}
