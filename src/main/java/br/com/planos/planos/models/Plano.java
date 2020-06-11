package br.com.planos.planos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Plano {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long minutos;

    @NotNull
    private String franquia;

    @NotNull
    private BigDecimal valor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @JsonIgnore
    @ManyToOne
    private Operadora operadora;

    @JsonIgnore
    @ManyToMany
    private List<DDD> ddd;

}
