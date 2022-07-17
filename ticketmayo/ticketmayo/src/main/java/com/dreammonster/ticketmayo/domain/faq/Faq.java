package com.dreammonster.ticketmayo.domain.faq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dreammonster.ticketmayo.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Faq extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=10)
	private String faqGroup;
	
	@Column(length=100)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Builder
	public Faq(String faqGroup, String title, String content) {
		this.faqGroup = faqGroup;
		this.title = title;
		this.content = content;
	}

	public void update(String faqGroup, String title, String content) {
		this.faqGroup = faqGroup;
		this.title = title;
		this.content = content;
	}
	
}
