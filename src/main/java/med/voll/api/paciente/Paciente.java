package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.direccion.Direccion;

/**
 *
 * @author EduardoM
 */

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private Boolean activo;
    private String documentoIdentidad;
    private String telefono;

    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datos) {
        
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.direccion = new Direccion(datos.direccion());
    } 
    
    public void atualizarInformacion(DatosActualizacionPaciente datos) {
        if (DatosActualizacionPaciente.nombre() != null)
            this.nombre = (String) DatosActualizacionPaciente.nombre();

        if (DatosActualizacionPaciente.telefono() != null)
            this.telefono = (String) DatosActualizacionPaciente.telefono();

        if (DatosActualizacionPaciente.direccion() != null)
            direccion.atualizarInformacion(datos.direccion());
    }

    public void inactivar() {
        this.activo = false;
    }
}
