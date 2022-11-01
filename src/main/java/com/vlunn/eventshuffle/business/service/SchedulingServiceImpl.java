package com.vlunn.eventshuffle.business.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlunn.eventshuffle.business.model.HappeningBM;
import com.vlunn.eventshuffle.business.model.mapper.HappeningPersistenceMapper;
import com.vlunn.eventshuffle.exception.NotImplementedException;
import com.vlunn.eventshuffle.persistence.model.Happening;
import com.vlunn.eventshuffle.persistence.service.HappeningPersistenceService;

@Service
public class SchedulingServiceImpl implements SchedulingService {
    
    private static final Logger logger = LoggerFactory.getLogger(SchedulingServiceImpl.class);

    @Autowired
    private HappeningPersistenceService happeningPersistenceService;

    @Autowired
    private HappeningPersistenceMapper mapper;

    private final static String NOT_IMPLEMENTED_MSG = " is not yet implemented.";

    public Optional<HappeningBM> getHappening(final UUID id) {
        logger.debug("Fetching happening with id {}", id);

        return happeningPersistenceService.getHappening(id)
                .map(h -> mapper.toBusinessModel(h));
    }

    public List<HappeningBM> getHappenings() {
        logger.debug("Fetching all happenings.");

        return happeningPersistenceService.getHappenings()
                .stream()
                .map(h -> mapper.toBusinessModel(h))
                .toList();
    }

    public Optional<HappeningBM> createHappening(final HappeningBM happening) {
        logger.debug("Creating a happening from {}", happening);

        final Happening toBeCreated = mapper.toPersistenceModel(happening);

        return happeningPersistenceService.createHappening(toBeCreated)
            .map(h -> mapper.toBusinessModel(h));
    }

    public Optional<HappeningBM> updateHappening(final HappeningBM happening) {
        throw new NotImplementedException("Updating events" + NOT_IMPLEMENTED_MSG);
    }

}
