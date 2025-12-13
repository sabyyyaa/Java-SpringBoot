package org.kamaljeet;

import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name="Alien-Data")
public class Alien {
    @Id
    private int aId;
    //@Column(name="AlienName")     //will change the column name
    private String aName;
    //@Transient    //to ignoer this attribute , and it will not be included in table as column
    private String Tech;
    @ManyToMany
    private List<Laptop> laptops;

    public int getAid() {
        return aId;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public String getAname() {
        return aName;
    }

    public String getTech() {
        return Tech;
    }

    public void setAid(int aid) {
        this.aId = aid;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", Tech='" + Tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }

    public void setAname(String aname) {
        this.aName = aname;
    }

    public void setTech(String tech) {
        this.Tech = tech;
    }


}
