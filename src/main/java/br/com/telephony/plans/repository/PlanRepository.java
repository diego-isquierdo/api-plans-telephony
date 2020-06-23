package br.com.telephony.plans.repository;

import br.com.telephony.plans.models.Plan;
import br.com.telephony.plans.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByCarrierName(String name);
    List<Plan> findByType(Type type);
    Plan save(Plan plan);
}
