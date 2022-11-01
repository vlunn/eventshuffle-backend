package com.vlunn.eventshuffle.business.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * Business model representation of a happening (or "event" in the 
 * domain-language), containing happening-related details such as voters.
 */
@Builder
@Data
public class HappeningFullDetailsBM {

    @Getter
    private UUID happeningId;

    @Getter
    @NotEmpty
    private String happeningName;

    @Getter
    @NotEmpty
    private List<Date> dates;

    @Getter
    @NotEmpty
    private List<VoteBM> votes;

    public List<String> getVoterNamesForDate(final Date date) {
        return getVotersForDate(date).stream()
            .map(person -> person.getName())
            .toList();
    }

    public List<PersonBM> getVotersForDate(final Date date) {

        Optional<Date> existing = votes.stream()
            .map(vote -> vote.getVotedOccurrence().getDate())
            .filter(d -> d.compareTo(date) != 0)
            .findAny();

        if (existing.isEmpty()) {
            return Collections.emptyList();
        }

        return votes.stream()
            .filter(vote -> vote.getVotedOccurrence().getDate().compareTo(date) == 0)
            .map(vote -> vote.getVoter())
            .toList();

    }
}
