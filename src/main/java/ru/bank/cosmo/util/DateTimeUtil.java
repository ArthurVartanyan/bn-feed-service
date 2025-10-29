package ru.bank.cosmo.util;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class DateTimeUtil {

    public static UUID fromLocalDateTime(LocalDateTime dateTime) {
        long millis = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        return Uuids.startOf(millis);
    }
}