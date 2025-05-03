package com.nyym.entites;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "media_uuid")
	private UUID mediaUuid;
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name ="file_name")
	private String fileName;
	
	
	@Column(name = "upload_date")
	private Date uploaDate;
	
	@ManyToOne
    @JoinColumn(name = "content_uuid", referencedColumnName = "content_uuid") // foreign key olacak
    private Content content;
	
}
