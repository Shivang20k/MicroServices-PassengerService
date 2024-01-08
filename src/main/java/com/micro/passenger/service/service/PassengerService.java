package com.micro.passenger.service.service;

import com.micro.passenger.service.entity.Passenger;

import java.util.List;

public interface PassengerService {
    public Passenger createPassenger(Passenger passenger);

    public Passenger updatePassenger(Long id, Passenger passengerToUpdate);

    public Passenger getPassenger(Long id);

    public List<Passenger> getAllPassengers();

    public String deletePassenger(Long id);
}
