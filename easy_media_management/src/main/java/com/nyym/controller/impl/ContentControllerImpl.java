package com.nyym.controller.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyym.controller.IContentController;
import com.nyym.entites.Content;
import com.nyym.services.IContentService;

@RestController
@RequestMapping("rest/api/content")
public class ContentControllerImpl implements IContentController {

	@Autowired
	private IContentService contentService;

	@PostMapping(path = "/saveContent")
	@Override
	public Content saveContent(@RequestBody Content content) {
		return contentService.saveContent(content);
	}

	@DeleteMapping(path = "/deleteContent")
	@Override
	public void deleteContent(UUID contentUuid) {

		contentService.deleteContent(contentUuid);
	}

	@GetMapping(path = "/getContentByContentName", params = "contentName")
	@Override
	public List<Content> getContentByContentName(@RequestParam(name = "contentName") String contentName) {

		return contentService.getContentByContentName(contentName);
	}

}
