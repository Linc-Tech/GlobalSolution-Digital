package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.GlobalSolution.model.Ong;
import java.util.Optional;
    
public interface OngRepository extends JpaRepository<Ong, String>{
	Ong findByCnpj(String cnpj);
	Ong findByCnpjAndEmail(String cnpj, String email);
    Optional<Ong> findByEmail(String email);

}
