package com.vlunn.eventshuffle.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * A persistable entity that stores info about possible dates for an happening
 * (or "event" in the domain language).
 */
@Entity
@Table(name = "occurence")
@EqualsAndHashCode(callSuper = true)
@Data
public class Occurence extends ShuffleEntity {

    @Column(name = "date_candidate")
    @Getter
    private Date dateCandidate;

    public Occurence(final Date date) {
        this.dateCandidate = date;
    }

    public Occurence() {
        super();
    }
}
