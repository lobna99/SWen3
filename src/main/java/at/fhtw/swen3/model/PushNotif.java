package at.fhtw.swen3.model;

import at.fhtw.swen3.services.dto.HopArrival;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PushNotif {
    String code;
    String hopArrival;
}
