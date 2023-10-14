package com.labsrad.resource;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Usuario;
import com.labsrad.service.AtendimentoService;
import com.labsrad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService service;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Usuario>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Usuario> usuario = service.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(usuario);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findPorId(@PathVariable Integer id ) {
        Usuario usuario = service.findPorId(id);
        return ResponseEntity.ok().body(usuario);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> insert(@RequestBody Usuario obj ) {
        Usuario novoobj = service.insert(obj);
//		URI uri = ((UriComponentsBuilder) ((UriBuilder) ServletUriComponentsBuilder.fromCurrentRequest().build()).
//				path("/{id}")).buildAndExpand(novoobj.getId()).toUri();
        return ResponseEntity.ok().body(novoobj);

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id ) {
        service.delete(id);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(
            @PathVariable Integer id,
            @RequestBody Usuario obj ) {
        obj.setId(id);
        Usuario objnovo = service.atualiza(obj);
        return ResponseEntity.ok().body(objnovo);

    }
}
