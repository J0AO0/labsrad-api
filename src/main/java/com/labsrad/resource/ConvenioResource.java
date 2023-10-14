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
import com.labsrad.service.ConvenioService;


	@RestController
	@RequestMapping(value = "/convenios")
public class ConvenioResource {

		@Autowired
		private ConvenioService service;



		@RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<Page<Convenio>> findAll(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        Page<Convenio> convenio = service.findAll(PageRequest.of(page, size));
	        return ResponseEntity.ok().body(convenio);
	    }

		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Convenio> insert(@RequestBody Convenio obj ) {
			Convenio novoobj = service.insert(obj);
//			URI uri = ((UriComponentsBuilder) ((UriBuilder) ServletUriComponentsBuilder.fromCurrentRequest().build()).
//					path("/{id}")).buildAndExpand(novoobj.getId()).toUri();
			return ResponseEntity.ok().body(novoobj);
			
		}
		@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
		public void deleteConv(@PathVariable Integer id ) {
			service.delete(id);
			
		}
		
		@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
		public ResponseEntity<Convenio> update(
				      @PathVariable Integer id, 
				      @RequestBody Convenio obj ) {
			obj.setId(id);
			Convenio objnovo = service.atualiza(obj);
			return ResponseEntity.ok().body(objnovo);
			
		}
}

