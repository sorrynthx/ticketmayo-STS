package com.dreammonster.ticketmayo.domain.secondTicket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminResponseDto;

public interface SecondTicketRepository extends JpaRepository<SecondTicket, Long> {
	
	@Query(value="select * from second_ticket order by created_date desc", nativeQuery = true)
	List<SecondTicketAdminResponseDto> list2();
	
	@Query(value="select \n"
			+ "	id, actor,delivery_fee,grade,created_date,\n"
			+ "    CONCAT(SUBSTRING(SUBSTRING_INDEX(owner, '@', 1), 1, 3), '******', '@', 'naver.com') as owner,\n"
			+ "    payment,play_day,play_loc,play_time,poster,price,qty,seat_info1,seat_info2,seat_info3,title,code\n"
			+ "FROM second_ticket\n"
			+ "where created_date BETWEEN DATE_ADD(NOW(), INTERVAL -6 MONTH) AND NOW()\n"
			+ "order by id desc", nativeQuery=true)
	List<SecondTicketAdminResponseDto> listSecured();

}
