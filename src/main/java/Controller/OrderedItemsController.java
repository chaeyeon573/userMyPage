package Controller;


import java.sql.Timestamp;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import Entity.OrderedItems;
import Repository.OrderedItemsRepository;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/orderedHistory")
public class OrderedItemsController {
    @Autowired
    private OrderedItemsRepository orderedItemsRepository;

    @GetMapping
    public List <OrderedItems> getAllOrderedItems() {
        return orderedItemsRepository.findAll();
    }

    @GetMapping("/orderedItems/{id}")
    public ResponseEntity < OrderedItems > getOrderedItemsById(@PathVariable(value = "id") Long orderedItemsId)
            throws ResourceNotFoundException {
        OrderedItems orderedItems = orderedItemsRepository.findById(orderedItemsId)
                .orElseThrow(() -> new ResourceNotFoundException("orderedItems not found for this id :: " + orderedItemsId));
        return ResponseEntity.ok().body(orderedItems);
    }

    @PostMapping("/orderedItems")
    public OrderedItems createOrderedItems(@RequestBody OrderedItems orderedItems) {
        return orderedItemsRepository.save(orderedItems);
    }

    @PutMapping("/orderedItems/{id}")
    public ResponseEntity < OrderedItems > updateOrderedItems(@PathVariable(value = "id") Long orderedItemsId,
                                                      @RequestBody OrderedItems orderedItemsDetails) throws ResourceNotFoundException {
        OrderedItems orderedItems = orderedItemsRepository.findById(orderedItemsId)
                .orElseThrow(() -> new ResourceNotFoundException("orderedItems not found for this id :: " + orderedItemsId));

        orderedItems.setItemId(orderedItemsDetails.getItemId());
        orderedItems.setQuantity(orderedItemsDetails.getQuantity());
        orderedItems.setDescription(orderedItemsDetails.getDescription());
        orderedItems.setPrice(orderedItemsDetails.getPrice());
        orderedItems.setStock(orderedItemsDetails.getStock());
        orderedItems.setTotalPrice(orderedItemsDetails.getTotalPrice());
        orderedItems.setUpdatedAt(orderedItemsDetails.getUpdatedAt());

        final OrderedItems updatedOrderedItems = orderedItemsRepository.save(orderedItems);
        return ResponseEntity.ok(updatedOrderedItems);
    }


    @DeleteMapping("/orderedItemss/{id}")
    public void deleteOrderedItems(@PathVariable(value = "id") Long orderedItemsId)
            throws ResourceNotFoundException {
        OrderedItems DeletedOrderedItems = orderedItemsRepository.findById(orderedItemsId)
                .orElseThrow(() -> new ResourceNotFoundException("orderedItems not found for this id :: " + orderedItemsId));

        orderedItemsRepository.delete(DeletedOrderedItems);


    }
}
