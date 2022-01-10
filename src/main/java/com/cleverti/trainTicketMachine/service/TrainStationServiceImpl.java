package com.cleverti.trainTicketMachine.service;


import com.cleverti.trainTicketMachine.domain.TrainStation;
import com.cleverti.trainTicketMachine.repository.TrainStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cleverti.trainTicketMachine.util.StringUtil.compare;
import static com.cleverti.trainTicketMachine.util.StringUtil.formatToCharArray;

@Service
public class TrainStationServiceImpl implements TrainStationService {

    @Autowired
    private TrainStationRepository repository;

    @Override
    public List<TrainStation> getStationsByName(final String request) {
        return findByName(request,repository.findAll());
    }

    @Override
    public List<TrainStation> getAllStations() {
        return repository.findAll();
    }

    private List<TrainStation> findByName(String name, List<TrainStation> list){
        List<TrainStation> result  = list.stream().filter(station ->
                compare(formatToCharArray(name),formatToCharArray(station.getName())) > -1
        ).limit(5)
         .collect(Collectors.toList());
        return result;
    }


}
