package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity,Long> {

}
