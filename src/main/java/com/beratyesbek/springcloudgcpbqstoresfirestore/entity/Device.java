package com.beratyesbek.springcloudgcpbqstoresfirestore.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @DocumentId
    private String id;
    private String name;
    private String type;
    @PropertyName("user_id")
    private String userId;
    private String status;
    private String lastSeen;
}
