package br.com.planos.planos.service.interfaces;

import br.com.planos.planos.endpoints.dto.PlanDto;
import br.com.planos.planos.endpoints.form.PlanoForm;
import br.com.planos.planos.models.Plan;
import br.com.planos.planos.models.Type;

import java.util.List;
import java.util.Optional;

public interface PlanServiceInterface extends ServiceInterface<Plan> {
    Optional<Plan> findById(Long id);

    List<Plan> findByType(Type type);

    List<Plan> findByOperatorName(String name);

    Plan save(Plan plan);
}
