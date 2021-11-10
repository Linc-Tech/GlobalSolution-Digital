package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.exception.OngNotFoundException;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private OngRepository ongRepository;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ong> singIn(@RequestBody @Valid Ong ong) throws OngNotFoundException, AuthenticationException {
        String email = ong.getEmail();
        String password = ong.getPassword();

        Authentication auth = getAuthentication(email, password);

        Authentication authenticate = authenticationManager.authenticate(auth);

        String token = tokenService.createToken(authenticate);

        Ong ongFound = ongRepository.findByEmail(email).get();
        Ong ongToReturn = new Ong(ongFound.getCnpj(),
                ongFound.getName(),
                ongFound.getEmail(),
                ongFound.getPassword(),
                ongFound.getDescription(),
                ongFound.getOngUrl(),
                ongFound.getAddress(),                
                ongFound.getAccount(), 
                ongFound.getImage(),
                ongFound.getDonations(), token);

        return ResponseEntity.ok(ongToReturn);
    }

    private Authentication getAuthentication(String email, String password) {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}