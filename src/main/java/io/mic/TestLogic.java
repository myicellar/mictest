package io.mic;

import com.google.inject.Guice;
import dbq.Tables;
import dbq.tables.*;
import dbq.tables.pojos.*;
import dbq.tables.pojos.VUserCellarList;
import dbq.tables.pojos.VUserReview;
import dbq.tables.pojos.VUserWishlist;
import dbq.tables.pojos.VWineDetail;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ratpack.exec.Blocking;
import ratpack.handling.Context;
import ratpack.hikari.HikariModule;
import ratpack.jackson.JsonRender;
import ratpack.render.RendererSupport;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;
import ratpack.server.Service;
import ratpack.server.StartEvent;


import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import static ratpack.jackson.Jackson.json;

/**
 * Created by lwbu on 15-9-10.
 */
public class TestLogic {

    static class InitDb implements Service {
        public void onStart(StartEvent startEvent) throws Exception {
            DataSource dataSource = startEvent.getRegistry().get(DataSource.class);
            try (Connection connection = dataSource.getConnection()) {
                //connection.createStatement().executeUpdate("");
                connection.createStatement().execute("");
            }
        }
    }


    static class ionicRenderer extends RendererSupport<JsonRender>{
        @Override
        public void render(Context ctx, JsonRender json) throws Exception {
            ctx.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
        }

    }

    public static void main(String[] args){
        try {
            RatpackServer.start(server -> server
                            /*.serverConfig(
                                    ServerConfig.embedded()
                                            .address(InetAddress.getByName("188.166.241.7"))
                                            .port(8080)
                                            .threads(2)
                            )*/
                            .registry(ratpack.guice.Guice.registry(db -> db
                                                    .module(HikariModule.class, hikariConfig -> {
                                                        hikariConfig.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
                                                        //hikariConfig.setUsername("postgres");
                                                        //hikariConfig.setPassword("Mcellar2015");
                                                        hikariConfig.addDataSourceProperty("serverName", "188.166.254.184");
                                                        hikariConfig.addDataSourceProperty("portNumber", "5432");
                                                        hikariConfig.addDataSourceProperty("databaseName", "cellardb");
                                                        hikariConfig.addDataSourceProperty("user", "postgres");
                                                        hikariConfig.addDataSourceProperty("password", "Mcellar2015");
                                                        //hikariConfig.setJdbcUrl("jdbc:postgresql://188.166.254.184:5432/cellardb");
                                                        hikariConfig.setConnectionTestQuery("select 1");
                                                    })
                                    )
                            )
                            .handlers(chain -> chain
                                            .all(ctx -> {
                                                ctx.getResponse().getHeaders().set("Access-Control-Allow-Origin", "*");
                                                ctx.next();
                                            })
                                            .get("", ctx ->
                                                    ctx.render("Hello World!"))
                                            .get("cellarlist/:tokenid", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<VUserCellarList> result = dslContext.select().from(Tables.V_USER_CELLAR_LIST)
                                                                            .where(dbq.tables.VUserCellarList.V_USER_CELLAR_LIST.USER_ID.equal(UUID.fromString(ctx.getPathTokens().get("tokenid"))))
                                                                            .orderBy(dbq.tables.VUserCellarList.V_USER_CELLAR_LIST.SORT_SEQ.desc())
                                                                            .limit(20)
                                                                            .fetchInto(VUserCellarList.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("cellarlist/:tokenid/:lastrecord", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<VUserCellarList> result = dslContext.select().from(Tables.V_USER_CELLAR_LIST)
                                                                            .where(dbq.tables.VUserCellarList.V_USER_CELLAR_LIST.USER_ID.equal(UUID.fromString(ctx.getPathTokens().get("tokenid"))))
                                                                            .orderBy(dbq.tables.VUserCellarList.V_USER_CELLAR_LIST.SORT_SEQ.desc())
                                                                            .seek(Integer.parseInt(ctx.getPathTokens().get("lastrecord")))
                                                                            .limit(20)
                                                                            .fetchInto(VUserCellarList.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("wishlist/:tokenid", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<VUserWishlist> result = dslContext.select().from(Tables.V_USER_WISHLIST)
                                                                            .where(dbq.tables.VUserWishlist.V_USER_WISHLIST.USER_ID.equal(UUID.fromString(ctx.getPathTokens().get("tokenid"))))
                                                                            .orderBy(dbq.tables.VUserWishlist.V_USER_WISHLIST.SORT_SEQ.desc())
                                                                            .limit(20)
                                                                            .fetchInto(VUserWishlist.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("wishlist/:tokenid/:lastrecord", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<VUserWishlist> result = dslContext.select().from(Tables.V_USER_WISHLIST)
                                                                            .where(dbq.tables.VUserWishlist.V_USER_WISHLIST.USER_ID.equal(UUID.fromString(ctx.getPathTokens().get("tokenid"))))
                                                                            .orderBy(dbq.tables.VUserWishlist.V_USER_WISHLIST.SORT_SEQ.desc())
                                                                            .seek(Integer.parseInt(ctx.getPathTokens().get("lastrecord")))
                                                                            .limit(20)
                                                                            .fetchInto(VUserWishlist.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("reviewlist/:tokenid", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<VUserReview> result = dslContext.select().from(Tables.V_USER_REVIEW)
                                                                            .where(dbq.tables.VUserReview.V_USER_REVIEW.USER_ID.equal(UUID.fromString(ctx.getPathTokens().get("tokenid"))))
                                                                            .orderBy(dbq.tables.VUserReview.V_USER_REVIEW.SORT_SEQ.desc())
                                                                            .limit(10)
                                                                            .fetchInto(VUserReview.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("reviewlist/:tokenid/:lastrecord", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<VUserReview> result = dslContext.select().from(Tables.V_USER_REVIEW)
                                                                            .where(dbq.tables.VUserReview.V_USER_REVIEW.USER_ID.equal(UUID.fromString(ctx.getPathTokens().get("tokenid"))))
                                                                            .orderBy(dbq.tables.VUserReview.V_USER_REVIEW.SORT_SEQ.desc())
                                                                            .seek(Integer.parseInt(ctx.getPathTokens().get("lastrecord")))
                                                                            .limit(10)
                                                                            .fetchInto(VUserReview.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("winedetail/:wineid", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    VWineDetail result = dslContext.select().from(Tables.V_WINE_DETAIL)
                                                                            .where(dbq.tables.VWineDetail.V_WINE_DETAIL.ID.equal(Integer.parseInt(ctx.getPathTokens().get("wineid"))))
                                                                            .fetchOneInto(VWineDetail.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name").toUpperCase() + "! What's on your mind??"))


//
                            )
            );
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
