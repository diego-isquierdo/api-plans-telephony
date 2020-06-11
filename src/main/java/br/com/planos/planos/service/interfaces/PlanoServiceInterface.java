package br.com.planos.planos.service.interfaces;

import br.com.planos.planos.models.Plano;

import java.util.List;
import java.util.Optional;

public interface PlanoServiceInterface extends ServiceInterface<Plano> {
    Optional<Plano> findById(Long id);

    List<Plano> findByTipo(String tipo);

    List<Plano> findByOperadoraName(String name);

}
