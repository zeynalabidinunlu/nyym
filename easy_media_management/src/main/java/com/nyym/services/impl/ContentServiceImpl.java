package com.nyym.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void deleteContent(UUID contentUuid) {

		contentRepository.deleteById(contentUuid);
	}

	@Override
	public List<Content> getContentByContentName(String contentName) {
		
		return contentRepository.findAll().stream()
				.filter(content -> content.getDescription().equalsIgnoreCase(contentName)).toList();
	}

}
