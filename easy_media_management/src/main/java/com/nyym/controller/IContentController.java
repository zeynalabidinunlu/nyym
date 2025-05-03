package com.nyym.controller;

import java.util.List;
import java.util.UUID;

import com.nyym.entites.Content;

public interface IContentController {

	public Content saveContent(Content content);
	
	public void deleteContent(UUID String);
	
	public List<Content> getContentByContentName(String contentName);
}
