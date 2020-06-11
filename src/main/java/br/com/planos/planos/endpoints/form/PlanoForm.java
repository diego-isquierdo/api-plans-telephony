package br.com.planos.planos.endpoints.form;

import br.com.planos.planos.models.DDD;
import br.com.planos.planos.models.Operadora;
import br.com.planos.planos.models.Plano;
import br.com.planos.planos.models.Tipo;
import br.com.planos.planos.models.converter.StringToEnumConverter;
import br.com.planos.planos.repository.DDDRepository;
import br.com.planos.planos.repository.OperadoraRepository;
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
    private Long minutos;

    @NotNull
    private String franquia;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private String tipo;

    @NotNull
    private Long operadoraId;

    @NotNull
    private List<Long> dddList;

    public Plano converter(
            OperadoraRepository operadoraRopository,
            DDDRepository dddRepository){

        Tipo tipoEnum = new StringToEnumConverter().convert(tipo);
        Operadora operadora = operadoraRopository
                                    .findById(operadoraId)
                                    .orElseThrow(NullPointerException::new);
        List<DDD> ddd = new ArrayList<>();
        dddList.forEach(id->dddRepository.findById(id).ifPresent(ddd::add));

        return new Plano(minutos, franquia,valor,tipoEnum, operadora, ddd);
    }
}
