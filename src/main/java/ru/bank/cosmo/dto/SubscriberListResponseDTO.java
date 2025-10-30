package ru.bank.cosmo.dto;

import java.util.Set;

public record SubscriberListResponseDTO(
        Set<Long> subscribersList
) {
}