package kg.jeansstoreservice.jeansstoreservice.services.impl;

import kg.jeansstoreservice.jeansstoreservice.models.CartRequest;
import kg.jeansstoreservice.jeansstoreservice.models.CartResponse;
import kg.jeansstoreservice.jeansstoreservice.models.Item;
import kg.jeansstoreservice.jeansstoreservice.repository.StoreRepository;
import kg.jeansstoreservice.jeansstoreservice.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Item createItem(Item item) {
        item = storeRepository.save(item);
        return item;
    }

    @Override
    public List<Item> getListOfItems() {
        return storeRepository.findAll();
    }

    @Override
    public Item getItemById(long itemId) {
        return storeRepository.findAll()
                .stream()
                .filter(item -> item.getItemId() == itemId)
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public Item updateItem(Item item) {
        item = storeRepository.save(item);
        return item;
    }

    @Override
    public List<CartResponse> calculateItems(List<CartRequest> cartRequestList) {
        List<CartResponse> cartResponsesList = new ArrayList<>();
        if (!cartRequestList.isEmpty()) {
            for (CartRequest cartRequest : cartRequestList) {
                if (getItemById(cartRequest.getItemId()).isAvailability()) {
                    CartResponse tempResponse = new CartResponse();
                    tempResponse.setCartRequest(cartRequest);
                    tempResponse.setTotalPrice(cartRequest.getQuantity() * getItemById(cartRequest.getItemId()).getPrice());
                    cartResponsesList.add(tempResponse);
                }
            }
        }
        return cartResponsesList;
    }
}
