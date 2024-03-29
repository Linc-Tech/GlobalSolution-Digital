package fiap.com.br.globalsolution.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "T_DOADOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="doador", sequenceName = "SQ_T_DOADOR", allocationSize = 1)
public class Donator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doador")
    @Column(name = "id_doador", unique = true)
    private int id;

    @Column(name = "cpf", length = 11)
    @NotBlank
    @Size(max= 11)
    private String cpf;

    @Column(name = "name", nullable = false, length = 60)
    @NotBlank
    @Size(max = 60)
    private String name;

    @Column(name = "email", nullable = false, length = 190)
    @NotBlank
    @Size(max = 190)
    private String email;
}
