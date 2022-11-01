package com.vlunn.eventshuffle.api.model;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data-transfer-object representation of an universal identifier. 
 * Can represent events, people, votes, ...
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IdDTO {

    @JsonProperty
    @NotEmpty
    @Getter
    private UUID id;

}
