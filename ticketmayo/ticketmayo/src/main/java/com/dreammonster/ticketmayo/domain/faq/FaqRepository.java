package com.dreammonster.ticketmayo.domain.faq;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FaqRepository extends JpaRepository<Faq, Long> {
	
	@Query(value="select * from faq fq order by fq.id desc", nativeQuery = true)
	List<Faq> findAllDesc();
	
}
