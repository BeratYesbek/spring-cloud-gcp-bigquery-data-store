package com.beratyesbek.springcloudgcpbqstoresfirestore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    private String id;
    private String name;
    private Integer quantity;
    private String productId;
    private String warehouseId;
    private String locationId;
}
