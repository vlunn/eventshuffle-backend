package com.vlunn.eventshuffle.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A persistable entity that stores info about an happening 
 * ("event" in the domain language).
 */
@Entity
@Table(name = "happening")
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
public class Happening extends ShuffleEntity {

    @Column(name = "name", nullable = false)
    @Getter
    private String name;

}
