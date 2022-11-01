package com.vlunn.eventshuffle.business.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vlunn.eventshuffle.business.model.HappeningBM;
import com.vlunn.eventshuffle.business.model.HappeningFullDetailsBM;

/**
 * Service for scheduling happenings. 
 */
public interface SchedulingService {

    Optional<HappeningBM> createHappening(final HappeningBM happening);
 
    Optional<HappeningFullDetailsBM> getHappening(final UUID id);

    /**
     * Fetch all existing happenings. 
     *
     * NB: ultimately, should not be exposed to public API, or should 
     * return only those happenings that are visible for requester.
     * Exists here to help with initial app development.
     *
     * @return all happenings that exist in the backend.
     */
    List<HappeningBM> getHappenings();

    Optional<HappeningBM> updateHappening(final HappeningBM happening);

}
