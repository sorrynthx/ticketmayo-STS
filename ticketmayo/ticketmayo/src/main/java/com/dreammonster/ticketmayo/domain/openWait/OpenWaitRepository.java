package com.dreammonster.ticketmayo.domain.openWait;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dreammonster.ticketmayo.web.dto.OpenWaitAdminReponseDto;

public interface OpenWaitRepository extends JpaRepository<OpenWait, Long> {
	
	@Query(value="select count(*) from open_wait ow where ow.user_email = :user_email and ow.play_name = :play_name and ow.hope_day = :hope_day and ow.hope_time = :hope_time", nativeQuery = true)
	int findByUserEmailAndPlayName(@Param(value = "user_email") String user_email, @Param(value = "play_name") String play_name, @Param(value = "hope_day") String hope_day, @Param(value = "hope_time") String hope_time);
	
	@Query(value="select id, apply_cost as applyCost, grade, hope_seat as hopeSeat, phone, play_name as playName, qty, site, site_id as siteId, site_pw as sitePw, status, birth, user_email as userEmail, created_date as createdDate, deposit_bank as depositBank, deposit_owner as depositOwner, deposit_acct as depositAcct, hope_day as hopeDay, hope_time as hopeTime from open_wait ow where ow.status not in ('성공', '실패') order by ow.id desc", nativeQuery = true)
	List<OpenWaitAdminReponseDto> applyList();

	@Query(value="select play_name as playName, site, grade, qty, site_id as siteId, phone, apply_cost as applyCost, status, refund_account as refundAccount, account_owner as accountOwner, bank_name as bankName from open_wait where status in ('성공', '실패')", nativeQuery = true)
	List<OpenWaitAdminReponseDto> finishList();
	
	
}