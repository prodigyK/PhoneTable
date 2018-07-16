package com.prodigy.phones.dao;

import com.prodigy.phones.model.Fleet;
import com.prodigy.phones.model.Phone;
import com.prodigy.phones.model.Subdivision;
import com.prodigy.phones.model.Vessel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PhoneDaoImpl implements PhoneDao {

    private static final Logger log = LoggerFactory.getLogger(PhoneDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;


    public List<Phone> getAllPhones() {
        log.info("getAllPhones()");
        return this.entityManager.createQuery("SELECT p FROM Phone p")
                .getResultList();
    }

    public List<Phone> getBySubdivision(int id) {
        log.info("getBySubdivision()");
        return this.entityManager.createQuery("SELECT p FROM Phone p WHERE p.subdivision.id=?1")
                .setParameter(1, id)
                .getResultList();
    }

    public List<Subdivision> getSubdivisions() {
        log.info("getSubdivisions()");
        return this.entityManager.createQuery("SELECT s FROM Subdivision s ORDER BY s.ordering ASC")
                .getResultList();
    }

    public List<Subdivision> getSubdivisionsByParentId(int id) {
        log.info("getSubdivisionsByParentId()");
        return this.entityManager.createQuery("SELECT s FROM Subdivision s WHERE s.parent.id=?1 ORDER BY s.ordering ASC")
                .setParameter(1, id)
                .getResultList();
    }

    public List<Subdivision> getSubdivisionsById(int id) {
        log.info("getSubdivisionsById()");
        return this.entityManager.createQuery("SELECT s FROM Subdivision s WHERE s.id=?1")
                .setParameter(1, id)
                .getResultList();
    }

    public Phone addPhone(Phone phone) {

        if (phone.isNew()) {
            log.info("Add new phone: {} - {}", phone.getUserName(), phone.getNumber());
            this.entityManager.persist(phone);
            return phone;
        } else {
            log.info("Update phone: {} - {}", phone.getUserName(), phone.getNumber());
            return this.entityManager.merge(phone);
        }

    }

    public Subdivision addSubdivision(Subdivision subdivision) {

        if (subdivision.isNew()) {
            log.info("Add new subdivision: {} - {}", subdivision.getName());
            this.entityManager.persist(subdivision);
            return subdivision;
        } else {
            log.info("Update subdivision: {} - {}", subdivision.getName());
            return this.entityManager.merge(subdivision);
        }
    }

    public boolean deletePhone(int id) {
        log.info("Delete phone: {}", id);
        return this.entityManager.createQuery("DELETE FROM Phone p WHERE p.id=?1")
                .setParameter(1, id)
                .executeUpdate() != 0;
    }

    public boolean deleteSubdivision(int id) {
        log.info("Delete subdivision: {}", id);
        return this.entityManager.createQuery("DELETE FROM Subdivision s WHERE s.id=?1")
                .setParameter(1, id)
                .executeUpdate() != 0;
    }

    public List<Phone> searchByName(String userName) {
        log.info("Search by username: {}", userName);
        List<Phone> phoneList = this.entityManager.createQuery("SELECT p FROM Phone p WHERE p.userName LIKE '%" + userName + "%'")
                .getResultList();
        if(phoneList.size() == 0){
            phoneList = this.entityManager.createQuery("SELECT p FROM Phone p WHERE p.number LIKE '%" + userName + "%'")
                    .getResultList();
        }
        return phoneList;
    }

    public List<Fleet> getAllFleets() {
        log.info("getAllFleets()");
        return this.entityManager.createQuery("SELECT f FROM Fleet f")
                .getResultList();
    }

    public List<Vessel> getAllVessels() {
        log.info("getAllVessels()");
        return this.entityManager.createQuery("SELECT v FROM Vessel v")
                .getResultList();
    }

    public List<Subdivision> getTopSubdivisions() {
        return entityManager.createQuery("SELECT s FROM Subdivision s WHERE s.parent is NULL ORDER BY s.ordering")
                .getResultList();
    }
}
