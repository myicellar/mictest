package io.mic;

import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

import java.net.InetAddress;

/**
 * Created by lwbu on 15-9-10.
 */
public class TestLogic {
    public static void main(String[] args){
        try {
            RatpackServer.start(server -> server
                            .serverConfig(
                                    ServerConfig.embedded()
                                            .address(InetAddress.getByName("188.166.241.7"))
                                            .port(8080)
                                    .threads(2)
                            )
                            .handlers(chain -> chain
                                            .get(ctx -> ctx.render("Hello World!"))
                                            .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))
                            )
            );
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
