package nl.ccs.camel.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class SimpleLoggingProcessComponent implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("SimpleLoggingProcessComponent {}", exchange.getMessage().getBody());
    }
}
