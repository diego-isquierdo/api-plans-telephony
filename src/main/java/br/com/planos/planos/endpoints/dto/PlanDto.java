package br.com.planos.planos.endpoints.dto;


import br.com.planos.planos.models.Plan;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class PlanDto {
    public PlanDto(Plan plan){
        this.id = plan.getId();
        this.minutes = plan.getMinutes();
        this.franchise = plan.getFranchise();
        this.value = plan.getValue();
    }

    private Long id;
    private Long minutes;
    private String franchise;
    private BigDecimal value;

    public static Page<PlanDto> converter(Page<Plan> plans){
        return plans.map(PlanDto::new);
    }

}
