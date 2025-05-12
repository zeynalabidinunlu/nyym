package com.nyym.observer;

import com.nyym.entites.Content;

public interface ContentObserver {
    void onContentCreated(Content content);
}
