package br.com.planos.planos.repository;

import br.com.planos.planos.models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {
}
