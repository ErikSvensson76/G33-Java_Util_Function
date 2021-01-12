package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pet {
    private final int id;
    private String name;
    private LocalDate birthDate;
    private boolean alive;

    public Pet(int id, String name, LocalDate birthDate, boolean alive) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.alive = alive;
    }

    public String idAndName(){
        return this.getId() + ". " + this.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return getId() == pet.getId() && isAlive() == pet.isAlive() && Objects.equals(getName(), pet.getName()) && Objects.equals(getBirthDate(), pet.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthDate(), isAlive());
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", alive=" + alive +
                '}';
    }
}
