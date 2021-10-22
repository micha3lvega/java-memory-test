package co.com.foo.test.memory.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "Response")
public class ResponseDto implements Serializable {

	private String message;
	private String messageCode;
	private String transactionId;
	private Date transactionDate;
	private HttpStatus responseCode;

	private Object data;

	public ResponseDto() {
	}

	public ResponseDto(HttpStatus responseCode, String message, Object data, String transactionId) {
		this.responseCode = responseCode;
		this.message = message;
		this.data = data;
		this.transactionId = transactionId;
	}

	public ResponseDto(String message, String transactionId, Date transactionDate, HttpStatus responseCode, Object data) {
		this.message = message;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.responseCode = responseCode;
		this.data = data;
	}

}
