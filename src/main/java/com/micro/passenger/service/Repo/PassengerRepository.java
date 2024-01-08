package com.micro.passenger.service.Repo;

import com.micro.passenger.service.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    public Optional<Passenger> findByMail(String email);

}
