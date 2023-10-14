package com.labsrad.resource;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Paciente;
import com.labsrad.service.AtendimentoService;
import com.labsrad.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {
    @Autowired
    private PacienteService service;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Paciente>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Paciente> paciente = service.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(paciente);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findPorId(@PathVariable Integer id ) {
        Paciente paciente = service.findPorId(id);
        return ResponseEntity.ok().body(paciente);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Paciente> insert(@RequestBody Paciente obj ) {
        Paciente novoobj = service.insert(obj);
//		URI uri = ((UriComponentsBuilder) ((UriBuilder) ServletUriComponentsBuilder.fromCurrentRequest().build()).
//				path("/{id}")).buildAndExpand(novoobj.getId()).toUri();
        return ResponseEntity.ok().body(novoobj);

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id ) {
        service.delete(id);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Paciente> update(
            @PathVariable Integer id,
            @RequestBody Paciente obj ) {
        obj.setId(id);
        Paciente objnovo = service.atualiza(obj);
        return ResponseEntity.ok().body(objnovo);

    }
}
