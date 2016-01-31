/*
 * Copyright 2015 Ignacio del Valle Alles idelvall@brutusin.org.
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
package org.brutusin.demo.streaming;

import org.brutusin.commons.io.MetaDataInputStream;
import org.brutusin.demo.streaming.UploadingActionInput;
import org.brutusin.rpc.http.UnsafeAction;

/**
 *
 * @author Ignacio del Valle Alles idelvall@brutusin.org
 */
public class UploadingAction extends UnsafeAction<UploadingActionInput, String> {

    @Override
    public String execute(UploadingActionInput input) throws Exception {
        MetaDataInputStream[] inputStreams = input.getInputStreams();
        return "Sucessfully uploaded " + inputStreams.length + " files";
    }
}