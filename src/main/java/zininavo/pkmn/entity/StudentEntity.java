package zininavo.pkmn.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import zininavo.pkmn.models.Student;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "student_group")
    private String group;

    @OneToMany(mappedBy = "pokemonOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardEntity> cards;

    public static StudentEntity toEntity(Student student) {
        if (student != null) {
            return StudentEntity.builder()
                    .id(UUID.randomUUID())
                    .surName(student.getSurName())
                    .firstName(student.getFirstName())
                    .familyName(student.getFamilyName())
                    .group(student.getGroup())
                    .build();
        }
        return null;
    }
}
