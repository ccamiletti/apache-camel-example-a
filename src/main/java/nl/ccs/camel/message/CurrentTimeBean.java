package nl.ccs.camel.message;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrentTimeBean {

    public String getCurrentTime() {
        return String.valueOf(LocalDateTime.now());
    }

    private String getCurrentTime2() {
        return String.valueOf(LocalDateTime.now());
    }
}
