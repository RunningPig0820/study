package taosha;

import io.vertx.core.Vertx;
import taosha.verticles.MyFirstVerticle;

/**
 * @author: 淘沙
 * Description:
 */
public class Main {
    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }
}
