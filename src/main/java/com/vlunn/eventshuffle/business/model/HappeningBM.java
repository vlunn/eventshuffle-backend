package com.vlunn.eventshuffle.business.model;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * Business model representation of a happening (or "event" in the 
 * domain-language).
 */
@Builder
public class HappeningBM {

    @Getter
    private String name;

    @Getter
    private List<Date> dates;

}
