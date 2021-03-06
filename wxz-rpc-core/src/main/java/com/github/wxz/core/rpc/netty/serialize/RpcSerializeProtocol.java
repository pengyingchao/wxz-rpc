package com.github.wxz.core.rpc.netty.serialize;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 序列化方式
 *
 * @author xianzhi.wang
 * @date 2017/12/19 -16:38
 */
public enum RpcSerializeProtocol {

    JDK_SERIALIZE("jdk_native"),
    KR_YO_SERIALIZE("kryo"),
    HESSIAN_SERIALIZE("hessian"),
    PROTO_STUFF_SERIALIZE("proto_stuff");

    private String serializeProtocol;

    private RpcSerializeProtocol(String serializeProtocol) {
        this.serializeProtocol = serializeProtocol;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getProtocol() {
        return serializeProtocol;
    }
}
