package ru.bank.cosmo.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bank.cosmo.model.FeedRow;
import ru.bank.cosmo.repository.FeedRepository;

@RestController("/feed/api")
@RequiredArgsConstructor
public class FeedController {

    private final FeedRepository feedRepository;

    @GetMapping
    public void doS() {
        var feed = new FeedRow();
        feed.setCreatedAt(Uuids.timeBased());
        feed.setUserId(6L);
        feed.setPostId(77L);
        feedRepository.save(feed);
    }
}
