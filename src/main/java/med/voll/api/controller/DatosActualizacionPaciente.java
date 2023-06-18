package med.voll.api.controller;

import jakarta.validation.Valid;

/**
 *
 * @author EduardoM
 */

public record DatosActualizacionPaciente(
    Long id,
    String nombre,
    String telefono,
    @Valid DatosActualizacionDireccion direccion
) {
}
