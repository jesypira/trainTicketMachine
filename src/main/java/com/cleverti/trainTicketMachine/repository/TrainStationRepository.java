package com.cleverti.trainTicketMachine.repository;

import com.cleverti.trainTicketMachine.domain.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainStationRepository extends JpaRepository<TrainStation, Long>, JpaSpecificationExecutor<TrainStation> {


}
