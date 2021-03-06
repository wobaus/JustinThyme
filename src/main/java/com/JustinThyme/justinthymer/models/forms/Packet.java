package com.JustinThyme.justinthymer.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Packet {

    @Id
    @GeneratedValue
    private int id;

    @NotNull

    @JoinColumn(name="user_id")
    private int user_id;


    @ManyToMany
    List<Seed> seeds = new ArrayList<>();


    public Packet(Integer user_id, List<Seed> seeds) {}

    public Packet() { }


    public int getId() { return id; }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public void addSeed(Seed newSeed) {
        seeds.add(newSeed);
    }
    public void removeSeed(Seed oldSeed) {
        seeds.remove(oldSeed);
    }

    public void setReminder(Seed aSeed) {
        aSeed.reminder = true;
    }
    public void removeReminder(Seed aSeed) {
        aSeed.reminder = false;
    }
}
