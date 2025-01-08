package zininavo.pkmn.service;

import zininavo.pkmn.entity.StudentEntity;
import zininavo.pkmn.models.Card;

import java.util.List;
import java.util.UUID;

public interface CardService {
    List<Card> getAllCards();
    Card getCardByName(String name);
    Card getCardByPokemonOwner(StudentEntity studentEntity);
    Card getCardById(UUID id);
    Card saveCard(Card card);
}
