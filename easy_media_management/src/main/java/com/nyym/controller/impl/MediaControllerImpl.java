package com.nyym.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyym.controller.IMediaController;
import com.nyym.entites.Media;
import com.nyym.services.IMediaService;

@RestController
@RequestMapping("rest/api/media")
public class MediaControllerImpl implements IMediaController {

	@Autowired
	private IMediaService mediaService;

	@PostMapping(path = "/saveMedia")
	@Override
	public Media saveMedia(@RequestBody Media media) {
		return mediaService.saveMedia(media);
	}

}
