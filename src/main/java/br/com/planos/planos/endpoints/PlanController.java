package br.com.planos.planos.endpoints;


import br.com.planos.planos.endpoints.dto.PlanDto;
import br.com.planos.planos.endpoints.form.UpdatePlanForm;
import br.com.planos.planos.endpoints.form.PlanForm;
import br.com.planos.planos.models.Plan;
import br.com.planos.planos.models.converter.StringToEnumConverter;
import br.com.planos.planos.repository.DDDRepository;
import br.com.planos.planos.repository.OperatorRepository;
import br.com.planos.planos.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

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
    public Page<PlanDto> list(
            @RequestParam(required = false) String operator,
            @RequestParam(required = false) String type,
            @PageableDefault(size = 2)Pageable pageable
    ){

        if(operator!=null) {
            Page<Plan> plans = new PageImpl<Plan>(planService.findByOperatorName(operator));
            return PlanDto.converter(plans);
        }
        if(type!=null) {
            Page<Plan> plans = new PageImpl<>(planService.findByType(new StringToEnumConverter().convert(type)));
            return PlanDto.converter(plans);
        }

        return PlanDto.converter(planService.findAll(pageable));
    }


    @PostMapping
    @Transactional
    public ResponseEntity<PlanDto> register(@RequestBody @Valid PlanForm form, UriComponentsBuilder uriBuilder){
        Plan plan = planService.save(form.converter(operatorRepository, dddRepository));
        URI uri = uriBuilder.path("/plan/{id}").buildAndExpand(plan.getId()).toUri();
        return  ResponseEntity.created(uri).body(new PlanDto(plan));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PlanDto> update(@PathVariable Long id, @RequestBody @Valid UpdatePlanForm form){
        if(planService.findById(id).isPresent()){
            Plan plan = form.converter(id, planService);
            return new ResponseEntity<>(new PlanDto(plan), HttpStatus.OK);
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