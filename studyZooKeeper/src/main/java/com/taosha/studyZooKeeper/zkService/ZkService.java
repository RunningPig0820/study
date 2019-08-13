package com.taosha.studyZooKeeper.zkService;

import com.taosha.studyZooKeeper.config.properties.ZkClientProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-10 4:57 PM
 **/
@Slf4j
@Service
public class ZkService implements Watcher {

    private ZooKeeper zooKeeper ;
    private static final CountDownLatch LATCH = new CountDownLatch(1);

    @Autowired
    ZkClientProperties zkClientProperties;

    @PostConstruct
    public void init (){
        try {
            zooKeeper = new ZooKeeper(zkClientProperties.getConnectAddress(),zkClientProperties.getSessionTimeout(), this);
            System.out.println(zooKeeper.getState());

//            crud();
            watch();
        } catch (IOException e) {
            log.error("嘿嘿");
            e.printStackTrace();
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        } finally {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("监听启动 : " + watchedEvent);
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
            LATCH.countDown();
        }
        try {
            LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        switch (watchedEvent.getType()){
            case None:
                System.out.println("None");
                break;
            case NodeCreated:
                System.out.println("NodeCreated");
                break;
            case NodeDeleted:
                System.out.println("NodeDeleted");
                break;
            case NodeDataChanged:
                System.out.println("NodeDataChanged");
                break;
            case NodeChildrenChanged:
                System.out.println("NodeChildrenChanged");
                break;
            default:
                System.out.println("default");
                break;
        }

        try {
            if(StringUtils.hasLength(watchedEvent.getPath())) {
                zooKeeper.exists(watchedEvent.getPath(), true);
            }
        } catch (KeeperException | InterruptedException ignored) {
        }

    }

    private void crud() throws KeeperException, InterruptedException {
        //创建节点
        zooKeeper.create("/studyZk","studyZk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        Stat stat = new Stat();

        //获取节点
        byte[] data = zooKeeper.getData("/studyZk",null,stat);
        System.out.println(new String(data));
        System.out.println(stat);

        //更新节点
        stat = zooKeeper.setData("/studyZk", "set studyZk".getBytes(), stat.getVersion());
        System.out.println(stat);

        //获取节点
        data = zooKeeper.getData("/studyZk",null,stat);
        System.out.println(new String(data));
        System.out.println(stat);

        zooKeeper.delete("/studyZk",stat.getVersion());
        System.out.println(stat);
    }


    private void watch() throws KeeperException, InterruptedException {
        String nodeName="/studyZk-watch";
        Stat stat = new Stat();
        Stat childStat = new Stat();

        if (zooKeeper.exists(nodeName, false) != null) {
            zooKeeper.delete(nodeName,stat.getVersion());
        }

        //可以通过 exists getData getChildren 绑定事件
        zooKeeper.exists(nodeName, true);

        //创建节点
        System.out.println("创建父节点");
        zooKeeper.create(nodeName, "studyZk-watch".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] data = zooKeeper.getData(nodeName,true,stat);

        //更新节点
        System.out.println("更新父节点");
        stat = zooKeeper.setData(nodeName,"studyZk-watch setData".getBytes(),stat.getVersion());

        //获取子节点
        System.out.println("获取子节点");
        zooKeeper.getChildren(nodeName,true);


        zooKeeper.exists(nodeName+"/addChildren", true);

        //新增子节点
        System.out.println("新增子节点");
        zooKeeper.create(nodeName+"/addChildren","studyZk-watch addChildren".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        data = zooKeeper.getData(nodeName+"/addChildren",true,childStat);

        //修改子节点
        System.out.println("修改子节点");
        childStat = zooKeeper.setData(nodeName+"/addChildren","studyZk-watch set Children".getBytes(),childStat.getVersion());

        //删除子节点
        System.out.println("删除子节点");
        zooKeeper.delete(nodeName+"/addChildren",childStat.getVersion());


        //删除节点
        System.out.println("删除节点");
        zooKeeper.delete(nodeName,stat.getVersion());

    }
}
