package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author EduardoM
 */

public record DatosDireccion(
        
        @NotBlank
        String calle, 
        @NotBlank
        String distrito, 
        @NotBlank
        String ciudad, 
        @NotBlank
        String numero, 
        @NotBlank
        String complemento) {
}
