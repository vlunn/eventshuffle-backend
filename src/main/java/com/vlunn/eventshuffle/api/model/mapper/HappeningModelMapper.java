package com.vlunn.eventshuffle.api.model.mapper;

import org.springframework.stereotype.Component;

import com.vlunn.eventshuffle.api.model.HappeningGlimpseDTO;
import com.vlunn.eventshuffle.business.model.HappeningBM;

import lombok.NoArgsConstructor;

/**
 * For converting data-transfer-objects (DTOs) of happenings to business model
 * versions of happening objects and vice-versa.
 */
@NoArgsConstructor
@Component
public class HappeningModelMapper {

    public HappeningBM toBusinessModel(final HappeningDTO happeningDTO) {
        return HappeningBM.builder()
            .name(happeningDTO.getName())
            .build();
    }

    public HappeningDTO toDTO(final HappeningBM happeningBM) {
        return HappeningDTO.builder()

    public HappeningGlimpseDTO toDTO(final HappeningBM happeningBM) {
        return HappeningGlimpseDTO.builder()
            .id(happeningBM.getId())
            .name(happeningBM.getName())
            .build();
    }

}
