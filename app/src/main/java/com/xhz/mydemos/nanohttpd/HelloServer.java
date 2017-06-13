package com.xhz.mydemos.nanohttpd;

import android.graphics.Bitmap;

import com.xys.libzxing.zxing.encoding.EncodingUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.logging.Logger;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by xh.zeng on 2017/6/9.
 */

public class HelloServer extends NanoHTTPD{
    private static final Logger LOG = Logger.getLogger(HelloServer.class.getName());

    public HelloServer(int port){
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        String uri = session.getUri();
        HelloServer.LOG.info("method:"+method);
        HelloServer.LOG.info("uri:"+uri);
        HelloServer.LOG.info("Parameters:"+session.getParameters());
        HelloServer.LOG.info("Params:"+session.getParms());
        HelloServer.LOG.info("RemoteHostName:"+session.getRemoteHostName());
        HelloServer.LOG.info("RemoteIpAddress:"+session.getRemoteIpAddress());
        HelloServer.LOG.info("ParameterString:"+session.getQueryParameterString());
        HelloServer.LOG.info("Headers:"+session.getHeaders());

        return bitmapResponse(session);
    }


    public Response htmlResponse(IHTTPSession session){
        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n" + "  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
            msg +="<img src=\"http://mssdn.sankuai.com/v1/mss_814dc1610cda4b2e8febd6ea2c809db5/image/1489026813356.png\" alt=\"Big Boat\">\n";
        }

        msg += "</body></html>\n";

        return newFixedLengthResponse(msg);
    }

    public Response bitmapResponse(IHTTPSession session){
        Bitmap qrCode = EncodingUtils.createQRCode("http://www.baidu.com/", 300, 300, null);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        qrCode.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] qrcodeData = bos.toByteArray();
        ByteArrayInputStream qrcodeInputStream = new ByteArrayInputStream(qrcodeData);

        Response bigmapResponse = newFixedLengthResponse(Response.Status.OK, "png", qrcodeInputStream, qrcodeData.length);
        return bigmapResponse;
    }

}
