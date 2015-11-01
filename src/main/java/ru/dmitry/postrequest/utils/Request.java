package ru.dmitry.postrequest.utils;

import java.io.Serializable;

public class Request implements Serializable {

    private String key;

    private String echo;

    public Request() {
    }

    public Request(String key, String echo) {
        this.key = key;
        this.echo = echo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }
}
