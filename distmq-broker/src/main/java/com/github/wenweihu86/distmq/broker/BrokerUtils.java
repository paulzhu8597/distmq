package com.github.wenweihu86.distmq.broker;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.zip.CRC32;

/**
 * Created by wenweihu86 on 2017/6/17.
 */
public class BrokerUtils {
    private static final Logger LOG = LoggerFactory.getLogger(BrokerUtils.class);
    private static final JsonFormat.Printer PRINTER = JsonFormat.printer().omittingInsignificantWhitespace();

    public static String protoToJson(MessageOrBuilder message) {
        try {
            return PRINTER.print(message);
        } catch (InvalidProtocolBufferException ex) {
            LOG.warn("get exception: ", ex);
            return "";
        }
    }

    public static long getCRC32(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }

}
