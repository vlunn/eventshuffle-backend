package com.vlunn.eventshuffle.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vlunn.eventshuffle.persistence.model.Happening;

/**
 * Service that takes care of concerns related to persisting happening entities.
 */
public interface HappeningPersistenceService {

    Optional<Happening> getHappeningById(final UUID id);

    List<Happening> getHappenings();

    Optional<Happening> createHappening(final Happening toBeCreated);

}
