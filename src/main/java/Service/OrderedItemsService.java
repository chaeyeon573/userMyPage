package Service;

import Repository.OrderHistoryRepository;
import Repository.OrderedItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderedItemsService {
    private final OrderedItemsRepository orderedItemsRepository;
    private final OrderHistoryRepository orderHistoryRepository;

    public OrderedItemsService(OrderedItemsRepository orderedItemsRepository, OrderHistoryRepository orderHistoryRepository) {
        this.orderedItemsRepository = orderedItemsRepository;
    }

    public Li
}
