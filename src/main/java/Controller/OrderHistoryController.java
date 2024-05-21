package Controller;

import Entity.OrderHistory;
import Service.OrderHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-histories")
public class OrderedHistoryController {
    private final OrderHistoryService orderHistoryService;

    public OrderHistoryController(OrderHistoryService orderHistoryService) {
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<OrderHistory>> getOrderHistoriesByUserId(@RequestParam Long userId) {
        List<OrderHistory> orderHistories = orderHistoryService.getOrderHistoriesByUserId(userId);
        return ResponseEntity.ok(orderHistories);
    }

    @PostMapping
    public ResponseEntity<OrderHistory> createOrderHistory(@RequestBody OrderHistory orderHistory) {
        OrderHistory createdOrderHistory = orderHistoryService.createOrderHistory(orderHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderHistory);
    }

    @PutMapping("/{orderHistoryId}")
    public ResponseEntity<OrderHistory> updateOrderHistory(@PathVariable Long orderHistoryId, @RequestBody OrderHistory orderHistory) {
        OrderHistory updatedOrderHistory = orderHistoryService.updateOrderHistory(orderHistoryId, orderHistory);
        return ResponseEntity.ok(updatedOrderHistory);
    }

    @DeleteMapping("/{orderHistoryId}")
    public ResponseEntity<Void> deleteOrderHistory(@PathVariable Long orderHistoryId) {
        orderHistoryService.deleteOrderHistory(orderHistoryId);
        return ResponseEntity.noContent().build();
    }
}
