package com.prodigy.phones.service;

import com.prodigy.phones.model.Fleet;
import com.prodigy.phones.model.Phone;
import com.prodigy.phones.model.Subdivision;
import com.prodigy.phones.model.Vessel;

import java.util.List;

public interface PhoneService {

    List<Phone> getAllPhones();

    List<Phone> getBySubdivision(int id);

    List<Subdivision> getSubdivisions();

    List <Subdivision> getSubdivisionsByParentId(int id);

    List<Subdivision> getSubdivisionsById(int id);

    List<Subdivision> getTopSubdivisions();

    Phone addPhone(Phone phone);

    Subdivision addSubdivision(Subdivision subdivision);

    boolean deletePhone(int id);

    boolean deleteSubdivision(int id);

    List<Phone> searchByName(String userName);

    List<Fleet> getAllFleets();

    List<Vessel> getAllVessels();


}
