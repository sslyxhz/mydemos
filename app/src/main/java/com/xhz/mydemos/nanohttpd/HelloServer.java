package com.xhz.mydemos.nanohttpd;

import java.io.IOException;
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

        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n" + "  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }

        msg += "</body></html>\n";

        return newFixedLengthResponse(msg);
    }
}
