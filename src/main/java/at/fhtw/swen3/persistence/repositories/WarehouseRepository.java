package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity,Long> {

    @Override
    List<WarehouseEntity> findAll();

    WarehouseEntity findByLevel(int level);

    WarehouseEntity findByCode(String code);
}
