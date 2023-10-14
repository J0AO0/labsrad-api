package com.labsrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.labsrad.domain.Convenio;
import com.labsrad.domain.Empresa;
import com.labsrad.reporsitory.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;

	public Page<Empresa> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

	public Empresa findPorId(Integer id) {
		Empresa cat = repo.findPorId(id);
        	return cat;
	}
	
	public Empresa insert(Empresa obj) {
		return repo.save(obj);
	}
	
	public Empresa atualiza(Empresa obj) {
		Empresa novoobj = findPorId(obj.getId());
		novoobj.setId(obj.getId());
		return repo.save(novoobj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}



}
