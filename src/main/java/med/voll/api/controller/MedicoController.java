package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import med.voll.api.medico.DatosActualizarMedico;
import med.voll.api.medico.DatosListadoMedico;
import java.util.List;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author EduardoM
 */

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    @PostMapping
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico,
            UriComponentsBuilder uricomponentsbuilder){
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico datosrespuestamedico = new DatosRespuestaMedico(medico.getId(), 
                medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), 
                medico.getEmail());
        URI url = uricomponentsbuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosrespuestamedico);
    }
    
    @GetMapping
    public ResponseEntity<Page<DatosListadoMedico>> ListadoMedico(@PageableDefault(size=2) Pageable paginacion){
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(medico.getId(), 
                medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), 
                medico.getEmail()));
    }
    
    
    //Delete Logico
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedico> retornaDatosMedico (@PathVariable Long id){
        
        Medico medico = medicoRepository.getReferenceById(id);
        var datosmedico =new DatosRespuestaMedico(medico.getId(), 
                medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), 
                medico.getEmail());
        return ResponseEntity.ok(datosmedico);
    }
}
