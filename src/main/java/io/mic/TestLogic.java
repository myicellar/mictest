package io.mic;

import com.google.inject.Guice;
import db.jooq.Tables;
import db.jooq.tables.pojos.Categories;
import db.jooq.tables.pojos.WineMaster;
import db.jooq.tables.pojos.Winery;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ratpack.exec.Blocking;
import ratpack.hikari.HikariModule;
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

    public static void main(String[] args){
        try {
            RatpackServer.start(server -> server
                            .serverConfig(
                                    ServerConfig.embedded()
                                    //.address(InetAddress.getByName("localhost"))
                                    //.port(8080)
                                    //.threads(2)
                            )
                            .registry(ratpack.guice.Guice.registry(db -> db
                                                    .module(HikariModule.class, hikariConfig -> {
                                                        hikariConfig.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
                                                        //hikariConfig.setUsername("postgres");
                                                        //hikariConfig.setPassword("Mcellar2015");
                                                        hikariConfig.addDataSourceProperty("serverName", "188.166.254.184");
                                                        hikariConfig.addDataSourceProperty("portNumber", "5432");
                                                        hikariConfig.addDataSourceProperty("databaseName", "cellardb");
                                                        hikariConfig.addDataSourceProperty("user","postgres");
                                                        hikariConfig.addDataSourceProperty("password","Mcellar2015");
                                                        //hikariConfig.setJdbcUrl("jdbc:postgresql://188.166.254.184:5432/cellardb");
                                                        hikariConfig.setConnectionTestQuery("select 1");
                                                    })
                                    )
                            )
                            .handlers(chain -> chain
                                            .get(ctx -> ctx.render("Hello World!"))
                                            .get("catg", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<Categories> result = dslContext.select().from(Tables.CATEGORIES).fetchInto(Categories.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get("wine", ctx ->
                                                            Blocking.get(() -> {
                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
                                                                    DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_9_3);
                                                                    List<WineMaster> result = dslContext.select().from(Tables.WINE_MASTER).maxRows(30).fetchInto(WineMaster.class);
                                                                    connection.close();
                                                                    return json(result);
                                                                }
                                                            }).then(ctx::render)
                                            )
                                            .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name").toUpperCase() + "! What's on your mind??"))
//                                            .get("catg/:idd", ctx ->
//                                                            Blocking.get(() -> {
//                                                                try (Connection connection = ctx.get(DataSource.class).getConnection()) {
//                                                                    PreparedStatement statement = connection.prepareStatement("select Description from categories where categories_id = ?");
//                                                                    statement.setInt(1, Integer.parseInt(ctx.getPathTokens().get("idd")));
//                                                                    ResultSet resultSet = statement.executeQuery();
//                                                                    resultSet.next();
//                                                                    return "Hellow PostgreSQL: " + resultSet.getString(1);
//                                                                }
//                                                            }).then(ctx::render)
//                                            )
                            )
            );
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
