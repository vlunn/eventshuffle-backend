package com.vlunn.eventshuffle.business.model.mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vlunn.eventshuffle.business.model.HappeningBM;
import com.vlunn.eventshuffle.persistence.model.Happening;
import com.vlunn.eventshuffle.persistence.model.Occurence;
import com.vlunn.eventshuffle.persistence.repository.OccurenceRepository;

import lombok.NoArgsConstructor;

/**
 * For converting business models of happenings to persistable
 * happening objects and vice-versa.
 */
@Component
@NoArgsConstructor
public class HappeningPersistenceMapper {

    @Autowired
    private OccurenceRepository occurenceRepository;

    public HappeningBM toBusinessModel(final Happening happeningPM) {

        final List<Date> dates = happeningPM.getOccurences().stream()
            .map(occurence -> occurence.getDateCandidate())
            .toList();

        return HappeningBM.builder()
            .id(happeningPM.getId())
            .name(happeningPM.getName())
            .dates(dates)
            .build();
    }

    public Happening toPersistenceModel(final HappeningBM happeningBM) {

        final List<Occurence> occurences = happeningBM.getDates().stream()
            .map(date -> new Occurence(date))
            .map(newOccurence -> occurenceRepository.save(newOccurence))
            .toList();

        return new Happening(happeningBM.getName(), occurences);
    }

}
