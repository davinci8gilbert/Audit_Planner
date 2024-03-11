package com.example.audit_planner.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class WebScraper {
	
	@GetMapping("/scraper")
	public ResponseEntity<String> scrapeWebsite(@RequestParam String url, @RequestParam String selector) {
        try {
            // Fetch the HTML content from the provided URL
            Document doc = Jsoup.connect(url).get();
            
            // Select elements based on the provided selector
            Elements selectedElements = doc.select(selector);
            
         // Exclude <h1> elements and their text
            for (Element element : selectedElements.select("h1, h2, h3")) {
                element.remove();
            }
            
            // Return the selected elements' text
            String result = selectedElements.text();
            
            // Return the selected elements
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error scraping website", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/scraperimgvid")
	public ResponseEntity<String> scrapeWebsite2(@RequestParam String url, @RequestParam String selector) {
        try {
        	// Fetch the HTML content from the provided URL
            Document doc = Jsoup.connect(url).get();
            
            // Select elements based on the provided selector
            Elements selectedElements = doc.select(selector);
            
            // Check if any element is found
            if (selectedElements.isEmpty()) {
                return new ResponseEntity<>("No element found for the provided selector", HttpStatus.NOT_FOUND);
            }
            
            // Extract image or video URL from the selected element
            Element element = selectedElements.first(); // Assuming you want the first matching element
            String imagevidUrl = element.attr("src"); // For images
            return new ResponseEntity<>(imagevidUrl, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error scraping website", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/scraperlink")
	public ResponseEntity<String> scrapeWebsite3(@RequestParam String url, @RequestParam String selector) {
        try {
        	// Fetch the HTML content from the provided URL
            Document doc = Jsoup.connect(url).get();
            
            // Select elements based on the provided selector
            Elements selectedElements = doc.select(selector);
            
            // Check if any element is found
            if (selectedElements.isEmpty()) {
                return new ResponseEntity<>("No element found for the provided selector", HttpStatus.NOT_FOUND);
            }
            
            // Extract image or video URL from the selected element
            Element element = selectedElements.first(); // Assuming you want the first matching element
            String imagevidUrl = element.attr("href"); // For images
            return new ResponseEntity<>(imagevidUrl, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error scraping website", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
		
}