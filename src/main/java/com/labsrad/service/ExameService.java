package com.labsrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.labsrad.domain.ExameConvenio;
import com.labsrad.reporsitory.ExameConvenioRepository;

@Service
public class ExameService {

		@Autowired
		private ExameConvenioRepository repo;

		public Page<ExameConvenio> findAll(Pageable pageable) {
	        return repo.findAll(pageable);
	    }

		public ExameConvenio insert(ExameConvenio obj) {
			return repo.save(obj);
		}




}

