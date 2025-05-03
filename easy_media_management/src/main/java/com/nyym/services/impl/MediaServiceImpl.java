package com.nyym.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nyym.entites.Content;
import com.nyym.entites.Media;
import com.nyym.repository.ContentRepository;
import com.nyym.repository.MediaRepository;
import com.nyym.services.IMediaService;

@Service
public class MediaServiceImpl implements IMediaService {
	
	@Autowired
	private MediaRepository mediaRepository;
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Override
	@Transactional
	public Media saveMedia(Media media) {
		// Eğer Content nesnesi varsa ve contentUuid değeri setlenmişse
		if (media.getContent() != null && media.getContent().getContentUuid() != null) {
			UUID contentUuid = media.getContent().getContentUuid();
			
			// Veritabanından tam Content nesnesini yükle
			Optional<Content> contentOpt = contentRepository.findById(contentUuid);
			
			if (contentOpt.isPresent()) {
				// Tam content nesnesini media'ya set et
				media.setContent(contentOpt.get());
			}
		}
		
		// Media nesnesini kaydet
		return mediaRepository.save(media);
	}
}