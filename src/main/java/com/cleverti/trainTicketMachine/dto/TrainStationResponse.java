package com.cleverti.trainTicketMachine.dto;

import com.cleverti.trainTicketMachine.domain.TrainStation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TrainStationResponse {

    List<TrainStation> trainStationsList;

}
