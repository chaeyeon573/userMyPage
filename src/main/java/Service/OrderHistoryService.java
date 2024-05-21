package Service;

import Controller.ResourceNotFoundException;
import Entity.OrderHistory;
import Entity.OrderedItems;
import Repository.OrderHistoryRepository;
import Repository.OrderedItemsRepository;

import java.util.List;

@Service
public class OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;
    private final OrderedItemsRepository orderedItemsRepository;

    public OrderHistoryService(OrderHistoryRepository orderHistoryRepository, OrderedItemsRepository orderedItemsRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
        this.orderedItemsRepository = orderedItemsRepository;
    }

    public List<OrderHistory> getOrderHistoriesByUserId(Long userId) {
        return orderHistoryRepository.findByUserId(userId);
    }

    public OrderHistory createOrderHistory(OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }

    public OrderHistory updateOrderHistory(Long orderHistoryId, OrderHistory updatedOrderHistory) {
        OrderHistory orderHistory = orderHistoryRepository.findById(orderHistoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Order history not found"));
        orderHistory.setUserId(updatedOrderHistory.getUserId());
        orderHistory.setCreatedAt(updatedOrderHistory.getCreatedAt());
        orderHistory.setUpdatedAt(updatedOrderHistory.getUpdatedAt());
        return orderHistoryRepository.save(orderHistory);
    }

    public void deleteOrderHistory(Long orderHistoryId) throws ResourceNotFoundException {
        OrderHistory orderHistory = orderHistoryRepository.findById(orderHistoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Order history not found"));
        orderHistoryRepository.delete(orderHistory);
    }

    public List<OrderedItems> getOrderedItemsByOrderHistoryId(Long orderHistoryId) {
        return orderedItemsRepository.findByOrderHistoryId(orderHistoryId);
    }

    public OrderedItems createOrderedItem(OrderedItems orderedItem) {
        return orderedItemsRepository.save(orderedItem);
    }

    public OrderedItems updateOrderedItem(Long orderedItemId, OrderedItems updatedOrderedItem) throws ResourceNotFoundException {
        OrderedItems orderedItem = orderedItemsRepository.findById(orderedItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Ordered item not found"));
        orderedItem.setOrderHistoryId(updatedOrderedItem.getOrderHistoryId());
        orderedItem.setItemId(updatedOrderedItem.getItemId());
        orderedItem.setQuantity(updatedOrderedItem.getQuantity());
        orderedItem.setDescription(updatedOrderedItem.getDescription());
        orderedItem.setPrice(updatedOrderedItem.getPrice());
        orderedItem.setStock(updatedOrderedItem.getStock());
        orderedItem.setTotalPrice(updatedOrderedItem.getTotalPrice());
        orderedItem.setCreatedAt(updatedOrderedItem.getCreatedAt());
        orderedItem.setUpdatedAt(updatedOrderedItem.getUpdatedAt());
        return orderedItemsRepository.save(orderedItem);
    }

    public void deleteOrderedItem(Long orderedItemId) throws ResourceNotFoundException {
        OrderedItems orderedItem = orderedItemsRepository.findById(orderedItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Ordered item not found"));
        orderedItemsRepository.delete(orderedItem);
    }
}
