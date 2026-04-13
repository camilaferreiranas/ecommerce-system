package br.com.camilaferreiranas.orderservice.domain.enums;

public enum Status {

    CREATED,
    WAITING_PAYMENT,
    PAYMENT_CONFIRMED,
    PREPARING,
    SENT,
    FINISHED,
    CANCELLED,
    PAYMENT_DECLINED
}
