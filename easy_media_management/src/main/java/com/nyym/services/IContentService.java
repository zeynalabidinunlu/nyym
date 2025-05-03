package com.nyym.services;

import java.util.List;
import java.util.UUID;

import com.nyym.entites.Content;

public interface IContentService {

	public Content saveContent(Content content);

	public void deleteContent(UUID contentUuid);
	
	public List<Content>  getContentByContentName(String contentName);
	

}
