package br.com.telephony.plans.service.interfaces;
import br.com.telephony.plans.models.Plan;
import br.com.telephony.plans.models.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PlanServiceInterface extends ServiceInterface<Plan> {
    Optional<Plan> findById(Long id);

    List<Plan> findByType(Type type);

    List<Plan> findByCarrierName(String name);

    Plan save(Plan plan);

    Page<Plan> findAll(Pageable pageable);
}
