package com.application.library.controller;

import com.application.library.entity.Publisher;
import com.application.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public List<Publisher> findAllPublishers() {
        return publisherService.findAllPublishers();
    }

    @GetMapping("/remove-publisher/{id}")
    public List<Publisher> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return publisherService.findAllPublishers();
    }

    @GetMapping("/update-publisher/{id}")
    public Publisher updatePublisher(@PathVariable Long id) {
        return publisherService.findPublisherById(id);

    }

    @PostMapping("/update-publisher/{id}")
    public void saveUpdatePublisher(@PathVariable Long id, Publisher publisher){
        publisherService.updatePublisher(publisher);
    }

    @PostMapping("/save-publisher")
    public void createPublisher(Publisher publisher){
        publisherService.createPublisher(publisher);
    }

}
