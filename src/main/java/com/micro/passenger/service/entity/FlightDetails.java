package com.micro.passenger.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDetails {
    private Long id;
    private String name;
    private String fromCity;
    private String toCity;
    private String PNR;
}
