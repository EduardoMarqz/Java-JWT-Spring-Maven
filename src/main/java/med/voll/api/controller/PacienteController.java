package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.controller.DatosActualizacionPaciente;
import med.voll.api.paciente.DatosListaPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import med.voll.api.paciente.DatosRegistroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author EduardoM
 */

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteRepository pacienterepository;
    private med.voll.api.paciente.DatosActualizacionPaciente DatosActualizacionPaciente;

    @PostMapping
    @Transactional
    public void registrarpaciente(@RequestBody @Valid DatosRegistroPaciente datos) {
        pacienterepository.save(new Paciente(datos));
    }
    
    @GetMapping
    public Page<DatosListaPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        return pacienterepository.findAll(paginacion).map(DatosListaPaciente::new);
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {
        var paciente = pacienterepository.getReferenceById(datos.id());
        paciente.atualizarInformacion(DatosActualizacionPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = pacienterepository.getReferenceById(id);
        paciente.inactivar();
    }
}
