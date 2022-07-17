package com.dreammonster.ticketmayo.domain.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

	@Query(value="select * from notice nt order by nt.id desc", nativeQuery = true)
	List<Notice> findAllDesc();
}
