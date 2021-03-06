/*
 * Copyright 2015 brutusin.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brutusin.rpc.websocket;

import java.security.Principal;
import org.brutusin.rpc.RpcActionSupport;

/**
 *
 * @author Ignacio del Valle Alles idelvall@brutusin.org
 */
public abstract class WebsocketActionSupport extends RpcActionSupport{
    
    public static WebsocketActionSupport getInstance() {
        RpcActionSupport instance = RpcActionSupport.getInstance();
        if(instance instanceof WebsocketActionSupport){
            return (WebsocketActionSupport)instance;
        }
        throw new IllegalStateException("Caller is not in a Websocket request scope");
    }
    
    @Override
    public final Principal getUserPrincipal() {
        Session session = getWebsocketSession();
        if (session == null) {
            return null;
        }
        return session.getUserPrincipal();
    }

    public abstract Session getSession();
    
    private Session getWebsocketSession() {
        Object session = getSession();
        if (!(session instanceof Session)) {
            return null;
        }
        return (Session) session;
    }

}
