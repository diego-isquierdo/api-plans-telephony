package br.com.planos.planos.repository;

import br.com.planos.planos.models.DDD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DDDRepository extends JpaRepository<DDD, Long> {
}