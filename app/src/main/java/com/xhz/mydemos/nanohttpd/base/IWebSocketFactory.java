package com.xhz.mydemos.nanohttpd.base;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoWSD;

/**
 * Created by xh.zeng on 2017/6/12.
 */

public interface IWebSocketFactory {
    NanoWSD.WebSocket openWebSocket(NanoHTTPD.IHTTPSession handshake);
}
