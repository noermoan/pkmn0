package zininavo.pkmn.models;

import java.io.Serializable;

public class Student implements Serializable {
    public static final long serialVersionUID = 1L;

    String firstName;
    String surName;
    String familyName;
    String group;

    public Student(String firstName, String surName, String familyName, String group) {
        this.firstName = firstName;
        this.surName = surName;
        this.familyName = familyName;
        this.group = group;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Имя владельца: " + firstName + " Фамилия: " + surName +" Отчество: " + familyName + " Группа: " + group;
    }
}
