package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.direccion.DatosDireccion;

/**
 *
 * @author EduardoM
 */


public record DatosRegistroMedico(
    
    @NotBlank
    String nombre,
    @NotBlank
    @Email
    String email, 
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")        
    String documento, 
    @NotBlank
    String telefono,
    @NotNull
    Especialidad especialidad, 
    @NotNull
    @Valid
    DatosDireccion direccion) {
}
