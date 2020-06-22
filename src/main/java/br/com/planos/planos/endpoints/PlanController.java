package br.com.planos.planos.endpoints;


import br.com.planos.planos.endpoints.dto.PlanDto;
import br.com.planos.planos.endpoints.form.UpdatePlanoForm;
import br.com.planos.planos.endpoints.form.PlanoForm;
import br.com.planos.planos.models.Plan;
import br.com.planos.planos.models.converter.StringToEnumConverter;
import br.com.planos.planos.repository.DDDRepository;
import br.com.planos.planos.repository.OperatorRepository;
import br.com.planos.planos.service.PlanService;
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
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private DDDRepository dddRepository;


    @GetMapping("/{id}")
    public ResponseEntity<PlanDto> findById(@PathVariable Long id){
        Optional<Plan> plano = planService.findById(id);
        return ResponseEntity.ok(new PlanDto(plano.get()));
    }


    @GetMapping
    public ResponseEntity<Set<PlanDto>> findByTypeOrOperator(
        @RequestParam(required = false) String operator,
        @RequestParam(required = false) String type
        //@RequestParam Long ddd
    ){
        Set<Plan> plans = new HashSet<>();

        if(operator!=null) plans.addAll(planService.findByOperatorName(operator));
        if(type!=null) plans.addAll(planService.findByType(new StringToEnumConverter().convert(type)));

        return new ResponseEntity<>(PlanDto.converter(plans), HttpStatus.OK);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<PlanDto> register(@RequestBody PlanoForm form, UriComponentsBuilder uriBuilder){
        Plan plan = planService.save(form.converter(operatorRepository, dddRepository));

        URI uri = uriBuilder.path("/plan/{id}").buildAndExpand(plan.getId()).toUri();

        return  ResponseEntity.created(uri).body(new PlanDto(plan));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PlanDto> update(@PathVariable Long id, @RequestBody UpdatePlanoForm form){
        if(planService.findById(id).isPresent()){
            Plan plan = form.converter(id, planService);
            return ResponseEntity.ok(new PlanDto(plan));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id){
        if(planService.findById(id).isPresent()){
            planService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
