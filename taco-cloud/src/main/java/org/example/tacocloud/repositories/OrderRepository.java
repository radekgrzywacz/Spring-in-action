package org.example.tacocloud.repositories;

import org.example.tacocloud.domains.TacoOrder;

public interface OrderRepository  {
    TacoOrder save(TacoOrder order);
}