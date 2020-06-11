package br.com.planos.planos.repository;

import br.com.planos.planos.models.Plano;
import br.com.planos.planos.models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
    List<Plano> findByOperadoraName(String name);
    List<Plano> findByTipo(Tipo tipo);
}
