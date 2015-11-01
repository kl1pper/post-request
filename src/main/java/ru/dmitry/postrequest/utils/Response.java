package ru.dmitry.postrequest.utils;

import ru.dmitry.postrequest.entities.Country;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    private String type;
    private Long time;
    private List<Country> countries;
    private String echo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }
}
