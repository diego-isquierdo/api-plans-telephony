package br.com.telephony.plans.service;


import br.com.telephony.plans.models.Plan;
import br.com.telephony.plans.models.Type;
import br.com.telephony.plans.repository.PlanRepository;
import br.com.telephony.plans.service.interfaces.PlanServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Plan> findByCarrierName(String name) {
        return planRepository.findByCarrierName(name);
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

    public Page<Plan> findAll(Pageable pageable) { return planRepository.findAll(pageable); }
}
