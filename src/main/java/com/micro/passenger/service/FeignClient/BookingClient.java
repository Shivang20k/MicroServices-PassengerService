package com.micro.passenger.service.FeignClient;

import com.micro.passenger.service.entity.FlightDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BOOKING-SERVICE") // SINCE WE HAVE BOOKING SERVICE APP. NAME IN SERVICE REGISTRY SO USE THIS INSTEAD OF HARD CODED URL
public interface BookingClient {

    @GetMapping("/booking/passengerId/{passengerId}")               //this mapping url should be same as in booking service which is already there
    List<FlightDetails> getFlightBookingDetailsForPassengerId(@PathVariable Long passengerId);
}
