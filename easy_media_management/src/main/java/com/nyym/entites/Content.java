package com.nyym.entites;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "content")
public class Content {

	@Id
	@Column(name = "content_uuid", nullable = false)
	private UUID contentUuid;

	@Column(name = "description")
	private String description;

	@Column(name = "share_text")
	private String shareText;

	@Column(name = "number_of_people")
	private Integer numberOfPeople;

	@Column(name = "improvements")
	private String improvements;

	@Column(name = "event_date")
	private LocalDateTime eventDate;

	@Column(name = "user_uuid", nullable = false)
	private UUID userUuid;

	@Column(name = "category_uuid", nullable = false)
	private UUID categoryUuid;

}