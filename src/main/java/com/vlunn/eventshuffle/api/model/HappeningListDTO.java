package com.vlunn.eventshuffle.api.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data-transfer-object representation of all happenings.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HappeningListDTO {

    @JsonProperty("events")
    @NotNull
    @Getter
    private List<HappeningGlimpseDTO> happenings;

}
