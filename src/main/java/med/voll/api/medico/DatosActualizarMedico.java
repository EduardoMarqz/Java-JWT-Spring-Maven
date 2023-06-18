
package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;

/**
 *
 * @author EduardoM
 */
public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {
    
}
