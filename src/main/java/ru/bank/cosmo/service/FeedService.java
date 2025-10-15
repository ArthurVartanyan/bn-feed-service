package ru.bank.cosmo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bank.cosmo.feign.SubscriptionServiceClient;
import ru.bank.cosmo.model.FeedRow;
import ru.bank.cosmo.repository.FeedRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;
    private final SubscriptionServiceClient subscriptionServiceClient;

    public void addPostToFeed(Long companyId, Long postId, UUID postCreationDateTime) {
        var response = subscriptionServiceClient.getSubscribers(companyId);
        for (var userId : response.subscribers()) {
            var newFeedRow = new FeedRow();
            newFeedRow.setPostId(postId);
            newFeedRow.setUserId(userId);
            newFeedRow.setCreatedAt(postCreationDateTime);
            feedRepository.save(newFeedRow);
        }
    }
}