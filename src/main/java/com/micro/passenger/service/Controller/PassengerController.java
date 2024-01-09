package com.micro.passenger.service.Controller;

import com.micro.passenger.service.FeignClient.BookingClient;
import com.micro.passenger.service.entity.FlightDetails;
import com.micro.passenger.service.entity.Passenger;
import com.micro.passenger.service.service.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerServiceImpl passengerServiceImpl;

    @Autowired
    BookingClient bookingClient;

    @PostMapping("/create")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerServiceImpl.createPassenger(passenger);
    }

    @PutMapping("/update/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerServiceImpl.updatePassenger(id, passenger);
    }

    @GetMapping("/")
    public List<Passenger> getAllPassengers() {
        return passengerServiceImpl.getAllPassengers()
                .stream()
                .map(p ->
                    { p.setFlightDetails(bookingClient.getFlightBookingDetailsForPassengerId(p.getId()));
                      return p;
                    })
                .toList();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerFromId(@PathVariable Long id) {
        Passenger passenger = passengerServiceImpl.getPassenger(id);
        List< FlightDetails> flightsForPassenger = bookingClient.getFlightBookingDetailsForPassengerId(id);
        passenger.setFlightDetails(flightsForPassenger);
        return passenger;
    }

    @GetMapping("/details/{id}")
    public Passenger getPassengerFromWithoutFlightDetails(@PathVariable Long id) {
        Passenger passenger = passengerServiceImpl.getPassenger(id);
        return passenger;
    }

    @DeleteMapping ("/delete/{id}")
    public String deletePassengerFromId(@PathVariable Long id) {
        return passengerServiceImpl.deletePassenger(id);
    }

}
