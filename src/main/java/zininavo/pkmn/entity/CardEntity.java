package zininavo.pkmn.entity;

import jakarta.persistence.*;
import lombok.*;
import zininavo.pkmn.models.AttackSkill;
import zininavo.pkmn.models.Card;
import zininavo.pkmn.models.EnergyType;
import zininavo.pkmn.models.PokemonStage;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cards")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Используем Long в качестве идентификатора

    @Enumerated(EnumType.STRING)
    private PokemonStage pokemonStage;

    private String name;
    private int hp;

    @Enumerated(EnumType.STRING)
    private EnergyType pokemonType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evolves_from_id")
    private CardEntity evolvesFrom;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AttackSkill> skills;

    @Enumerated(EnumType.STRING)
    private EnergyType weaknessType;

    @Enumerated(EnumType.STRING)
    private EnergyType resistanceType;

    private String retreatCost;
    private String gameSet;
    private char regulationMark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_owner_id")
    private StudentEntity pokemonOwner; // Связь с StudentEntity
    @Column(name = "card_number")
    private String number;

    public static CardEntity toEntity(Card card) {
        if (card != null) {
            return CardEntity.builder()
                    .pokemonStage(card.getPokemonStage())
                    .name(card.getName())
                    .hp(card.getHp())
                    .pokemonType(card.getPokemonType())
                    .evolvesFrom(toEntity(card.getEvolvesFrom()))
                    .skills(card.getSkills())
                    .weaknessType(card.getWeaknessType())
                    .resistanceType(card.getResistanceType())
                    .retreatCost(card.getRetreatCost())
                    .gameSet(card.getGameSet())
                    .regulationMark(card.getRegulationMark())
                    .pokemonOwner(StudentEntity.toEntity(card.getPokemonOwner()))
                    .number(card.getNumber())
                    .build();
        }
        return null;
    }
}
