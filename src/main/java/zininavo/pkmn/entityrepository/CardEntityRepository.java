package zininavo.pkmn.entityrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import zininavo.pkmn.entity.CardEntity;
import zininavo.pkmn.entity.StudentEntity;

import java.util.Optional;
import java.util.UUID;

public interface CardEntityRepository extends JpaRepository<CardEntity, UUID> {

    // Получение карточки по имени
    Optional<CardEntity> findByName(String name);

    // Получение карточки по владельцу
    Optional<CardEntity> findByPokemonOwner(StudentEntity studentEntity);
}
