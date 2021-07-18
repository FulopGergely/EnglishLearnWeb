package com.example.demo.Domain;


import java.sql.Date;
import java.time.LocalDateTime;

public class Test {
    private String id;
    private String test;
    private String name;
    private String score;
    private String tipp;
    private Date dates;

    public Test() {
    }

    public Test(String id, String test, String name, String score, String tipp, Date dates) {
        this.id = id;
        this.test = test;
        this.name = name;
        this.score = score;
        this.tipp = tipp;
        this.dates = dates;
    }
    public Test(String test, String name, String score, String tipp, Date dates) {
        this.test = test;
        this.name = name;
        this.score = score;
        this.tipp = tipp;
        this.dates = dates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTipp() {
        return tipp;
    }

    public void setTipp(String tipp) {
        this.tipp = tipp;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
}
