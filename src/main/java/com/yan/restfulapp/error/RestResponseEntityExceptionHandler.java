package com.yan.restfulapp.error;

import com.yan.restfulapp.error.dto.ErrorMessaje;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/*
Esta clase tiene como propósito central manejar excepciones específicas en una aplicación Spring
Boot de una manera centralizada, devolviendo respuestas HTTP claras y bien definidas al cliente.
es decir, Esta anotación le dice a Spring que esta clase manejará excepciones de manera
global para todos los controladores de la aplicación.
 */

// Indica que esta clase manejará excepciones globalmente en toda la aplicación
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Este metodo se ejecutará cuando se lance una excepción del tipo LocalNotFoundException
    @ExceptionHandler(LocalNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Indica que la respuesta HTTP tendrá un código de estado 404 (NOT FOUND)
    public ResponseEntity<ErrorMessaje> localNotFoundException(LocalNotFoundException exception) {

        /*
        Esye objeto, ErrorMessaje, es un contenedor de datos para enviar
        información estructurada sobre el error al cliente.
        */
        ErrorMessaje messaje = new ErrorMessaje(HttpStatus.NOT_FOUND, exception.getMessage());
        /*
        ResponseEntity
        Es una clase de Spring que se utiliza para devolver respuestas HTTP personalizadas.
        Devuelve una respuesta HTTP con el código de estado 404 y el cuerpo del mensaje de error
        */
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
    }


    //Sobrecargamos un metodo de ResponseEntityExceptionHandler


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> errors = new HashMap<>();
        //ex.getBindingResult().getFieldErrors(): me retorna una lista de los errores
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}

