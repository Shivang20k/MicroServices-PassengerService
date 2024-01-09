package com.micro.passenger.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="mail")
    private String mail;

    @Column(name="password")
    private String password;

    transient private List<FlightDetails> flightDetails;

    public Passenger updateAllDetails(Passenger passengerToUpdate) {
        this.name = passengerToUpdate.getName();
        this.phone = passengerToUpdate.getPhone();
        this.mail = passengerToUpdate.getMail();
        this.password = passengerToUpdate.getPassword();
        return this;
    }
}
