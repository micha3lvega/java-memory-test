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
public class CallDatabaseExceptionHandler {

	@Autowired
	private Tracer tracer;

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handlerException(Throwable ex) {

		var error = new ResponseDto();

		error.setData(null);
		error.setMessageCode("ERROR-SI");
		error.setTransactionDate(new Date());
		error.setMessage("Error en las fuentes de información");
		error.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
