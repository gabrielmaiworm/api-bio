package br.com.biomob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.AvaliacaoEstacionamento;

public interface AvaliacaoEstacionamentoRepository extends JpaRepository<AvaliacaoEstacionamento, String> {

	List<AvaliacaoEstacionamento> findByEstacionamentoId(String estacionamentoId);

	List<AvaliacaoEstacionamento> findByUserId(String userId);

}
