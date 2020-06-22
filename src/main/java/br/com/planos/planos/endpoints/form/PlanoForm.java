package br.com.planos.planos.endpoints.form;

import br.com.planos.planos.models.DDD;
import br.com.planos.planos.models.Operator;
import br.com.planos.planos.models.Plan;
import br.com.planos.planos.models.Type;
import br.com.planos.planos.models.converter.StringToEnumConverter;
import br.com.planos.planos.repository.DDDRepository;
import br.com.planos.planos.repository.OperatorRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanoForm {
    @NotNull
    private Long minutes;

    @NotNull
    private String franchise;

    @NotNull
    private BigDecimal value;

    @NotNull
    private String type;

    @NotNull
    private Long operatorId;

    @NotNull
    private List<Long> dddList;

    public Plan converter(
            OperatorRepository operatorRopository,
            DDDRepository dddRepository){

        Type typeEnum = new StringToEnumConverter().convert(type);
        Operator operator = operatorRopository
                                    .findById(operatorId)
                                    .orElseThrow(NullPointerException::new);
        List<DDD> ddd = new ArrayList<>();
        dddList.forEach(id->dddRepository.findById(id).ifPresent(ddd::add));

        return new Plan(minutes, franchise, value, typeEnum, operator, ddd);
    }
}
