package com.micro.passenger.service.service;

import com.micro.passenger.service.Repo.PassengerRepository;
import com.micro.passenger.service.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {


    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }

    @Override
    public Passenger updatePassenger(Long id, Passenger passengerToUpdate) {
        Passenger passenger = this.passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("NO PASSENGER FOR GIVEN ID"));
        Passenger updatedPassenger = passenger.updateAllDetails(passengerToUpdate);
        return this.passengerRepository.save(updatedPassenger);
    }

    @Override
    public Passenger getPassenger(Long id) {
        return this.passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("NO PASSENGER FOR GIVEN ID"));
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return this.passengerRepository.findAll();
    }

    @Override
    public String deletePassenger(Long id) {
        Passenger passenger = this.passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("NO PASSENGER FOR GIVEN ID"));
        this.passengerRepository.delete(
                this.passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("NO PASSENGER FOR GIVEN ID"))
        );
        return "DELETED SUCCESSFULLY : passenger.toString()";
    }
}
