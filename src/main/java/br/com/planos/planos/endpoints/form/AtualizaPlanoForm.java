package br.com.planos.planos.endpoints.form;

import br.com.planos.planos.models.Plano;
import br.com.planos.planos.repository.PlanoRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizaPlanoForm {
    @NotNull
    private Long minutos;

    @NotNull
    private String franquia;

    @NotNull
    private BigDecimal valor;

    public Plano atualizar(Long id, PlanoRepository planoRepository){
        Plano plano = planoRepository.getOne(id);
        plano.setMinutos(this.minutos);
        plano.setFranquia(this.franquia);
        plano.setValor(this.valor);

        return plano;
    }
}
