package com.JustinThyme.justinthymer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class Packet {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @OneToOne //note ??
    //@JoinColumn(name="user_id")
    private int user_id;


    @ManyToMany
    private Iterable<Seed> seeds; //note List, Iterable instead?
    //I think an interable would be preferred here, it's more similar to how the cHeese app is set up

    public Packet() { }


    public int getId() { return id; }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Iterable<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(Iterable<Seed> seeds) {
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
