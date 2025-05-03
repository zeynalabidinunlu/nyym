package com.nyym.services;

import java.util.UUID;

import com.nyym.entites.Content;

public interface IContentService {

public    Content saveContent(Content content);

public    void deleteContent(String contentId);
public    Content getContentById(UUID contentId);
}