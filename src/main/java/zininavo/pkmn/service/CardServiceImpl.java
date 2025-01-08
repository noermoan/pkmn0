package zininavo.pkmn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zininavo.pkmn.dao.CardDao;
import zininavo.pkmn.entity.CardEntity;
import zininavo.pkmn.entity.StudentEntity;
import zininavo.pkmn.models.Card;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    @Autowired
    private final CardDao cardDao;

    @Override
    public List<Card> getAllCards() {
        return cardDao.getAll().stream().map(Card::fromEntity).toList();
    }

    @Override
    public Card getCardByName(String name) {
        return Card.fromEntity(cardDao.getByName(name));
    }

    @Override
    public Card getCardByPokemonOwner(StudentEntity studentEntity) {
        return Card.fromEntity(cardDao.getByPokemonOwner(studentEntity));
    }

    @Override
    public Card getCardById(UUID id) {
        return Card.fromEntity(cardDao.getById(id));
    }

    @Override
    public Card saveCard(Card card) {
        if (cardDao.cardExists(String.valueOf(card))) {
            throw new IllegalArgumentException("Карта уже есть в базе данных");
        }
        if (card.getPokemonOwner() == null) {
            throw new IllegalArgumentException("У карты нет владельца");
        }
        return Card.fromEntity(cardDao.saveCard(CardEntity.toEntity(card)));
    }
}
