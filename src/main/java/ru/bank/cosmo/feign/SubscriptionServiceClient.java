package ru.bank.cosmo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.bank.cosmo.dto.SubscriberListResponseDTO;

@FeignClient(
        name = "subscription-service",
        url = "${subscription.service.url}",
        path = "/api/subscription"
)
public interface SubscriptionServiceClient {

    @GetMapping("/subscribers/{companyId}")
    SubscriberListResponseDTO getSubscribers(@PathVariable("companyId") Long companyId);
}
