package br.com.fiap.GlobalSolution.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "T_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ong implements UserDetails {
	@Id
	@Column(name = "cnpj", unique = true, length = 14)
	@NotBlank
	@Size(min = 14, max = 14)
	private String cnpj;
	
	@Column(name = "nome", nullable = false, length = 60)
	@NotBlank
	@Size(min = 2, max = 60)
	private String name;
	
	@Column(name = "email", nullable = false, length = 190)
	@NotBlank
	@Size(min = 10, max = 190)
	private String email;
	
	@Column(name = "senha", nullable = false)
	@NotBlank
	@Size(min = 15, max = 4000)
	private String password;
	
	@Column(name = "descricao", length = 250)
	@NotBlank
	@Size(min = 10, max = 250)
	private String description;
	
	@Column(name = "url_ong", length = 4000)
	@Size(min = 10, max = 4000)
	private String ongUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conta")
    private BankData account;
        
    @JsonManagedReference
    @OneToOne(mappedBy = "ong", cascade = CascadeType.ALL) 
    private Image image;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<Donation> donations;

    @Transient
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
