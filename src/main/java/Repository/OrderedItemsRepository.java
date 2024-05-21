package Repository;

import Entity.OrderHistory;
import Entity.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedItemsRepository extends JpaRepository<OrderedItems, Long> {


    List<OrderedItems> findByOrderHistoryId(Long orderHistoryId);
}
