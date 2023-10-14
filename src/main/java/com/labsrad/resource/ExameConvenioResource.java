package com.labsrad.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labsrad.domain.ExameConvenio;
import com.labsrad.service.ExameService;

@RestController
@RequestMapping(value = "/exameconvenios")

public class ExameConvenioResource {
	@Autowired
	private ExameService service;


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ExameConvenio>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ExameConvenio> obj = service.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(obj);
    }


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ExameConvenio> insert(@RequestBody ExameConvenio obj ) {
		ExameConvenio novoobj = service.insert(obj);
		return ResponseEntity.ok().body(novoobj);
		
	}

}
