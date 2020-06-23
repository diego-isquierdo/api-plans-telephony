package br.com.planos.planos.endpoints.form;

import br.com.planos.planos.models.Plan;
import br.com.planos.planos.service.PlanService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlanForm {

    @PositiveOrZero(message = "Enter only zero or positives")
    @NotNull(message = "inform the minutes")
    private Long minutes;

    @Length(min = 3)
    @NotBlank(message = "necessary to inform franchise")
    private String franchise;

    @NotNull
    @PositiveOrZero(message = "Enter only zero or positives")
    private BigDecimal value;

    public Plan converter(Long id, PlanService planService){
        Plan plan = planService.getOne(id);
        plan.setMinutes(this.minutes);
        plan.setFranchise(this.franchise);
        plan.setValue(this.value);

        return plan;
    }
}
