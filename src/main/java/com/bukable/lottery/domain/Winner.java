package com.bukable.lottery.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    private String city;

    private int winningAmount;

    public Winner() {
    }

    public Winner(String name, int age, String city, int winningAmount) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.winningAmount = winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner that = (Winner) o;
        return age == that.age && winningAmount == that.winningAmount && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, city, winningAmount);
    }

}
