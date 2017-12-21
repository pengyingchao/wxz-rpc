package com.github.wxz.rpc.spring;

import com.github.wxz.rpc.config.RpcSystemConfig;
import com.github.wxz.rpc.netty.core.recv.MsgRevExecutor;
import com.github.wxz.rpc.netty.seri.RpcSerializeProtocol;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注册
 *
 * @author xianzhi.wang
 * @date 2017/12/19 -16:00
 */
public class RpcRegistery implements InitializingBean, DisposableBean {
    private String ipAddress;
    private String protocol;
    private String echoApiPort;
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Override
    public void destroy() throws Exception {
        MsgRevExecutor.getInstance().shutDown();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MsgRevExecutor msgRevExecutor = MsgRevExecutor.getInstance();
        msgRevExecutor.setServerAddress(ipAddress);
        msgRevExecutor.setEchoApiPort(Integer.parseInt(echoApiPort));
        msgRevExecutor.setSerializeProtocol(Enum.valueOf(RpcSerializeProtocol.class, protocol));
        if (RpcSystemConfig.isMonitorServerSupport()) {
            //TODO
        }
        msgRevExecutor.start();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getEchoApiPort() {
        return echoApiPort;
    }

    public void setEchoApiPort(String echoApiPort) {
        this.echoApiPort = echoApiPort;
    }
}
