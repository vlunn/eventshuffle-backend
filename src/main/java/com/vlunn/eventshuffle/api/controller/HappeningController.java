package com.vlunn.eventshuffle.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlunn.eventshuffle.api.model.HappeningDTO;
import com.vlunn.eventshuffle.business.service.SchedulingService;
import com.vlunn.eventshuffle.persistence.model.Happening;

import lombok.AllArgsConstructor;

/**
 * Defines the API for handling happenings.
 */
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class HappeningController {

    private static final Logger logger = 
        LoggerFactory.getLogger(HappeningController.class);

    private static final String NOT_IMPLEMENTED_MSG = 
        "The requested API endpoint is not yet implemented.";

    @Autowired
    private SchedulingService shedulingService;

    @GetMapping
    public List<Happening> getHappenings() {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED_MSG);
    }

    @PostMapping
    public HappeningDTO createHappening(final HappeningDTO happening) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED_MSG);
    }

}
