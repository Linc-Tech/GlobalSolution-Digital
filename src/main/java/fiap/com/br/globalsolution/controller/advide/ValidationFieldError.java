package fiap.com.br.globalsolution.controller.advide;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationFieldError {

    private String field;
    private String error;
}