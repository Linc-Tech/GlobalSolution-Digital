package fiap.com.br.globalsolution.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "T_DOACOES_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="doacoes", sequenceName = "SQ_TB_DOACOES_ONG", allocationSize = 1)
public class Donation {

    @Id
    @Column(name="id_doacao", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doacoes")
    private int id;

    @Column(name="valor", nullable = false)
    @NotBlank(message ="O valor não pode ser vazio.")
    private float value;

    @Column(name="confirmacao", nullable = false)
    private boolean confirmation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ong_cnpj")
    private Ong ong;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="id_donator")
    private Donator donator;

    public boolean getConfirmation() {
        return confirmation;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", value=" + value +
                ", confirmation=" + confirmation +
                ", ong=" + ong +
                ", donator=" + donator +
                '}';
    }
}