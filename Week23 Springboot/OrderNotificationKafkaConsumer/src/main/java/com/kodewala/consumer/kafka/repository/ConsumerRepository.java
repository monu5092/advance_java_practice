package com.kodewala.consumer.kafka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.consumer.kafka.entity.ConsumerNotification;

@Repository
public interface ConsumerRepository extends CrudRepository<ConsumerNotification, Long> {

}
