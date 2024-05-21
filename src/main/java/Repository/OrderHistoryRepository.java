package Repository;

import Entity.OrderHistory;
import Entity.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    List<OrderedItems> findByUserEmail(String userEmail);

    List<OrderHistory> findByUserId(Long userId);
}
