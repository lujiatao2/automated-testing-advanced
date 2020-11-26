package com.lujiatao.c09;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDAO personDao = new PersonDAOImpl();

    @Override
    public List<Person> getAllPersons() {
        return personDao.selectAllPersons();
    }

    @Override
    public Person getPerson(String idCard) {
        return personDao.selectPerson(idCard);
    }

    @Override
    public boolean addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @Override
    public boolean modifyPerson(Person person) {
        return personDao.updatePerson(person);
    }

    @Override
    public boolean delPerson(String idCard) {
        return personDao.deletePerson(idCard);
    }

}
