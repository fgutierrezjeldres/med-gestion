package cl.desarrollo.medgestion.exception;


import jakarta.persistence.Entity;
import org.apache.catalina.WebResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice //esto hace que tome cualquier error y lo maneje en la estructura de la excepcion customizada
public class ResponseExceptionHandler {

    //para cualquier excepcion que se quiera manejar se agrega a esta clase

/*
    //esta funcion funciona desde spring 2.7 hacia atras
    @ExceptionHandler(ModelNotFoundException.class) // defino la estructura de la clase a usar
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);//aca se define la etiqueta
    }*/
    //esta funcion funciona desde spring boot 3
    @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Model not Found");
        problemDetail.setType(URI.create("/not-found"));
        problemDetail.setProperty("extra", "extra-value");//esto agrega valores que no estan definidos
        return problemDetail;
    }
    //esta funcion funciona desde spring boot 3
   /* public ErrorResponse handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage())
                .title("Model not Found")
                .type(URI.create(request.getContextPath()))
                .property("extra 1", "value-1")
                .property("extra2", 32)
                .build();
    }*/




}
