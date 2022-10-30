package com.vlunn.eventshuffle.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlunn.eventshuffle.api.model.HappeningDTO;
import com.vlunn.eventshuffle.api.model.mapper.HappeningModelMapper;
import com.vlunn.eventshuffle.business.service.SchedulingService;
import com.vlunn.eventshuffle.exception.NotImplementedException;

import lombok.AllArgsConstructor;

/**
 * Defines the API for handling happenings.
 */
@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class HappeningController {

    private static final Logger logger = 
        LoggerFactory.getLogger(HappeningController.class);

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private HappeningModelMapper mapper;

    @GetMapping()
    public List<HappeningDTO> getHappenings() {
        logger.debug("Received API call: getHappenings.");

        return schedulingService.getHappenings().stream()
            .map(h -> mapper.toDTO(h))
            .toList();
    }

    @PutMapping()
    public HappeningDTO createHappening(@RequestBody final HappeningDTO happening) {
        logger.debug("Received API call: createHappening with body: {}", happening);
        final String msg = "API endpoint for creating happenings is not yet implemented.";
        throw new NotImplementedException(msg);
    }

}
