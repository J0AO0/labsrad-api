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


import com.labsrad.domain.Convenio;
import com.labsrad.domain.Empresa;
import com.labsrad.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaResource {
	@Autowired
	private EmpresaService service;


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Empresa>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Empresa> empresa = service.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(empresa);
    }
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> findPorId(@PathVariable Integer id ) {
		Empresa empresa = service.findPorId(id);
		return ResponseEntity.ok().body(empresa);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Empresa> insert(@RequestBody Empresa obj ) {
		Empresa novoobj = service.insert(obj);
//		URI uri = ((UriComponentsBuilder) ((UriBuilder) ServletUriComponentsBuilder.fromCurrentRequest().build()).
//				path("/{id}")).buildAndExpand(novoobj.getId()).toUri();
		return ResponseEntity.ok().body(novoobj);
		
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id ) {
		service.delete(id);
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Empresa> update(
			      @PathVariable Integer id, 
			      @RequestBody Empresa obj ) {
		obj.setId(id);
		Empresa objnovo = service.atualiza(obj);
		return ResponseEntity.ok().body(objnovo);
		
	}
}
