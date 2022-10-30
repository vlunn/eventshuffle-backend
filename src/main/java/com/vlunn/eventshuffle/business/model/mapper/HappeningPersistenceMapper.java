package com.vlunn.eventshuffle.business.model.mapper;

import org.springframework.stereotype.Component;

import com.vlunn.eventshuffle.business.model.HappeningBM;
import com.vlunn.eventshuffle.persistence.model.Happening;

import lombok.NoArgsConstructor;

/**
 * For converting business models of happenings to persistable
 * happening objects and vice-versa.
 */
@Component
@NoArgsConstructor
public class HappeningPersistenceMapper {

    public HappeningBM toBusinessModel(final Happening happeningPM) {
        return HappeningBM.builder()
            .name(happeningPM.getName())
            .build();
    }

    public Happening toPersistenceModel(final HappeningBM happeningBM) {
        return Happening.builder()
            .name(happeningBM.getName())
            .build();
    }

}
