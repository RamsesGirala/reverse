package colmentatec.reverse.controllers.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JavaControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleEmptyInput(Exception e){
        return ResponseEntity.internalServerError().body(e.getClass() +" : " + e.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> handleNullPointer(NullPointerException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

}
