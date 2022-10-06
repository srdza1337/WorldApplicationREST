package task.world_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import task.world_test.dto.ErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StateCodeNotFoundException.class)
	public ResponseEntity<ErrorDTO> handleStateCodeNotFoundException(final StateCodeNotFoundException ex){
		return new ResponseEntity<ErrorDTO>(ErrorDTO.builder()
				.withTitle("Invalid stateCode")
				.withDetail(ex.getMessage())
				.withStatus(HttpStatus.NOT_FOUND.value())
				.withErrorType(StateCodeNotFoundException.class.getSimpleName())
				.withErrorCode("404")
				.build(),
				HttpStatus.NOT_FOUND);
	}
}
