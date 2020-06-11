package br.com.planos.planos.endpoints;


import br.com.planos.planos.models.Plano;
import br.com.planos.planos.service.interfaces.PlanoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoServiceInterface planoService;

    @GetMapping("/{id}")
    public ResponseEntity<Plano> findById(@PathVariable Long id){
        return new ResponseEntity<>(planoService.findById(id).get(), HttpStatus.OK);
    }
}
