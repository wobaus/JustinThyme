//package org.launchcode.models.forms;
//
//import org.launchcode.models.Cheese;
//import org.launchcode.models.Menu;
//
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.Iterable;
//
//public class AddSeedToPacketForm {
//
//    private Packet packet;
//
//    public Iterable<Seed> getSeeds() {
//        return seeds;
//    }
//
//    private Iterable<Seed> seeds;
//
//
//    @NotNull
//    private int packetId;
//
//    @NotNull
//    private int seedId;
//
//    public AddSeedToPacketForm(Packet packet, Iterable<Seed> seeds) {
//        this.packet = packet;
//        this.seeds = seeds;
//    }
//
//    public AddSeedToPacketForm() {}
//
//    public Packet getPacket() {
//        return packet;
//    }
//
//    public void setPacket(Packet packet) {
//        this.packet = packet;
//    }
//
//    public void setSeeds(Iterable<Seed> seeds) {
//        this.seeds = seeds;
//    }
//
//    public int getPacketId() {
//        return packetId;
//    }
//
//    public int getSeedId() {
//        return seedId;
//    }
//
//}
