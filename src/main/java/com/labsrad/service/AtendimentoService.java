package com.labsrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.labsrad.domain.Atendimento;
import com.labsrad.domain.Convenio;
import com.labsrad.reporsitory.AtendimentoRepository;

@Service
public class AtendimentoService {
	@Autowired
	private AtendimentoRepository repo;

	public Page<Atendimento> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

	public Atendimento findPorId(Integer id) {
		Atendimento cat = repo.findPorId(id);
        	return cat;
	}
	
	public Atendimento insert(Atendimento obj) {
		return repo.save(obj);
	}
	
	public Atendimento atualiza(Atendimento obj) {
		Atendimento novoobj = findPorId(obj.getId());
		novoobj.setId(obj.getId());
		return repo.save(novoobj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
}
