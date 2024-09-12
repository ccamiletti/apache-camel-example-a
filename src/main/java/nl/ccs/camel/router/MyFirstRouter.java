package nl.ccs.camel.router;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import nl.ccs.camel.message.CurrentTimeBean;
import nl.ccs.camel.message.SimpleLoggingProcessComponent;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MyFirstRouter extends RouteBuilder {

    private final CurrentTimeBean currentTimeBean;
    private final SimpleLoggingProcessComponent simpleLoggingProcessComponent;

    @Override
    public void configure() throws Exception {
        // we are going to listen to a queue (first endpoint). Timer to trigger messages
        // we are going to do a transformation and save it in the database (second endpoint)
        from("timer:first-timer") // null
                .log("${body}")
                .transform().constant("time is => " + LocalDateTime.now()) // any change in the body.
                .log("${body}")
                // in this case we are transforming the message from Null to constant message.
                //.process("test") // no changes on the body message
                .bean(currentTimeBean, "getCurrentTime")
                .process(simpleLoggingProcessComponent)
                .log("${body}")
                .to("log:first-timer?level=INFO");

    }
}
