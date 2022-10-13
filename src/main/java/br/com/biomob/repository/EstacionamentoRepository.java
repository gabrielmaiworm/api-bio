package br.com.biomob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, String> {

}
