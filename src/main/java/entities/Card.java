package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private int id;
    @Column(name="total")
    private String total;
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "cards")
    private List<Item> items = new ArrayList<>();


    public Card(String total, String name) {
        this.total = total;
        this.name = name;
    }

    public void addItem(Item item){
        items.add(item);
    }


}
