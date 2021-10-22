package co.com.foo.test.memory.config.swagger;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration("swaggerConfigProperties")
@PropertySource("classpath:swagger.config.properties")
public class SwaggerConfigProperties implements Serializable {

	private static final long serialVersionUID = -1612968650411517844L;

	@Value("${api.version}")
	private String apiVersion;

	@Value("${swagger.enabled}")
	private String enabled = "false";

	@Value("${swagger.title}")
	private String title;

	@Value("${swagger.description}")
	private String description;

	@Value("${swagger.useDefaultResponseMessages}")
	private String useDefaultResponseMessages;

	@Value("${swagger.enableUrlTemplating}")
	private String enableUrlTemplating;

	@Value("${swagger.deepLinking}")
	private String deepLinking;

	@Value("${swagger.defaultModelsExpandDepth}")
	private String defaultModelsExpandDepth;

	@Value("${swagger.defaultModelExpandDepth}")
	private String defaultModelExpandDepth;

	@Value("${swagger.displayOperationId}")
	private String displayOperationId;

	@Value("${swagger.displayRequestDuration}")
	private String displayRequestDuration;

	@Value("${swagger.filter}")
	private String filter;

	@Value("${swagger.maxDisplayedTags}")
	private String maxDisplayedTags;

	@Value("${swagger.showExtensions}")
	private String showExtensions;

}
