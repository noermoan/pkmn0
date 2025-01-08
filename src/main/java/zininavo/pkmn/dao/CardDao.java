package zininavo.pkmn.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import zininavo.pkmn.entity.CardEntity;
import zininavo.pkmn.entity.StudentEntity;
import zininavo.pkmn.entityrepository.CardEntityRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public final class CardDao {
    private final CardEntityRepository cardEntityRepository;

    public List<CardEntity> getAll() {
        return cardEntityRepository.findAll();
    }

    public CardEntity getByName(String name) {
        return cardEntityRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Card not found with name: " + name));
    }

    public CardEntity getByPokemonOwner(StudentEntity studentEntity) {
        return cardEntityRepository.findByPokemonOwner(studentEntity)
                .orElseThrow(() -> new IllegalArgumentException("Card not found for the given owner"));
    }

    public CardEntity getById(UUID id) {
        return cardEntityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Card not found with ID: " + id));
    }

    public CardEntity saveCard(CardEntity cardEntity) {
        return cardEntityRepository.save(cardEntity);
    }

    public boolean cardExists(String cardName) {
        return cardEntityRepository.findByName(cardName).isPresent();
    }
}
