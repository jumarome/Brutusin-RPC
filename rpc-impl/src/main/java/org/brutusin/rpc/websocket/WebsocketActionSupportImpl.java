/*
 * Copyright 2016 Ignacio del Valle Alles idelvall@brutusin.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brutusin.rpc.websocket;

import java.util.Map;
import org.brutusin.rpc.SpringContextImpl;
import org.brutusin.rpc.http.HttpAction;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Ignacio del Valle Alles idelvall@brutusin.org
 */
public class WebsocketActionSupportImpl extends WebsocketActionSupport {

    private final SpringContextImpl springCtx;
    private final SessionImpl session;

    public static void setInstance(WebsocketActionSupport context) {
        CONTEXTS.set(context);
    }

    public static void clear() {
        CONTEXTS.remove();
    }

    public WebsocketActionSupportImpl(SpringContextImpl springCtx) {
        this(springCtx, null);
    }

    public WebsocketActionSupportImpl(SessionImpl session) {
        this((SpringContextImpl) WebApplicationContextUtils.getWebApplicationContext(session.getServletContext()), session);
    }

    private WebsocketActionSupportImpl(SpringContextImpl springCtx, SessionImpl session) {
        this.springCtx = springCtx;
        this.session = session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public boolean isUserInRole(String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SpringContextImpl getSpringContextImpl() {
        return springCtx;
    }

    @Override
    public ApplicationContext getSpringContext() {
        return getSpringContextImpl();
    }

    @Override
    public Map<String, HttpAction> getHttpServices() {
        return getSpringContextImpl().getHttpServices();
    }

    @Override
    public Map<String, WebsocketAction> getWebSocketServices() {
        return getSpringContextImpl().getWebSocketServices();
    }

    @Override
    public Map<String, Topic> getTopics() {
        return getSpringContextImpl().getTopics();
    }
}