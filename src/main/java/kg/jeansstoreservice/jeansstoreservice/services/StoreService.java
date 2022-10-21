package kg.jeansstoreservice.jeansstoreservice.services;

import kg.jeansstoreservice.jeansstoreservice.models.CartRequest;
import kg.jeansstoreservice.jeansstoreservice.models.CartResponse;
import kg.jeansstoreservice.jeansstoreservice.models.Item;

import java.util.List;

public interface StoreService {
    Item createItem(Item item);

    List<Item> getListOfItems();

    Item updateItem(Item item);

    List<CartResponse> calculateItems(List<CartRequest> cartRequestList);

    Item getItemById(long itemId);
}
