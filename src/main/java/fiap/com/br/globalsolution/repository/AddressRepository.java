package fiap.com.br.globalsolution.repository;

import fiap.com.br.globalsolution.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository  extends JpaRepository<Address, Integer> {

}
