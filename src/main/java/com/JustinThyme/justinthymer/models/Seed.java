package com.JustinThyme.justinthymer.models;

import com.JustinThyme.justinthymer.models.Packet;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date; //note may need to import java.sql.Date (?)


@Entity
public class Seed {

    @Id
    @GeneratedValue
    private int id;
    public String name;

    public enum Area {
        WESTCOAST, INNERNW, INNERSW, SOUTH, MIDNORTH, EASTCOAST, FLORIDA
    }

    public enum Season {
        FALL, WINTER, SPRING, SUMMER
    }

    public Area area;
    public Season season;
    public Date plantDate;
    public String message;
    Boolean reminder; //note package private so can set in Packet

    @ManyToMany
    private ArrayList<Packet> packets;


    public Seed(String aName, Area anArea, Season aSeason, Date aDate, String message, Boolean reminder) {
        this.name = aName;
        this.area = anArea;
        this.season = aSeason;
        this.plantDate = aDate;
        this.message = message;
        this.reminder = false;
    }

    public Seed () { }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Date getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(Date plantDate) {
        this.plantDate = plantDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //note following in Packet for now
//    public Boolean getReminder() {
//        return reminder;
//    }
//
//    public void setReminder(Boolean reminder) {
//        this.reminder = reminder;
//    }
}