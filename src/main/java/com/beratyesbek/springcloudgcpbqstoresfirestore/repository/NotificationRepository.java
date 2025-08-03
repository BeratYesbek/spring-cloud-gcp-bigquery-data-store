package com.beratyesbek.springcloudgcpbqstoresfirestore.repository;

import com.beratyesbek.springcloudgcpbqstoresfirestore.entity.Notification;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends DatastoreRepository<Notification, String> {

}
