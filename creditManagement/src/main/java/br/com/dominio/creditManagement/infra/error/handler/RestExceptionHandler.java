//package br.com.dominio.creditManagement.infra.error.handler;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.Nullable;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import br.com.dominio.creditManagement.infra.error.ResourceNotFoundDetails;
//import br.com.dominio.creditManagement.infra.error.ResourceNotFoundException;
//import br.com.dominio.creditManagement.infra.error.ValidationErrorDetails;
//
///**
// * @author iagoMagalhaes
// *Run-time error return class
// */
//@ControllerAdvice
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//	
//		@ExceptionHandler(ResourceNotFoundException.class)
//		public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnExpcetion){
//			ResourceNotFoundDetails rnfd = new ResourceNotFoundDetails("Resource not Found", 
//					HttpStatus.NOT_FOUND.value(),
//					rfnExpcetion.getMessage(), 
//					new Date().getTime(), 
//					rfnExpcetion.getClass().getName());
//			
//			return new ResponseEntity<>(rnfd,  HttpStatus.NOT_FOUND);
//		}
//		
//		@Override
//		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
//				HttpHeaders headers, HttpStatus status, WebRequest request) {
//			
//			List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
//			String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
//			String fieldsMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
//			
//			ValidationErrorDetails ved = new ValidationErrorDetails("Resource not Found", 
//					HttpStatus.NOT_FOUND.value(),
//					manvException.getMessage(), 
//					new Date().getTime(), 
//					manvException.getClass().getName(),
//					fields,
//					fieldsMessages);
//			
//			return new ResponseEntity<>(manvException, HttpStatus.BAD_REQUEST);
//		}
//		@Override
//		protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body,
//				HttpHeaders headers, HttpStatus status, WebRequest request) {
//			ResourceNotFoundDetails rnfd = new ResourceNotFoundDetails("Internal Exception", 
//					status.value(),
//					ex.getMessage(), 
//					new Date().getTime(), 
//					ex.getClass().getName());
//			
//			return new ResponseEntity<>(rnfd,  HttpStatus.NOT_FOUND);
//		}
//		
//		
//}
