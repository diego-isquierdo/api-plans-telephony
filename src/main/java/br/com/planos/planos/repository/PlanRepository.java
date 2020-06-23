package br.com.planos.planos.repository;

import br.com.planos.planos.models.Plan;
import br.com.planos.planos.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByOperatorName(String name);
    List<Plan> findByType(Type type);
    Plan save(Plan plan);
}
