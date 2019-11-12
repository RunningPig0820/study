package taosha.verticles;

import io.vertx.core.AbstractVerticle;

/**
 * @author: 淘沙
 * Description:
 */
public class MyFirstVerticle extends AbstractVerticle {

    //属性变量
    private int i = 0;

    public void start() {

        vertx.createHttpServer()
                .requestHandler(req -> {
                    req.response()
                            .putHeader("content-type", "text/plain")
                            .end("Hello World!");
                })
                .listen(8080);

        vertx.createHttpServer().requestHandler(req->{
            i++;
            //要关闭请求，否则连接很快会被占满
            req.response().end();
        }).listen(8081);

        vertx.createHttpServer().requestHandler(req->{
            System.out.println(i);
            req.response().end(""+i);
        }).listen(8082);
    }
}
