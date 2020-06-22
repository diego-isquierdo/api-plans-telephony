package br.com.planos.planos.endpoints.form;

import br.com.planos.planos.models.Plan;
import br.com.planos.planos.service.PlanService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlanoForm {
    @NotNull
    private Long minutes;

    @NotNull
    private String franchise;

    @NotNull
    private BigDecimal value;

    public Plan converter(Long id, PlanService planService){
        Plan plan = planService.getOne(id);
        plan.setMinutes(this.minutes);
        plan.setFranchise(this.franchise);
        plan.setValue(this.value);

        return plan;
    }
}
