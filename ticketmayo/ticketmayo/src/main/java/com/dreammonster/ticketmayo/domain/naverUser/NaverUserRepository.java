package com.dreammonster.ticketmayo.domain.naverUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NaverUserRepository extends JpaRepository<NaverUser, Long> {
	
	Optional<NaverUser> findByEmail(String email);
}
