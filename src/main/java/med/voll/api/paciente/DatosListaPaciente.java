package med.voll.api.paciente;

/**
 *
 * @author EduardoM
 */

public record DatosListaPaciente(String nombre, String email, String documentoIdentidad) {
    public DatosListaPaciente(Paciente paciente) {
        this(paciente.getNombre(), paciente.getEmail(), paciente.getDocumentoIdentidad());
    }
}
