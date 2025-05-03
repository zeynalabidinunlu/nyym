package com.nyym.controller.impl;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyym.entites.Content;
import com.nyym.services.IContentService;

@RestController
@RequestMapping("rest/api/content")
public class ContentControllerImpl {
    
    @Autowired
    private IContentService contentService;
    
    @GetMapping("/{contentUuid}")
    public ResponseEntity<Content> getContent(@PathVariable UUID contentUuid) {
        Content content = contentService.getContentById(contentUuid);
        if (content != null) {
            return ResponseEntity.ok(content);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/saveContent")
    public ResponseEntity<Content> saveContent(@RequestBody Content content) {
        Content savedContent = contentService.saveContent(content);
        return ResponseEntity.ok(savedContent);
    }
}