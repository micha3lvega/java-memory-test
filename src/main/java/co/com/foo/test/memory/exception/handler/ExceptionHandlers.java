package co.com.foo.test.memory.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import brave.Tracer;
import co.com.foo.test.memory.dto.ResponseDto;

@ControllerAdvice
public class ExceptionHandlers {

	@Autowired
	private Tracer tracer;

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handlerException(MissingRequestHeaderException ex) {
		ResponseDto error = new ResponseDto(HttpStatus.BAD_REQUEST,
				String.format("Header requerido no especificado, por favor verificar: %s", ex.getMessage()), null,
				tracer.currentSpan().context().traceIdString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handlerException(MissingServletRequestParameterException ex) {
		ResponseDto error = new ResponseDto(HttpStatus.BAD_REQUEST,
				String.format("Parámetro requerido no especificado, por favor verificar: %s", ex.getMessage()), null,
				tracer.currentSpan().context().traceIdString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handlerException(MethodArgumentNotValidException ex) {
		ResponseDto error = new ResponseDto(HttpStatus.BAD_REQUEST,
				String.format("Cuerpo de la petición con formato incorrecto, por favor verificar: %s", ex.getMessage()), null,
				tracer.currentSpan().context().traceIdString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handlerException(MethodArgumentTypeMismatchException ex) {
		ResponseDto error = new ResponseDto(HttpStatus.BAD_REQUEST,
				String.format("Parámetro con formato incorrecto, por favor verificar: %s", ex.getMessage()), null,
				tracer.currentSpan().context().traceIdString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handlerException(HttpMessageNotReadableException ex) {
		ResponseDto error = new ResponseDto(HttpStatus.BAD_REQUEST,
				String.format("Cuerpo de la petición con formato incorrecto, por favor verificar: %s", ex.getMessage()), null,
				tracer.currentSpan().context().traceIdString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
