package com.vlunn.eventshuffle.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

/**
 * Data-transfer-object representation of a happening (or "event" in the 
 * domain-language).
 */
@Builder
public class HappeningDTO {

    @JsonProperty
    @Getter
    private String name;

}
