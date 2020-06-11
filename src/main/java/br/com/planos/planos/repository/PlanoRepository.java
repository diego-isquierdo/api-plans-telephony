package br.com.planos.planos.repository;

import br.com.planos.planos.models.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
