package com.dreammonster.ticketmayo.domain.openWait;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dreammonster.ticketmayo.web.dto.OpenWaitAdminReponseDto;

public interface OpenWaitRepository extends JpaRepository<OpenWait, Long> {
	
	@Query(value="select count(*) from open_wait ow where ow.user_email = :user_email and ow.play_name = :play_name", nativeQuery = true)
	int findByUserEmailAndPlayName(@Param(value = "user_email") String user_email, @Param(value = "play_name") String play_name);
	
	@Query(value="select id, apply_cost as applyCost, grade, hope_seat as hopeSeat, phone, play_name as playName, qty, site, site_id as siteId, site_pw as sitePw, status, birth, user_email as userEmail, created_date as createdDate from open_wait ow where ow.status not in ('성공', '실패') order by ow.id desc", nativeQuery = true)
	List<OpenWaitAdminReponseDto> applyList();

	@Query(value="select play_name as playName, site, grade, qty, site_id as siteId, phone, apply_cost as applyCost, status from open_wait where status in ('성공', '실패')", nativeQuery = true)
	List<OpenWaitAdminReponseDto> finishList();
	
	
}