package com.example.athletedirectory.model;

import javax.persistence.*;
import java.util.*;
import com.example.athletedirectory.model.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "athlete")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int athleteId;

    @Column(name = "name")
    private String athleteName;

    @Column(name = "sport")
    private String sport;

    @ManyToOne
    @JoinColumn(name = "countryid")
    private Country country;

    @ManyToMany
    @JoinTable(name = "athlete_country", joinColumns = @JoinColumn(name = "athleteid"), inverseJoinColumns = @JoinColumn(name = "countryid"))
    @JsonIgnoreProperties("athletes")
    private List<Country> countries = new ArrayList<>();

    public Athlete() {
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(int athleteId) {
        this.athleteId = athleteId;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
