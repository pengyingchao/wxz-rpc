package com.github.wxz.core.rpc.core.send;

import com.github.wxz.core.rpc.core.load.RpcServerLoader;
import com.github.wxz.core.rpc.netty.serialize.RpcSerializeProtocol;
import com.google.common.reflect.Reflection;

/**
 * msgSend
 *
 * @author xianzhi.wang
 * @date 2017/12/20 -11:15
 */
public class MsgSendExecutor {

    private static volatile MsgSendExecutor msgSendExecutor = null;

    private RpcServerLoader rpcServerLoader = RpcServerLoader.getInstance();

//    public MsgSendExecutor(String serverAddress, RpcSerializeProtocol serializeProtocol) {
//        rpcServerLoader.load(serverAddress, serializeProtocol);
//    }

    public void setRpcServerLoader(String serverAddress, RpcSerializeProtocol serializeProtocol) {
        rpcServerLoader.load(serverAddress, serializeProtocol);
    }

    public void stop() {
        rpcServerLoader.unLoad();
    }

    public <T> T execute(Class<T> rpcInterface) throws Exception {
        return (T) Reflection.newProxy(rpcInterface, new MsgSendProxy<T>());
    }


    private MsgSendExecutor() {
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static MsgSendExecutor getInstance() {
        if (msgSendExecutor == null) {
            synchronized (MsgSendExecutor.class) {
                if (msgSendExecutor == null) {
                    msgSendExecutor = new MsgSendExecutor();
                }
            }
        }
        return msgSendExecutor;
    }

}
