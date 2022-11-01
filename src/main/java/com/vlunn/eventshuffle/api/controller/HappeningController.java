package com.vlunn.eventshuffle.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlunn.eventshuffle.api.model.HappeningGlimpseDTO;
import com.vlunn.eventshuffle.api.model.HappeningFullDetailsDTO;
import com.vlunn.eventshuffle.api.model.HappeningListDTO;
import com.vlunn.eventshuffle.api.model.IdDTO;
import com.vlunn.eventshuffle.api.model.OccurencesDTO;
import com.vlunn.eventshuffle.api.model.mapper.HappeningModelMapper;
import com.vlunn.eventshuffle.business.model.HappeningBM;
import com.vlunn.eventshuffle.business.service.SchedulingService;

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

    @PostMapping
    public @Valid IdDTO createHappening(@Valid @RequestBody final OccurencesDTO happening) {
        logger.debug("Received API call: createHappening with body: {}", happening);

        final HappeningBM toBeCreated = mapper.toBusinessModel(happening);
        final Optional<HappeningBM> created = schedulingService.createHappening(toBeCreated);

        final UUID createdId = (created.orElseThrow()).getId();

        return new IdDTO(createdId);
    }

    @GetMapping("{happeningId}")
    public HappeningFullDetailsDTO getHappeningDetails(@PathVariable final UUID happeningId) {
        logger.debug("Received API call: getHappeningDetails for happening with id: {}", happeningId);

        return schedulingService.getHappening(happeningId)
            .map(happening -> mapper.toDTO(happening))
            .orElse(null);
    }

}
