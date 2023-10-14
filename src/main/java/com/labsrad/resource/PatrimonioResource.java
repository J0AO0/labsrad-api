package com.labsrad.resource;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Patrimonio;
import com.labsrad.service.AtendimentoService;
import com.labsrad.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/patrimonios")
public class PatrimonioResource {

    @Autowired
    private PatrimonioService service;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Patrimonio>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Patrimonio> patrimonio = service.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(patrimonio);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findPorId(@PathVariable Integer id ) {
        Patrimonio patrimonio = service.findPorId(id);
        return ResponseEntity.ok().body(patrimonio);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Patrimonio> insert(@RequestBody Patrimonio obj ) {
        Patrimonio novoobj = service.insert(obj);
//		URI uri = ((UriComponentsBuilder) ((UriBuilder) ServletUriComponentsBuilder.fromCurrentRequest().build()).
//				path("/{id}")).buildAndExpand(novoobj.getId()).toUri();
        return ResponseEntity.ok().body(novoobj);

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id ) {
        service.delete(id);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Patrimonio> update(
            @PathVariable Integer id,
            @RequestBody Patrimonio obj ) {
        obj.setId(id);
        Patrimonio objnovo = service.atualiza(obj);
        return ResponseEntity.ok().body(objnovo);

    }

}
