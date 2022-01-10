package com.cleverti.trainTicketMachine.controller;

import com.cleverti.trainTicketMachine.dto.TrainStationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(value="Train Tickets Machine Java API REST")
@CrossOrigin(origins="*")
public interface ITrainStationController {

    @GetMapping("/list")
    @ApiOperation(value="Returns a list of Stations")
    ResponseEntity<TrainStationResponse> getAllStations();


    @GetMapping("/filter/{stationName}")
    @ApiOperation(value="Returns a list of Stations by filter")
    ResponseEntity<TrainStationResponse> getStationsByName(@PathVariable @Valid final String stationName);


}
