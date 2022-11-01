package com.vlunn.eventshuffle.api.model;

import java.util.Date;
import java.util.List;
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
public class HappeningFullDetailsDTO {

    /**
     * ID of the happening-under-inspection.
     */
    @JsonProperty
    @Getter
    private UUID id;
    
    /**
     * Name of the happening.
     */
    @JsonProperty
    @Getter
    private String name;

    /**
     * All date options for the happening.
     */
    @JsonProperty
    @Getter
    private List<String> dates;

    /**
     * For each date that has at least one vote, 
     * lists the people who have voted the date.
     */
    @JsonProperty
    @Getter
    private List<VotersForOccurrenceDTO> votes;

}
