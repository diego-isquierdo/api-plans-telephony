package br.com.telephony.plans.mappers;

import br.com.telephony.plans.endpoints.dto.PlanDto;
import br.com.telephony.plans.models.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PlanMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "minutes", target = "minutes"),
            @Mapping(source = "franchise", target = "franchise"),
            @Mapping(source = "value", target = "value")
    })
    PlanDto map(Plan plan);
    Page<PlanDto> map(Page<Plan> plans);
}
