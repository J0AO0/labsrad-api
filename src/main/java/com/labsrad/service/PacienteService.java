package com.labsrad.service;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Paciente;
import com.labsrad.reporsitory.AtendimentoRepository;
import com.labsrad.reporsitory.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repo;

    public Page<Paciente> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Paciente findPorId(Integer id) {
        Paciente cat = repo.findPorId(id);
        return cat;
    }

    public Paciente insert(Paciente obj) {
        return repo.save(obj);
    }

    public Paciente atualiza(Paciente obj) {
        Paciente novoobj = findPorId(obj.getId());
        novoobj.setId(obj.getId());
        return repo.save(novoobj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);

    }

}
