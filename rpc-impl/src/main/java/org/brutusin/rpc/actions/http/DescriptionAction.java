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
package org.brutusin.rpc.actions.http;

import org.brutusin.rpc.Description;
import org.brutusin.rpc.http.Cacheable;
import org.brutusin.rpc.http.SafeAction;
import org.brutusin.rpc.RpcUtils;

/**
 *
 * @author Ignacio del Valle Alles idelvall@brutusin.org
 */
@Description("Returns the [markdown](https://daringfireball.net/projects/markdown/) description of this microservice API.")
public class DescriptionAction extends SafeAction<Void, String> {

    @Override
    public Cacheable<String> execute(Void input) throws Exception {
        return Cacheable.never(RpcUtils.getDescription());
    }
}
