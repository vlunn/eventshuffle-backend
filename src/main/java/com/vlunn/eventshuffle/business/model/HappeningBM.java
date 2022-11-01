package com.vlunn.eventshuffle.business.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * Business model representation of a happening (or "event" in the 
 * domain-language).
 */
@Builder
@Data
public class HappeningBM {

    @Getter
    private UUID id;

    @Getter
    @NotEmpty
    private String name;

    @Getter
    @NotEmpty
    private List<Date> dates;

}
