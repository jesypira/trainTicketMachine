package com.cleverti.trainTicketMachine.service;

import com.cleverti.trainTicketMachine.domain.TrainStation;
import com.cleverti.trainTicketMachine.repository.TrainStationRepository;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class TrainStationServiceTest  {

    @Mock
    private TrainStationRepository repository;

    @InjectMocks
    private TrainStationServiceImpl trainStationServiceMock;

    @Test
    void givenName_whenGetStationsByName_returnsFiveMatchersMax(){
        final var stationName = "lis";
        List<TrainStation> emptyList = new ArrayList<>();
        emptyList.add(TrainStation.builder()
                        .name(stationName)
                        .build());
        Mockito.when(repository.findAll()).thenReturn(emptyList);
        List<TrainStation> resultList = trainStationServiceMock.getStationsByName(stationName);
        assertNotNull(resultList);
        assertTrue(resultList.size()<=5);
        assertTrue(resultList.stream().findFirst().get().getName().contains(stationName));
    }

    @Test
    void givenName_whenGetStationsByName_returnsEmptyList(){
        List<TrainStation> emptyList = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(emptyList);
        final var stationName  = "lis";
        List<TrainStation> resultList = trainStationServiceMock.getStationsByName(stationName);
        assertEquals(0, resultList.size());
    }

    @Test
    void whenFindAll_returnsAllStations(){
        List<TrainStation> allStations = new ArrayList<>();
        allStations.add(TrainStation.builder()
                .build());
        Mockito.when(repository.findAll()).thenReturn(allStations);
        List<TrainStation> resultList = trainStationServiceMock.getAllStations();
        assertNotNull(resultList);
        assertEquals(allStations, resultList);
    }

}
