package com.labsrad.service;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Patrimonio;
import com.labsrad.reporsitory.AtendimentoRepository;
import com.labsrad.reporsitory.PatrimonioReporsitoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatrimonioService {

    @Autowired
    private PatrimonioReporsitoty repo;

    public Page<Patrimonio> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Patrimonio findPorId(Integer id) {
        Patrimonio cat = repo.findPorId(id);
        return cat;
    }

    public Patrimonio insert(Patrimonio obj) {
        return repo.save(obj);
    }

    public Patrimonio atualiza(Patrimonio obj) {
        Patrimonio novoobj = findPorId(obj.getId());
        novoobj.setId(obj.getId());
        return repo.save(novoobj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);

    }

}
