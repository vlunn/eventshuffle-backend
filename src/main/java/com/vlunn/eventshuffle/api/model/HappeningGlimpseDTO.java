package com.vlunn.eventshuffle.api.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data-transfer-object representation of a happening (or "event" in the 
 * domain-language).
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HappeningGlimpseDTO {

    @JsonProperty
    @Getter
    private UUID id;
    
    @JsonProperty
    @Getter
    private String name;

}
