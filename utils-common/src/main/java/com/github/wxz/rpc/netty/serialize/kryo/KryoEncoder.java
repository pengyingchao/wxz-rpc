package com.github.wxz.rpc.netty.serialize.kryo;


import com.github.wxz.rpc.netty.serialize.MessageCodecUtil;
import com.github.wxz.rpc.netty.serialize.MessageEncoder;
/**
 * @author xianzhi.wang
 * @date 2017/12/19 -16:38
 */
public class KryoEncoder extends MessageEncoder {

    public KryoEncoder(MessageCodecUtil util) {
        super(util);
    }
}
