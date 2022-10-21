package kg.jeansstoreservice.jeansstoreservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartRequest {
    private long itemId;
    private int quantity;
}
