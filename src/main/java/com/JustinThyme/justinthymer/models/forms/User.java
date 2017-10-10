package com.JustinThyme.justinthymer.models.forms;

import com.JustinThyme.justinthymer.models.forms.Packet;
import com.JustinThyme.justinthymer.models.forms.Seed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    public String username;

    @NotNull
    @Size(min=6, message="Passwords must be at least six characters.")
    private String password;

    @NotNull
    private String verifyPassword;

    //note NotNull ? or keep optional IF user wants updates
    //note needs to be string for twillio
    private String phoneNumber;

    @JoinColumn(name = "user_id")
    private Packet packet;
    //public ArrayList<Packet> seeds;

    @NotNull
    private Seed.Area area;


    public User(String username, String password, String verifyPassword, Seed.Area area, String phoneNumber,
                Packet packet) {
        this.username = username;
        this.password = password;
        this.area = area;
        this.verifyPassword = verifyPassword;
        this.phoneNumber = phoneNumber;

        this.packet = packet;
    }

    public User() { }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Seed.Area getArea() {
        return area;
    }

    public void setArea(Seed.Area area) {
        this.area = area;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }
    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }


    public void checkPassword() {
        if (password!=null && verifyPassword!=null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
