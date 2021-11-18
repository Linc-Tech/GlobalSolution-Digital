package fiap.com.br.globalsolution.repository;


import fiap.com.br.globalsolution.model.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OngRepository extends JpaRepository<Ong, String> {
	Ong findByCnpj(String cnpj);
    Optional<Ong> findByEmail(String email);
}
