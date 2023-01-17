package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Long> {


    TransferwarehouseEntity findByCode(String code);


    @Query(value= "SELECT * FROM transferwarehouse_entity WHERE ST_DWithin((SELECT point from t_geocoordinate where id = transferwarehouse_entity.fk_coordinates), ST_GeomFromWKB((SELECT point from t_geocoordinate where id = (SELECT t_recipient.location_coordinates_id from t_recipient where t_recipient.id = :recipient))),1) ORDER BY ST_Distance((SELECT point from t_geocoordinate where id = transferwarehouse_entity.fk_coordinates), ST_GeomFromWKB((SELECT point from t_geocoordinate where id = (SELECT t_recipient.location_coordinates_id from t_recipient where t_recipient.id = :recipient))));", nativeQuery = true)
    List<TransferwarehouseEntity> getClosestHop(@Param("recipient")long recipient);

    @Query(value ="SELECT ST_Distance((SELECT point from t_geocoordinate where id =:id), ST_GeomFromWKB((SELECT point from t_geocoordinate where id = (SELECT t_recipient.location_coordinates_id from t_recipient where t_recipient.id = :recipient))));", nativeQuery = true)
    Double getDistance(@Param("id")long id,@Param("recipient") long recipient);

}