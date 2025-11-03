package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
