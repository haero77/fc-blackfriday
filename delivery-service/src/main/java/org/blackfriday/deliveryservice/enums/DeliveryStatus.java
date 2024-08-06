package org.blackfriday.deliveryservice.enums;

public enum DeliveryStatus {

    REQUESTED,
    IN_DELIVERY,
    COMPLETED,
    ;

    public boolean isRequested() {
        return this == REQUESTED;
    }

    public boolean isInDelivery() {
        return this == IN_DELIVERY;
    }

    public boolean isCompleted() {
        return this == COMPLETED;
    }
}
