//package com.nyym.services.impl;
//
//import java.util.UUID;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.nyym.entites.Content;
//import com.nyym.repository.ContentRepository;
//import com.nyym.services.IContentService;
//
//@Service
//public class ContentServiceImpl implements IContentService {
//    
//    @Autowired
//    private ContentRepository contentRepository;
//
//	@Override
//	public Content saveContent(Content content) {
//	
//		return contentRepository.save(content);
//	}
//
//	@Override
//	public void deleteContent(String contentId) {
//		
//	}
//
//	@Override
//	public Content getContentById(UUID contentId) {
//		return contentRepository.findById(contentId).orElse(null);		
//		
//	}
//    
//    
//}


package com.nyym.services.impl;

import com.nyym.entites.Content;
import com.nyym.observer.CalendarObserver;
import com.nyym.repository.CalendarDayRepository;
import com.nyym.repository.ContentRepository;
import com.nyym.services.IContentService;
import com.nyym.subject.ContentPublisher;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ContentService implements IContentService{

    private final ContentRepository contentRepository;
    private final CalendarDayRepository calendarDayRepository;

    public ContentService(ContentRepository contentRepository,
                          CalendarDayRepository calendarDayRepository) {
        this.contentRepository = contentRepository;
        this.calendarDayRepository = calendarDayRepository;
    }

    public Content createContent(Content content) {
        Content savedContent = contentRepository.save(content);

        // Observer işlemleri
        ContentPublisher publisher = new ContentPublisher();
        CalendarObserver observer = new CalendarObserver(calendarDayRepository);
        publisher.addObserver(observer);
        publisher.notifyContentCreated(savedContent);

        return savedContent;
    }

	@Override
	public Content saveContent(Content content) {
	 return contentRepository.save(content);
	}

	@Override
	public void deleteContent(String contentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Content getContentById(UUID contentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
