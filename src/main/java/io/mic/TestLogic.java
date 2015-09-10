package io.mic;

import ratpack.server.RatpackServer;

/**
 * Created by lwbu on 15-9-10.
 */
public class TestLogic {
    public static void main(String[] args){
        try {
            RatpackServer.start(server -> server
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
