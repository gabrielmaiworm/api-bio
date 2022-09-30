package br.com.biomob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, String> {

}
