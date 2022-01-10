package com.cleverti.trainTicketMachine.service;

import com.cleverti.trainTicketMachine.domain.TrainStation;

import java.util.List;

public interface TrainStationService {

    List<TrainStation> getStationsByName(final String request);

    List<TrainStation> getAllStations();
}
