package com.vlunn.eventshuffle.api.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlunn.eventshuffle.api.model.HappeningGlimpseDTO;
import com.vlunn.eventshuffle.api.model.HappeningListDTO;
import com.vlunn.eventshuffle.api.model.mapper.HappeningModelMapper;
import com.vlunn.eventshuffle.business.model.HappeningBM;
import com.vlunn.eventshuffle.business.service.SchedulingService;
import com.vlunn.eventshuffle.exception.NotImplementedException;

import lombok.AllArgsConstructor;

/**
 * Defines the API for handling happenings.
 */
@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class HappeningController {

    private static final Logger logger = 
        LoggerFactory.getLogger(HappeningController.class);

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private HappeningModelMapper mapper;

    @GetMapping("list")
    public @Valid HappeningListDTO getHappenings() {
        logger.debug("Received API call: getHappenings.");
 
        final List<HappeningBM> happenings = schedulingService.getHappenings();
        final List<HappeningGlimpseDTO> happeningGlimpseDTOS = happenings.stream()
            .map(h -> mapper.toDTO(h))
            .toList();

        return new HappeningListDTO(happeningGlimpseDTOS);
    }

    @PutMapping()
    public HappeningDTO createHappening(@RequestBody final HappeningDTO happening) {
        logger.debug("Received API call: createHappening with body: {}", happening);
        final String msg = "API endpoint for creating happenings is not yet implemented.";
        throw new NotImplementedException(msg);
    }

}
