package fiap.com.br.globalsolution.repository;

import fiap.com.br.globalsolution.model.BankData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDataRepositoy extends JpaRepository<BankData, Integer> {

}
