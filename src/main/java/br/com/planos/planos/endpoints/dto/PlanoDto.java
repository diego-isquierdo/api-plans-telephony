package br.com.planos.planos.endpoints.dto;


import br.com.planos.planos.models.Plano;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class PlanoDto {

    private Long id;
    private Long minutos;
    private String franquia;
    private BigDecimal valor;

    public PlanoDto(Plano plano){
        this.id = plano.getId();
        this.minutos = plano.getMinutos();
        this.franquia = plano.getFranquia();
        this.valor = plano.getValor();
    }

    public static Set<PlanoDto> converter(Set<Plano> planos){
        return planos.stream().map(PlanoDto::new).collect(Collectors.toSet());
    }

}
