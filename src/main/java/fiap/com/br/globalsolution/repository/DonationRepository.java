package fiap.com.br.globalsolution.repository;

import fiap.com.br.globalsolution.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer>{
	
	List<Donation> findDonationByOngCnpj(String cnpj);
}
