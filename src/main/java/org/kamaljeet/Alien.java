package org.kamaljeet;

import jakarta.persistence.*;

@Entity
@Table(name="Alien-Data")
public class Alien {
    @Id
    private int aId;
    //@Column(name="AlienName")
    private String aName;
    //@Transient
    private String Tech;

    public int getAid() {
        return aId;
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
                "aid=" + aId +
                ", aname='" + aName + '\'' +
                ", tech='" + Tech + '\'' +
                '}';
    }

    public void setAname(String aname) {
        this.aName = aname;
    }

    public void setTech(String tech) {
        this.Tech = tech;
    }


}
