package demo.persona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class Persona{

    private String nombre;
    private int edad;

    public void cantar(){
        if(true){
            for (int i = 0; i++; i>5) {

            }
        }else{
            if(false){

            }
            if(true){

            }else{

            }
        }
    }

    public void saltar(int x){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findALL());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        } catch (IOException ioException){
            return "S";
        }
        if(x < 5){
            System.out.println("Salte muy poco");
            if(true){

            }
        }
        switch (x){
            case 1: i++;
                switch (j){
                    case 3: i--;
                        break;
                    default: i++;
                        break;
                }
                break;
            case 2: i--;
                break;
            default: i++;
                break;
        }
    }

}