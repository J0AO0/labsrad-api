package com.labsrad.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.labsrad.domain.Exame;

public interface ExameRepository extends PagingAndSortingRepository<Exame, Integer> {
	@Query(value = "SELECT * FROM exame", nativeQuery = true)
	List<Exame> findAllCat();

	@Query(value = "SELECT * FROM exame where id = ?", nativeQuery = true)
	Exame findPorId(Integer id);	

}

