package co.com.foo.test.memory.config.logs;

import java.io.IOException;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.google.gson.Gson;

/**
 * Clase interceptora que genera logs de los request body
 *
 * @author Germán Alejandro Casallas Guarnizo
 */
@ControllerAdvice
public class RequestLogger implements RequestBodyAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogger.class);

	private Gson gson = new Gson();

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		return inputMessage;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		var jsonString = gson.toJson(body);
		LOGGER.info("REQUEST: {}", jsonString);
		return body;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

		LOGGER.info("REQUEST: No se detecta body");
		return body;
	}
}
