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
package org.brutusin.rpc.actions.websocket;

import org.brutusin.rpc.actions.ServiceItem;
import java.util.Map;
import org.brutusin.json.DynamicSchemaProvider;
import org.brutusin.rpc.Description;
import org.brutusin.rpc.RpcSpringContext;
import org.brutusin.rpc.RpcUtils;
import org.brutusin.rpc.http.HttpActionSupport;
import org.brutusin.rpc.websocket.WebsocketAction;
import org.brutusin.rpc.websocket.WebsocketActionSupport;

/**
 *
 * @author Ignacio del Valle Alles idelvall@brutusin.org
 */
@Description("This descriptor service returns the **list** of the deployed `websocket` services. *[See action source code at [github](https://github.com/brutusin/rpc-impl/blob/master/src/main/java/org/brutusin/rpc/actions/websocket/ServiceListAction.java)]*")
public class ServiceListAction extends WebsocketAction<Void, ServiceItem[]> {

    @Override
    public ServiceItem[] execute(Void input) throws Exception {
        Map<String, WebsocketAction> services = WebsocketActionSupport.getInstance().getWebSocketServices();
         RpcSpringContext rpcSpringContext = (RpcSpringContext)WebsocketActionSupport.getInstance().getSpringContext();
        ServiceItem[] serviceItems = new ServiceItem[services.size()];
        int i = 0;
        for (Map.Entry<String, WebsocketAction> entrySet : services.entrySet()) {
            String id = entrySet.getKey();
            WebsocketAction service = entrySet.getValue();
            ServiceItem si = new ServiceItem();
            si.setId(id);
            si.setDescription(RpcUtils.getDescription(service));
            Class<?> inputClass = RpcUtils.getClass(service.getInputType());
            si.setDynamicInputSchema(DynamicSchemaProvider.class.isAssignableFrom(inputClass));
            si.setFramework(rpcSpringContext.isFrameworkAction(service));
            serviceItems[i++] = si;
        }
        return serviceItems;
    }
}
