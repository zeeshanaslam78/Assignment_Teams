package com.xeeshi.assignment_teams.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ZEESHAN on 13/02/2018.
 */

public class Team {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("national")
    @Expose
    private Boolean national;
    @SerializedName("country_name")
    @Expose
    private String countryName;

    public Team(String name, Boolean national, String countryName) {
        this.name = name;
        this.national = national;
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public Boolean getNational() {
        return national;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "\nTeam{" +
                "name='" + name + '\'' +
                ", national=" + national +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
