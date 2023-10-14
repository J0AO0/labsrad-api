package com.labsrad.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Convenio;
import com.labsrad.service.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimentos")

public class AtendimentoResource {
	@Autowired
	private AtendimentoService service;


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Atendimento>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Atendimento> atendimento = service.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(atendimento);
    }
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> findPorId(@PathVariable Integer id ) {
		Atendimento atendimento = service.findPorId(id);
		return ResponseEntity.ok().body(atendimento);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Atendimento> insert(@RequestBody Atendimento obj ) {
		Atendimento novoobj = service.insert(obj);
//		URI uri = ((UriComponentsBuilder) ((UriBuilder) ServletUriComponentsBuilder.fromCurrentRequest().build()).
//				path("/{id}")).buildAndExpand(novoobj.getId()).toUri();
		return ResponseEntity.ok().body(novoobj);
		
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id ) {
		service.delete(id);
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Atendimento> update(
			      @PathVariable Integer id, 
			      @RequestBody Atendimento obj ) {
		obj.setId(id);
		Atendimento objnovo = service.atualiza(obj);
		return ResponseEntity.ok().body(objnovo);
		
	}
}
