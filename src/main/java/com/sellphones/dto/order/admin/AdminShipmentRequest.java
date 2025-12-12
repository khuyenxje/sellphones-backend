package com.sellphones.dto.order.admin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sellphones.dto.address.AddressRequest;
import com.sellphones.entity.order.DeliveryPartner;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminShipmentRequest {

    private String code;

    private DeliveryPartner partner;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate expectedDeliveryDate;

    private Map<Long, Map<String, Long>> inventoryItems;

    private AddressRequest pickupAddress;

    private BigDecimal shippingFee;

}
