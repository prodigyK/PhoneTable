package com.prodigy.phones.service;

import com.prodigy.phones.dao.PhoneDao;
import com.prodigy.phones.model.Fleet;
import com.prodigy.phones.model.Phone;
import com.prodigy.phones.model.Subdivision;
import com.prodigy.phones.model.Vessel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;

    public List<Phone> getAllPhones() {
        return this.phoneDao.getAllPhones();
    }

    public List<Phone> getBySubdivision(int id) {
        return this.phoneDao.getBySubdivision(id);
    }

    public List<Subdivision> getSubdivisions() {
        return this.phoneDao.getSubdivisions();
    }

    public List<Subdivision> getSubdivisionsByParentId(int id){
        return this.phoneDao.getSubdivisionsByParentId(id);
    }

    public List<Subdivision> getSubdivisionsById(int id) {
        return this.phoneDao.getSubdivisionsById(id);
    }

    public Phone addPhone(Phone phone) {
        return this.phoneDao.addPhone(phone);
    }

    public Subdivision addSubdivision(Subdivision subdivision) {
        return this.phoneDao.addSubdivision(subdivision);
    }

    public boolean deletePhone(int id) {
        return this.phoneDao.deletePhone(id);
    }

    public boolean deleteSubdivision(int id) {
        return this.phoneDao.deleteSubdivision(id);
    }

    public List<Phone> searchByName(String userName) {
        return this.phoneDao.searchByName(userName);
    }

    public List<Fleet> getAllFleets() {
        return this.phoneDao.getAllFleets();
    }

    public List<Vessel> getAllVessels() {
        return this.phoneDao.getAllVessels();
    }

    public List<Subdivision> getTopSubdivisions() {
        return phoneDao.getTopSubdivisions();
    }
}
