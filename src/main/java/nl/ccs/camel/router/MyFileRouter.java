package nl.ccs.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("file:file/input")
                .log("${body}")
                .to("file:file/output");
    }
}
