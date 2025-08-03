package com.beratyesbek.springcloudgcpbqstoresfirestore.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;
import com.google.cloud.spring.data.firestore.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collectionName = "devices")
public class Device {

    @DocumentId
    private String id;
    private String name;
    private String type;

    @PropertyName("user_id")
    private String userId;
}
