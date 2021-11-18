package fiap.com.br.globalsolution.repository;

import fiap.com.br.globalsolution.model.Donator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonatorRepository extends JpaRepository<Donator, String> {

}
