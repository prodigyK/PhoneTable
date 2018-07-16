package com.prodigy.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "vessels")
public class Vessel extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone_ukraine")
    private String phoneUkraine;

    @Column(name = "phone_abroad")
    private String phoneAbroad;

    @Column(name = "phone_travel")
    private String phoneTravel;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fleet")
    private Fleet fleet;

    public Vessel() {
    }

    public Vessel(Integer id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneUkraine() {
        return phoneUkraine;
    }

    public void setPhoneUkraine(String phoneUkraine) {
        this.phoneUkraine = phoneUkraine;
    }

    public String getPhoneAbroad() {
        return phoneAbroad;
    }

    public void setPhoneAbroad(String phoneAbroad) {
        this.phoneAbroad = phoneAbroad;
    }

    public String getPhoneTravel() {
        return phoneTravel;
    }

    public void setPhoneTravel(String phoneTravel) {
        this.phoneTravel = phoneTravel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }
}
