package s9p125_Interfaces_Challenge_Try;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;


    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getWeapon() {
        return weapon;
    }


    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }


    public int getHitPoints() {
        return hitPoints;
    }


    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }


    public int getStrength() {
        return strength;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }


    /* Add all attributes to the values List.  */
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, name);
        /* Convert hitPoints and strength to String then add them to the values list.  */
        values.add(1, "" + hitPoints);
        values.add(2, "" + strength);
        values.add(3, weapon);
        return values;
    }


    /* Retrieve all values from the values list.  */
    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0) {
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            strength = Integer.parseInt(savedValues.get(2));
            weapon = savedValues.get(3);
        }
    }


    /* Convert the object to String format so I can print the object.  */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + "'" +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + "'" +
                '}';
    }

}
