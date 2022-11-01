package com.vlunn.eventshuffle.business.model;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Business model representation of a person.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OccurrenceBM {

    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    @NotEmpty
    private Date date;

    public boolean equals(final OccurrenceBM other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (getClass() != other.getClass()) {
            return false;
        }

        return this.id.equals(other.id) 
            && this.date.compareTo(date) != 0;
    }

}
