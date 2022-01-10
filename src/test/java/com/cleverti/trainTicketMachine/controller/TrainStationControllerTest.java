package com.cleverti.trainTicketMachine.controller;

import com.cleverti.trainTicketMachine.domain.TrainStation;
import com.cleverti.trainTicketMachine.dto.TrainStationResponse;
import com.cleverti.trainTicketMachine.service.TrainStationService;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TrainStationControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrainStationService trainStationServiceMock;

    @InjectMocks
    private TrainStationController trainStationControllerMock;

    @Test
    void whenStationsByName_returnsOkStatus(){
        final var stationName = "stationName";
        List<TrainStation> stations = new ArrayList<>();
        stations.add(TrainStation
                .builder()
                .name(stationName)
                .build());

        Mockito.when(trainStationServiceMock.getStationsByName(Mockito.anyString()))
                .thenReturn(stations);
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/stations/filters/"
                        +stationName, TrainStationResponse.class)
        ).thenReturn(new ResponseEntity(stations, HttpStatus.OK));

        ResponseEntity<TrainStationResponse> response = trainStationControllerMock.getStationsByName(stationName);
        List<TrainStation> resultList = response.getBody().getTrainStationsList();

        assertNotNull(resultList);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(resultList.stream().findFirst().get().getName().contains(stationName));
    }

    @Test
    void whenGetAllStations_returnsOkStatus(){
        List<TrainStation> stations = new ArrayList<>();
        stations.add(TrainStation
                .builder()
                .build());

        Mockito.when(trainStationServiceMock.getAllStations())
                .thenReturn(stations);
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/stations/list/", TrainStationResponse.class)
        ).thenReturn(new ResponseEntity(stations, HttpStatus.OK));

        ResponseEntity<TrainStationResponse> response = trainStationControllerMock.getAllStations();
        List<TrainStation> resultList = response.getBody().getTrainStationsList();

        assertNotNull(resultList);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
