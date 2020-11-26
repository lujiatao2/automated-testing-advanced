package com.lujiatao.c09;

import java.util.ArrayList;
import java.util.List;

public class PersonTable {

    public static final PersonTable PERSON_TABLE = new PersonTable();
    private List<Person> persons = new ArrayList<>();

    private PersonTable() {
    }

    public List<Person> selectAllPersons() {
        return persons;
    }

    public Person selectPerson(String idCard) {
        int index = getIndex(idCard);
        return index == -1 ? null : persons.get(index);
    }

    public boolean insertPerson(Person person) {
        if (person == null) {
            return false;
        }
        int index = getIndex(person.getIdCard());
        if (index != -1) {
            return false;
        } else {
            return persons.add(person);
        }
    }

    public boolean updatePerson(Person person) {
        if (person == null) {
            return false;
        }
        int index = getIndex(person.getIdCard());
        if (index == -1) {
            return false;
        } else {
            return persons.set(index, person) != null;
        }
    }

    public boolean deletePerson(String idCard) {
        int index = getIndex(idCard);
        if (index == -1) {
            return false;
        } else {
            return persons.remove(index) != null;
        }
    }

    private int getIndex(String idCard) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getIdCard().equals(idCard)) {
                return i;
            }
        }
        return -1;
    }

}
