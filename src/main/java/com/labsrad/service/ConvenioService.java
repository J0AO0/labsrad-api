package com.labsrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.labsrad.domain.Convenio;
import com.labsrad.reporsitory.ConvenioRepository;

@Service
public class ConvenioService {
	
		@Autowired
		private ConvenioRepository repo;

		public Page<Convenio> findAll(Pageable pageable) {
	        return repo.findAll(pageable);
	    }

		public Convenio findPorId(Integer id) {
			Convenio cat = repo.findPorId(id);
	        	return cat;
		}

		public Convenio insert(Convenio obj) {
			return repo.save(obj);
		}
		
		public Convenio atualiza(Convenio obj) {
			Convenio novoobj = findPorId(obj.getId());
			novoobj.setDescricao(obj.getDescricao());
			return repo.save(novoobj);
		}
		
		public void delete(Integer id) {
			repo.deleteById(id);
			
		}
		

}

