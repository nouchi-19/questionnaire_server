package jp.ac.dendai.sie.usd.student.adapter.mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeGetter {
    public static LocalDateTime getNowTime() {
        return ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toLocalDateTime();
    }
}
