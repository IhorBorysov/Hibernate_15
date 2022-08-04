package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;

    @Column(name = "item_total")
    private String itemtotal;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_item", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> cards = new ArrayList<>();

    public Item(String itemtotal) {
        this.itemtotal = itemtotal;
    }

    public void addCard(Card card){
        cards.add(card);
    }
}
