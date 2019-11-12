package com.taosha;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import taosha.verticles.MyFirstVerticle;

/**
 * @author: 淘沙
 * Description:
 */
@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest {

    private Vertx vertx;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testApplication(TestContext context) {
        final Async async = context.async();

        vertx.createHttpClient().getNow(8080, "localhost", "/", response -> {
            response.handler(body -> {
                System.out.println(body.toString());
                context.assertTrue(body.toString().contains("Hello"));
                async.complete();
            });
        });

//        io.netty.channel.AbstractChannel$AnnotatedConnectException
//        同时监听多个端口 返回 io.netty.channel.AbstractChannel 说明内部默认是使用 netty 实现的
//        vertx.createHttpClient().getNow(8080, "localhost", "/", response -> {
//            response.handler(body -> {
//                System.out.println(body.toString());
//                context.assertTrue(body.toString().contains("Hello"));
//                async.complete();
//            });
//        });
    }
}