package com.labsrad.service;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Usuario;
import com.labsrad.reporsitory.AtendimentoRepository;
import com.labsrad.reporsitory.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Page<Usuario> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Usuario findPorId(Integer id) {
        Usuario cat = repo.findPorId(id);
        return cat;
    }

    public Usuario insert(Usuario obj) {
        return repo.save(obj);
    }

    public Usuario atualiza(Usuario obj) {
        Usuario novoobj = findPorId(obj.getId());
        novoobj.setId(obj.getId());
        return repo.save(novoobj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);

    }

}
