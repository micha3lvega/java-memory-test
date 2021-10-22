package co.com.foo.test.memory.config.logs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configura interceptor HTTP
 * 
 * @author Germán Alejandro Casallas Guarnizo
 */
@Configuration
public class HttpInterceptorConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpInterceptor());
	}
}