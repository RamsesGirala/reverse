package colmentatec.reverse.controllers.rest;

import colmentatec.reverse.services.JavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaController {


    @Autowired
    JavaService javaService;

    @Value("${java.project.path}")
    private String java_project_path;

    @GetMapping("/analizar")
    public ResponseEntity<String> analizar(){
        javaService.analizarCodigoFromPath(java_project_path);
        return ResponseEntity.ok().body("Todo OK");
    }

}
