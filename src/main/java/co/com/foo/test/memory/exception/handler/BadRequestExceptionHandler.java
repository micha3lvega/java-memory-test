package co.com.foo.test.memory.exception.handler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import brave.Tracer;
import co.com.foo.test.memory.dto.ResponseDto;

@ControllerAdvice
public class BadRequestExceptionHandler {

	@Autowired
	private Tracer tracer;

	@ExceptionHandler
	public ResponseEntity<ResponseDto> exceptionHandler(Throwable ex) {

		var error = new ResponseDto();

		error.setData(null);
		error.setMessageCode("ERROR-I");
		error.setMessage(ex.getMessage());
		error.setTransactionDate(new Date());
		error.setResponseCode(HttpStatus.BAD_REQUEST);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		// Agregar error
		if (ex.getCause() != null && ex.getCause().getLocalizedMessage() != null) {
			error.setMessage(ex.getCause().getMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}
}
