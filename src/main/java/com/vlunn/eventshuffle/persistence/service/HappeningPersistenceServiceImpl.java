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

    public Optional<Happening> getHappeningById(final UUID id) {
        logger.debug("Searching for happening by id: {}.", id);
        Optional<Happening> happening = happeningRepository.findById(id);
        logger.info("Search result for happening with id: {} is: {}.", id, happening);
        return happening;
    }

    public List<Happening> getHappenings() {
        logger.debug("Fetching all happenings from DB.");
        final List<Happening> happenings = happeningRepository.findAll();
        logger.info("Found happenings: {}", happenings.toString());
        return happenings;
    }

    public Optional<Happening> createHappening(final Happening toBeCreated) {
        logger.debug("Saving happening: {} in database.", toBeCreated);
        final Optional<Happening> saved = Optional.of(happeningRepository.save(toBeCreated));
        logger.info("Saved {} in DB.", saved);
        return saved;
    }

}
