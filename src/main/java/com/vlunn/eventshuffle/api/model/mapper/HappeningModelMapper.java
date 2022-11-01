package com.vlunn.eventshuffle.api.model.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.vlunn.eventshuffle.api.model.HappeningGlimpseDTO;
import com.vlunn.eventshuffle.api.model.OccurencesDTO;
import com.vlunn.eventshuffle.business.model.HappeningBM;

import lombok.NoArgsConstructor;

/**
 * For converting data-transfer-objects (DTOs) of happenings to business model
 * versions of happening objects and vice-versa.
 */
@NoArgsConstructor
@Component
public class HappeningModelMapper {

    final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public HappeningBM toBusinessModel(final OccurencesDTO occurencesDTO) {

        final List<Date> dates = occurencesDTO.getDates().stream()
            .map(d -> parseToDate(d))
            .toList();

        return HappeningBM.builder()
            .id(occurencesDTO.getHappeningId())
            .name(occurencesDTO.getHappeningName())
            .dates(dates)
            .build();
    }

    public HappeningGlimpseDTO toDTO(final HappeningBM happeningBM) {
        return HappeningGlimpseDTO.builder()
            .id(happeningBM.getId())
            .name(happeningBM.getName())
            .build();
    }

    private Date parseToDate(final String candidate) {
        return Optional.of(candidate)
            .map(d -> {
                try {
                    return formatter.parse(d);
                } catch (ParseException e) {
                    return null;
                }
            })
            .orElseThrow();
    }

}
