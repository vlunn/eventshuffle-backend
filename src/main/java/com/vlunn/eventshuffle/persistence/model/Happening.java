package com.vlunn.eventshuffle.persistence.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * A persistable entity that stores info about an happening 
 * ("event" in the domain language).
 */
@Entity
@Table(name = "happening")
@EqualsAndHashCode(callSuper = true)
@Data
public class Happening extends ShuffleEntity {

    @Column(name = "name", nullable = false)
    @Getter
    private String name;

    /**
     * Date candidates for the happening.
     */
    @OneToMany
    @Getter
    private List<Occurence> occurences = Collections.emptyList();

    public Happening() {
        super();
    }

    public Happening(String name, List<Occurence> occurences) {
        this.name = name;
        this.occurences = occurences;
    }

}
