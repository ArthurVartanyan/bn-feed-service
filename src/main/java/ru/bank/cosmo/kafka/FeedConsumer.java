package ru.bank.cosmo.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.bank.cosmo.dto.KafkaPostDTO;
import ru.bank.cosmo.service.FeedService;

import static ru.bank.cosmo.util.DateTimeUtil.fromLocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeedConsumer {

    private final FeedService feedService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "posts-created", groupId = "feed-service-group")
    public void consume(String message) {
        KafkaPostDTO dto = objectMapper.readValue(message, KafkaPostDTO.class);
        log.info("Получено сообщение(пост) из очереди: {}", dto);
        processPost(dto);
    }

    private void processPost(KafkaPostDTO postDTO) {
        log.info("Добавление поста в ленту: {}", postDTO);
        feedService.addPostToFeed(postDTO.companyId(), postDTO.postId(), fromLocalDateTime(postDTO.postCreateAt()));
    }
}
