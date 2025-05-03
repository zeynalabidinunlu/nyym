package com.nyym.services.impl;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nyym.entites.Content;
import com.nyym.repository.ContentRepository;
import com.nyym.services.IContentService;

@Service
public class ContentServiceImpl implements IContentService {
    
    @Autowired
    private ContentRepository contentRepository;

	@Override
	public Content saveContent(Content content) {
	
		return contentRepository.save(content);
	}

	@Override
	public void deleteContent(String contentId) {
		
	}

	@Override
	public Content getContentById(UUID contentId) {
		return contentRepository.findById(contentId).orElse(null);		
		
	}
    
    
}