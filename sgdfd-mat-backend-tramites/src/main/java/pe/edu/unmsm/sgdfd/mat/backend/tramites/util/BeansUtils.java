package pe.edu.unmsm.sgdfd.mat.backend.tramites.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeansUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(BeansUtils.class);
	
	private BeansUtils() {	
		throw new UnsupportedOperationException();
	}
	
	public static <T> T setFieldsFromMap(Class<T> clazz, Map<String, Object> props) {
		T obj = null;
		try {
			obj = clazz.getDeclaredConstructor().newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for(int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				fields[i].setAccessible(true);
				fields[i].set(obj, props.get(fieldName));
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			logger.error("Error al asignar valor a un atributo de la clase {}", clazz.getName());
			// debe lanzar una excepcion y no continuar con procesamiento, es bad request 
		}
		return obj;
	}
}
