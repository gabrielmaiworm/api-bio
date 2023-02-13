package br.com.biomob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.biomob.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
