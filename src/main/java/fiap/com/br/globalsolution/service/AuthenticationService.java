package fiap.com.br.globalsolution.service;

import fiap.com.br.globalsolution.exception.OngNotFoundException;
import fiap.com.br.globalsolution.model.Ong;
import fiap.com.br.globalsolution.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private OngRepository ongRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Ong> ong = ongRepository.findByEmail(email);

        if (!ong.isPresent()) {
            throw new OngNotFoundException();
        }

        return ong.get();
    }

    public static PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

