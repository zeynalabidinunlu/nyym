package com.nyym.subject;
import com.nyym.entites.Content;
import com.nyym.observer.ContentObserver;
import java.util.ArrayList;
import java.util.List;

public class ContentPublisher {

    private final List<ContentObserver> observers = new ArrayList<>();

    public void addObserver(ContentObserver observer) {
        observers.add(observer);
    }

    public void notifyContentCreated(Content content) {
        for (ContentObserver observer : observers) {
            observer.onContentCreated(content);
        }
    }
}
