package com.vlunn.eventshuffle.persistence.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

/**
 * Base class for all persistence entities. Defines some properties that are
 * common for all of them, such as identifiers.
 */
@MappedSuperclass
public abstract class ShuffleEntity {

    /**
     * Identifier, works as a primary key as well.
     */
    @Id
    @GeneratedValue
    @Getter
    protected UUID id;

    /**
     * Version for synchronization support; reject updates that are older than
     * what's currently persisted in the database. 
     */
    @Version
    @Column(name = "version")
    @Getter
    protected int version;

    @CreationTimestamp
    @Column(name = "creation_time")
    @Getter
    protected Instant created;

    @UpdateTimestamp
    @Column(name = "last_update_time")
    @Getter
    protected Instant lastUpdated;

}
