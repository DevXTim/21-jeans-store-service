package kg.jeansstoreservice.jeansstoreservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartResponse {
    private CartRequest cartRequest;
    private double totalPrice;
}
