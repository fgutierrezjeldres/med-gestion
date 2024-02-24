package cl.desarrollo.medgestion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND) //esta etiqueta permite que la exepcion  se muestre en la respuesta http
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message){
        super(message);
    }
}
