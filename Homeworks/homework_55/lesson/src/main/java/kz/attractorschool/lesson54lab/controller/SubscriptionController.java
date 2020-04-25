package kz.attractorschool.lesson54lab.controller;

import kz.attractorschool.lesson54lab.dto.SubscriptionDTO;
import kz.attractorschool.lesson54lab.dto.SubscriptionResult;
import kz.attractorschool.lesson54lab.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<SubscriptionDTO> findSubscriptions(@RequestParam String email, @ApiIgnore Pageable pageable) {
        return subscriptionService.findByEmail(email, pageable);
    }

    @PostMapping(value = "/{subId}/unsubscribe")
    public SubscriptionResult unsubscribe(@PathVariable String subId, @RequestParam String email) {
        return subscriptionService.unsubscribe(subId, email);
    }
}
