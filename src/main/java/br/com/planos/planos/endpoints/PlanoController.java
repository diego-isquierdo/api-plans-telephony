package br.com.planos.planos.endpoints;


import br.com.planos.planos.endpoints.dto.PlanoDto;
import br.com.planos.planos.endpoints.form.PlanoForm;
import br.com.planos.planos.models.Plano;
import br.com.planos.planos.models.converter.StringToEnumConverter;
import br.com.planos.planos.repository.DDDRepository;
import br.com.planos.planos.repository.OperadoraRepository;
import br.com.planos.planos.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private OperadoraRepository operadoraRepository;

    @Autowired
    private DDDRepository dddRepository;


    @GetMapping("/{id}")
    public ResponseEntity<PlanoDto> findById(@PathVariable Long id){
        Optional<Plano> plano = planoRepository.findById(id);
        return ResponseEntity.ok(new PlanoDto(plano.get()));
    }


    @GetMapping
    public ResponseEntity<Set<PlanoDto>> findByTipoOrOperadora(
        @RequestParam(required = false) String operadora,
        @RequestParam(required = false) String tipo
        //@RequestParam Long ddd
    ){
        Set<Plano> planos = new HashSet<>();

        if(operadora!=null) planos.addAll(planoRepository.findByOperadoraName(operadora));
        if(tipo!=null) planos.addAll(planoRepository.findByTipo(new StringToEnumConverter().convert(tipo)));

        return new ResponseEntity<>(PlanoDto.converter(planos), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Plano> cadastrar(@RequestBody PlanoForm form, UriComponentsBuilder uriBuilder){
        Plano plano = form.converter(operadoraRepository, dddRepository);
        planoRepository.save(plano);
        URI uri = uriBuilder.path("/plano/{id}").buildAndExpand(plano.getId()).toUri();

        return  ResponseEntity.created(uri).body(plano);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        if(planoRepository.findById(id).isPresent()){
            planoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }



}
