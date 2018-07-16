package com.prodigy.phones.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fleets")
public class Fleet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fleet")
    private List<Vessel> vessels = new ArrayList<Vessel>();

    public Fleet() {
    }

    public Fleet(Integer id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
