package pe.edu.unmsm.sgdfd.mat.backend.boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import pe.edu.unmsm.sgdfd.mat.backend.commons.SgdfdMatCommonsBoot;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.MantenimientosBoot;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.TramiteBoot;


/**
 * Esta clase se encarga de arrancar los módulos declarados en el pom.xml.
 * <p>
 * Para realizar el arranque de los módulos, es necesario que en la anotación
 * {@code @SpringBootApplication} se declaren las clases Main de dichos módulos.
 * </p>
 *
 */
@SpringBootApplication(
		scanBasePackageClasses = {MantenimientosBoot.class,TramiteBoot.class, SgdfdMatCommonsBoot.class, SgdfdMatBoot.class})
//@EnableSwagger2
public class SgdfdMatBoot{
	
	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	*/
	public static void main(String[] args) {
		SpringApplication.run(SgdfdMatBoot.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
	}
	*/
	/**
	 * En este método se configuran la integración con distintos origenes de petición.
	 * <p>
	 * </p>
	 *
	 * @return CorsFilert con los origenes configurados
	 */
	//@ConditionalOnProperty(value = "unmsm.sgdfd.mat.backend.cors.activo", havingValue = "true")
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(
				Arrays.asList("Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	/**
	 * Permite establecer la lista de {@link ViewResolver} que serán utilizados.
	 *
	 * @param manager negociador que determina el {@code media type} solicitado en
	 *                una petición
	 * @return {@link ContentNegotiatingViewResolver}
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<>();
		resolvers.add(resourceBundleViewResolver());
		resolver.setViewResolvers(resolvers);
		return resolver;
	}
	
	/**
	 * Define un {@link ResourceBundleViewResolver} que permite el procesamiento
	 * de los templates definidos en el archivo <b>views/views.properties</b>.
	 *
	 * @return {@link ResourceBundleViewResolver}
	 */
	@Bean
	public ResourceBundleViewResolver resourceBundleViewResolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setOrder(0);
		resolver.setBasename("views/views");
		return resolver;
	}
	
	/**
	 * Configuracion para carga de archivos
	 *
	 * @return {@link CommonsMultipartResolver }
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(3L * 1024L * 1024L);    // 3MB
		return multipartResolver;
	}
	
	
//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error")))
//                .build()
//                .apiInfo(apiInfo())
//                .useDefaultResponseMessages(false)
//                .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))
//                .genericModelSubstitutes(Optional.class);
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("SGDFD-MAT API")
//                .description("Swagger Implementation")
//                .build();
//    }

	 
	 @Bean
	 public RestTemplate restTemplate() {
	     return new RestTemplate();
	 }
}
