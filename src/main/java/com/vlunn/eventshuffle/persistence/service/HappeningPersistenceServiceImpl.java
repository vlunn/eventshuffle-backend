package com.vlunn.eventshuffle.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlunn.eventshuffle.persistence.model.Happening;
import com.vlunn.eventshuffle.persistence.repository.HappeningRepository;

@Service
public class HappeningPersistenceServiceImpl implements HappeningPersistenceService {

    private static final Logger logger = LoggerFactory.getLogger(HappeningPersistenceServiceImpl.class);

    @Autowired
    private HappeningRepository happeningRepository;

    public Optional<Happening> getHappening(final UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<Happening> getHappenings() {
        logger.debug("Fetching all happenings from DB.");
        return happeningRepository.findAll();
    }

}
