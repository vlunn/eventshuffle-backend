package com.vlunn.eventshuffle.api.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlunn.eventshuffle.business.model.PersonBM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data-transfer-object representation of voting situation.
 * For each date that has at least one vote, lists the people who have
 * voted the date.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VotersForOccurrenceDTO {

    @JsonProperty
    @Getter
    private Date date;

    @JsonProperty
    @Getter
    private List<String> people;

}
