package br.com.planos.planos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "DDD_PLANO",
            joinColumns = {@JoinColumn(name="PLANO_ID")},
            inverseJoinColumns = {@JoinColumn(name = "DDD_CODIGO")})
    private List<DDD> ddd;

    public Plano(Long minutos,
                 String franquia,
                 BigDecimal valor,
                 Tipo tipo,
                 Operadora operadora,
                 List<DDD> ddd) {
        this.minutos = minutos;
        this.franquia = franquia;
        this.valor = valor;
        this.tipo = tipo;
        this.operadora = operadora;
        this.ddd = ddd;
    }
}
