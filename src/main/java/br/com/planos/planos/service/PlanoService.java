package br.com.planos.planos.service;

import br.com.planos.planos.models.Plano;
import br.com.planos.planos.repository.PlanoRepository;
import br.com.planos.planos.service.interfaces.PlanoServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanoService implements PlanoServiceInterface {

    private PlanoRepository planoRepository;

    @Override
    public Optional<Plano> findById(Long id) {
        return planoRepository.findById(id);
    }

    @Override
    public List<Plano> findByTipo(String tipo) {
        return null;
    }

    @Override
    public List<Plano> findByOperadoraName(String name) {
        return null;
    }
}
