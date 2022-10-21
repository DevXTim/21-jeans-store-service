package kg.jeansstoreservice.jeansstoreservice.models;

import kg.jeansstoreservice.jeansstoreservice.models.enums.GenderEnum;
import kg.jeansstoreservice.jeansstoreservice.models.enums.SizeEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="items")
@Getter
@Setter
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    @Enumerated(EnumType.STRING)
    private SizeEnum size;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private double price;
    private boolean availability;
    private String color;
    private String category;
}
