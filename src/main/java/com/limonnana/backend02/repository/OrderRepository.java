package com.limonnana.backend02.repository;



import com.limonnana.backend02.entity.Order;
import com.limonnana.backend02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT user_id from USER_ORDER uo where  uo.order_id = :orderId",
            nativeQuery = true)
    public Long getUserFromOrder(@Param("orderId") Long orderId);


}
