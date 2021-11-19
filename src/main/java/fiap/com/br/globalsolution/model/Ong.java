package fiap.com.br.globalsolution.model;


import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Entity(name = "T_ONG")
@Data
public class Ong implements UserDetails {
    @Id
    @Column(name = "cnpj", unique = true, length = 14)
    @NotBlank(message = "O campo CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "CNPJ inválido")
    private String cnpj;

    @Column(name = "nome", nullable = false, length = 60)
    @NotBlank(message = "Este campo é obrigatório ")
    @Size(min= 2, max = 60, message = "O campo precisa ter entra 2 caracteres a 60 caracteres")
    private String name;

    @Column(name = "email", nullable = false, length = 190)
    @NotBlank(message = "O campo E-mail é obrigatório")
    @Email
    @Min(value = 10, message = "O campo precisa ter ao menos 10 caracteres")
    @Max(value = 190, message = "O campo não pode ultrapassar 190 caracteres")
    private String email;

    @Column(name = "senha", nullable = false)
    @NotBlank(message = "O campo Senha é obrigatório")
    @Min(value = 15, message = "O campo precisa ter ao menos 2 caracteres")
    private String password;

    @Column(name = "descricao", length = 250)
    @NotBlank(message = "O campo de apresentação é obrigatório")
    @Min(value = 10, message = "O campo precisa ter ao menos 10 caracteres")
    @Max(value = 250, message = "O campo não pode ultrapassar 250 caracteres")
    private String description;

    @Column(name = "url_ong", length = 4000)
    @Size(min = 10, max = 4000, message = "O valor minímo de caracteres é 10")     
    private String ongUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    @NotBlank
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conta")
    @NotBlank
    private BankData account;

    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<Donation> donations;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @Transient
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
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

    @Override
    public String toString() {
        return "Ong{" +
                "cnpj='" + cnpj + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", ongUrl='" + ongUrl + '\'' +
                ", address=" + address +
                ", account=" + account +
                ", donations=" + donations +
                ", roles=" + roles +
                ", token='" + token + '\'' +
                '}';
    }
}

