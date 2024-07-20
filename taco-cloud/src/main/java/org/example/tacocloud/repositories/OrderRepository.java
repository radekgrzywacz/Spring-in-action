package org.example.tacocloud.repositories;

import org.example.tacocloud.domains.TacoOrder;
import org.example.tacocloud.domains.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
    //List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}