package kz.attractorschool.lesson54lab.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionResult {
    public String subId;
    public String message;
}
