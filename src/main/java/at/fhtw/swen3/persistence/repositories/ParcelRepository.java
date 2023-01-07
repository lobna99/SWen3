package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity,Long> {

    @Override
    List<ParcelEntity> findAll();

    ParcelEntity findByTrackingId(String trackingId);
}
