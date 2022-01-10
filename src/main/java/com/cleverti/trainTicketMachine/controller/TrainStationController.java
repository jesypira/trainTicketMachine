package com.cleverti.trainTicketMachine.controller;

import com.cleverti.trainTicketMachine.domain.TrainStation;
import com.cleverti.trainTicketMachine.dto.TrainStationResponse;
import com.cleverti.trainTicketMachine.service.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class TrainStationController implements ITrainStationController{

    @Autowired
    private TrainStationService trainStationService;

    public ResponseEntity<TrainStationResponse> getAllStations(){
        List<TrainStation> stationList = trainStationService.getAllStations();
        return ResponseEntity.ok().body(new TrainStationResponse(stationList));
    }

    public ResponseEntity<TrainStationResponse> getStationsByName(@PathVariable @NotNull final String stationName){
        List<TrainStation> stationList = trainStationService.getStationsByName(stationName);
        return ResponseEntity.ok().body(new TrainStationResponse(stationList));
    }
}
