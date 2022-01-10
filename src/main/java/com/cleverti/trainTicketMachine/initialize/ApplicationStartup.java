package com.cleverti.trainTicketMachine.initialize;

import com.cleverti.trainTicketMachine.domain.TrainStation;
import com.cleverti.trainTicketMachine.repository.TrainStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private TrainStationRepository trainStationRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        insertTrainStations();
    }

    private void insertTrainStations() {
        trainStationRepository.saveAll(Arrays.asList(
                createStation("Aguas Santas - Palmilheira"),
                createStation("Agualva - Cacem"),
                createStation("Baixa da Banheira"),
                createStation("Barca da Amieira - Envendos"),
                createStation("Caldas da Rainha"),
                createStation("Cacela"),
                createStation("Cacia"),
                createStation("Dois Portos"),
                createStation("Ermesinde"),
                createStation("Ermida"),
                createStation("Faro"),
                createStation("Faria"),
                createStation("Gondarem"),
                createStation("Gouveia"),
                createStation("Jerumelo"),
                createStation("Lapa do Lobo"),
                createStation("Pacos de Brandao"),
                createStation("Paco de Arcos"),
                createStation("Sacavem"),
                createStation("Lisboa - Cais do Sodre"),
                createStation("Lisboa - Entrecampos"),
                createStation("Lisboa - Oriente"),
                createStation("Lisboa - Rossio"),
                createStation("Lisboa - Sete Rios"),
                createStation("Lisboa - Santa Apolonia")
        ));
    }

    private TrainStation createStation(String name){
        return TrainStation.builder().name(name).build();
    }
}
