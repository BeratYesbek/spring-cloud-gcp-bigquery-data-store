package com.beratyesbek.springcloudgcpbqstoresfirestore.repository;

import com.beratyesbek.springcloudgcpbqstoresfirestore.entity.Device;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends FirestoreReactiveRepository<Device> {

}
