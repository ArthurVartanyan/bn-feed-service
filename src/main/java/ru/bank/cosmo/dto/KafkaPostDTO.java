package ru.bank.cosmo.dto;

import java.time.LocalDateTime;

public record KafkaPostDTO(Long postId, Long companyId, LocalDateTime createdAt) {
}