package br.com.planos.planos.service;

import br.com.planos.planos.endpoints.dto.PlanDto;
import br.com.planos.planos.endpoints.form.PlanoForm;
import br.com.planos.planos.models.Plan;
import br.com.planos.planos.models.Type;
import br.com.planos.planos.repository.PlanRepository;
import br.com.planos.planos.service.interfaces.PlanServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanService implements PlanServiceInterface {

    private PlanRepository planRepository;

    @Override
    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    @Override
    public List<Plan> findByType(Type type) {
        return planRepository.findByType(type);
    }

    @Override
    public List<Plan> findByOperatorName(String name) {
        Plan plan = new Plan();
        planRepository.save(plan);
        return planRepository.findByOperatorName(name);
    }

    @Override
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan getOne(Long id) {
        return planRepository.getOne(id);
    }

    public void deleteById(Long id) {
        planRepository.deleteById(id);
    }
}
