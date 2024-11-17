package com.food.ordering.system.domain.entity;

/**
 * By extending this class we want to mark the aggregate root of an aggregate
 */
public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
}
