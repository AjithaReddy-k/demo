package com.counselling.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptions  {
//	@ExceptionHandler(ResourceNotFoundException.class)
//
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//
//			WebRequest webRequest) {
//
//		ErrorDetails errorDetails = new ErrorDetails(new Date(0), exception.getMessage(),
//
//				webRequest.getDescription(false));
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//
//	}
//
//	@ExceptionHandler(AppApiExceptions.class)
//
//	public ResponseEntity<ErrorDetails> handleBlogAPIException(AppApiExceptions exception,
//
//			WebRequest webRequest) {
//
//		ErrorDetails errorDetails = new ErrorDetails(new Date(0), exception.getMessage(),
//
//				webRequest.getDescription(false));
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//
//	}
//
//	// global exceptions
//
//	@ExceptionHandler(Exception.class)
//
//	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
//
//			WebRequest webRequest) {
//
//		ErrorDetails errorDetails = new ErrorDetails(new Date(0), exception.getMessage(),
//
//				webRequest.getDescription(false));
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}
////@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//
//			HttpHeaders headers,
//
//			HttpStatus  status,
//
//			WebRequest request) {
//
//		Map<String, String> errors = new HashMap<>();
//
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//
//			String fieldName = ((FieldError) error).getField();
//
//			String message = error.getDefaultMessage();
//
//			errors.put(fieldName, message);
//
//		});
//
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//
//	}
//
////    @ExceptionHandler(MethodArgumentNotValidException.class)
//
////    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
//
////                                                                        WebRequest webRequest){
//
////        Map<String, String> errors = new HashMap<>();
//
////        exception.getBindingResult().getAllErrors().forEach((error) ->{
//
////            String fieldName = ((FieldError)error).getField();
//
////            String message = error.getDefaultMessage();
//
////            errors.put(fieldName, message);
//
////        });
//
////        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//
////    }
//
//	@ExceptionHandler(AccessDeniedException.class)
//
//	public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException exception,
//
//			WebRequest webRequest) {
//
//		ErrorDetails errorDetails = new ErrorDetails(new Date(0), exception.getMessage(),
//
//				webRequest.getDescription(false));
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
//
//	}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
public ResponseEntity<String >globalEntity(Exception exception){
		
		
		return new  ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
	
}	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Validation error: " + ex.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

}
