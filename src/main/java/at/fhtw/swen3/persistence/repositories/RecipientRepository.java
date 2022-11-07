package at.fhtw.swen3.persistence.repositories;


import at.fhtw.swen3.persistence.entity.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.util.resources.cldr.ext.LocaleNames_mg;

@Repository
public interface RecipientRepository extends JpaRepository<RecipientEntity, Long> {
}
