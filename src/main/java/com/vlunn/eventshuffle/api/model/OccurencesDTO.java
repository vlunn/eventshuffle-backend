package com.vlunn.eventshuffle.api.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data-transfer-object representation for date candidates for an happening.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OccurencesDTO {

    @Getter
    @Nullable
    private UUID happeningId;

    @JsonProperty("name")
    @NotEmpty(message = "An event must have a name.")
    @Getter
    private String happeningName;

    @JsonProperty
    @NotEmpty(message = "An event must have at least one date option.")
    @Getter
    private List<String> dates;

}
