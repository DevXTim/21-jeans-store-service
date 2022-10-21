package kg.jeansstoreservice.jeansstoreservice.controllers;

import kg.jeansstoreservice.jeansstoreservice.models.CartRequest;
import kg.jeansstoreservice.jeansstoreservice.models.CartResponse;
import kg.jeansstoreservice.jeansstoreservice.models.Item;
import kg.jeansstoreservice.jeansstoreservice.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/create")
    public Item create(@RequestBody Item item) {
        return storeService.createItem(item);
    }

    @GetMapping("/list")
    public List<Item> getList() {
        return storeService.getListOfItems();
    }

    @GetMapping("/list/{itemId}")
    public Item getItemById(@PathVariable long itemId) {
        return storeService.getItemById(itemId);
    }

    @PutMapping("/update")
    public Item update(@RequestBody Item item) {
        return storeService.updateItem(item);
    }

    @PostMapping("/calculate")
    public List<CartResponse> calculateItems(@RequestBody List<CartRequest> cartRequestList) {
        return storeService.calculateItems(cartRequestList);
    }
}
