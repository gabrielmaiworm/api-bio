package br.com.biomob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.Emprego;

public interface EmpregoRepository extends JpaRepository<Emprego, String> {

}
