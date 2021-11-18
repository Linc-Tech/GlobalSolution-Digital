package fiap.com.br.globalsolution.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity(name = "T_DADOS_BANCARIOS_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="bankData", sequenceName = "SQ_TB_DADOS_BANCARIOS_ONG", allocationSize = 1)
public class BankData {

    @Id
    @Column(name = "id_conta_bancaria", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankData")
    private int id;

    @Column(name = "agencia", nullable = false, length = 9)
    @NotBlank(message = "O campo Agencia é obrigatório")
    @Min(value = 9, message = "Insira até 9 caracteres")
    private String agency;

    @Column(name = "conta", nullable = false, length = 15)
    @NotBlank(message= "O campo Conta é obrigatório")
    @Min(value = 15, message = "Insira ao menos 15 caracteres")
    private String account;
    
    @Column(name = "banco", nullable = false, length = 30)
	private String bank;
}
