package com.prodigy.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone extends BaseEntity {

    @Column(name = "number")
    private String number;

    @Column(name = "username")
    private String userName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "div_id")
    private Subdivision subdivision;

    @Column(name = "boss")
    private Boolean boss;

    public Phone() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }
}
