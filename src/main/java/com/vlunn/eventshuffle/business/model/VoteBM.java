package com.vlunn.eventshuffle.business.model;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * Business model representation of a vote cast by certain person for a 
 * certain occurrence.
 */
@Builder
@Data
public class VoteBM {

    @Getter
    private UUID id;

    @Getter
    @NotEmpty
    private OccurrenceBM votedOccurrence;

    @Getter
    @NotEmpty
    private PersonBM voter;

}
