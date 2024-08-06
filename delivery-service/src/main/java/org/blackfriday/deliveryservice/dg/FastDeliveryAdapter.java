package org.blackfriday.deliveryservice.dg;

import org.springframework.stereotype.Component;

@Component
public class FastDeliveryAdapter implements DeliveryAdapter {

    @Override
    public Long processDelivery(
            final String productName,
            final Long productCount,
            final String address
    ) {
        // delivery
        return 1111_1111_1111_1111L;
    }
}
