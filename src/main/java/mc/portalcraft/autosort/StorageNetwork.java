package mc.portalcraft.autosort;

import mc.portalcraft.autosort.container.InputContainer;
import mc.portalcraft.autosort.container.ItemContainer;
import mc.portalcraft.autosort.container.MiscContainer;
import mc.portalcraft.autosort.data.Network;
import mc.portalcraft.autosort.utils.Location;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.*;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class StorageNetwork {
    private String id;
    private UUID owner;

    private ArrayList<InputContainer> input_chests = new ArrayList<InputContainer>();
    private ArrayList<ItemContainer> sorting_chests = new ArrayList<ItemContainer>();
    private ArrayList<MiscContainer> misc_chests = new ArrayList<MiscContainer>();

    private String[] abc = {"a","b","c"};

    //abc[0] = "hi";
    //abc[1] = "hi 2.0";


    public StorageNetwork(String id, UUID owner) {
        this.id = id;
        this.owner = owner;
    }

    public StorageNetwork(Network net) {
        this.id = net.getId();
        this.owner = UUID.fromString(net.getOwner());

        for (InputContainer i: net.getInputContainers()) {
            input_chests.add(i);
        }

        for (ItemContainer i: net.getSortingContainers()) {
            sorting_chests.add(i);
        }

        for (MiscContainer i: net.getMiscContainers()) {
            misc_chests.add(i);
        }
    }

    public String getID() {
        return this.id;
    }

    public UUID getOwner() {
        return this.owner;
    }

    public ArrayList<InputContainer> getInputChests() {
        return input_chests;
    }

    public ArrayList<ItemContainer> getSortingChests() {
        return sorting_chests;
    }

    public ArrayList<MiscContainer> getMiscChests() {
        return misc_chests;
    }


    public void addInputChest(Location pos) {
        input_chests.add(new InputContainer(pos));
    }

    public void addItemChest(Location pos, String item) {
        sorting_chests.add(new ItemContainer(pos, item));
    }

    public void addMiscChest(Location pos, boolean takeOverflow) {
        misc_chests.add(new MiscContainer(pos, takeOverflow));
    }



    public void sortAll() {
        for (int i = 0; i < input_chests.size()-1; i++) {
            sort(input_chests.get(i).getPos());
        }
    }

    public void sort(Location pos) {
        if (input_chests.contains(pos)) {


            if (true) {

                // Main body

            }

            else {
                Bukkit.getLogger().warning("Block at the given position is not a chest: " + pos);
            }
        }

        else {
            Bukkit.getLogger().warning("Network contains no chest at the given position: " + pos.toString());
        }
    }


}