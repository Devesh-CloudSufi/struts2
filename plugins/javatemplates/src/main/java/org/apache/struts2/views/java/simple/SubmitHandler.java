/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.views.java.simple;

import org.apache.struts2.views.java.TagGenerator;
import org.apache.struts2.views.java.Attributes;

import java.io.IOException;
import java.util.Map;

import com.opensymphony.xwork2.util.TextUtils;

public class SubmitHandler extends AbstractTagHandler implements TagGenerator {

    public void generate() throws IOException {
        Map<String, Object> params = context.getParameters();
        Attributes attrs = new Attributes();

        String type = TextUtils.noNull((String) params.get("type"), "input");

        if ("button".equals(type)) {
            attrs.addIfExists("name", params.get("name"))
                    .add("type", "submit")
                    .addIfExists("value", params.get("nameValue"), false)
                    .addIfTrue("disabled", params.get("disabled"))
                    .addIfExists("tabindex", params.get("tabindex"))
                    .addIfExists("id", params.get("id"))
                    .addIfExists("class", params.get("cssClass"))
                    .addIfExists("style", params.get("cssStyle"));

            start("button", attrs);
        } else if ("image".equals(type)) {
            attrs.addIfExists("src", params.get("src"), false)
                    .add("type", "image")
                    .addIfExists("alt", params.get("label"));

            start("input", attrs);
        } else {
            attrs.addIfExists("name", params.get("name"))
                    .add("type", "submit")
                    .addIfExists("value", params.get("nameValue"), false)
                    .addIfTrue("disabled", params.get("disabled"))
                    .addIfExists("tabindex", params.get("tabindex"))
                    .addIfExists("id", params.get("id"))
                    .addIfExists("class", params.get("cssClass"))
                    .addIfExists("style", params.get("cssStyle"));

            start("input", attrs);
        }
    }

    public static class CloseHandler extends AbstractTagHandler implements TagGenerator {
        public void generate() throws IOException {
            Map<String, Object> params = context.getParameters();
            Attributes attrs = new Attributes();
            String body = (String) params.get("body");

            String type = TextUtils.noNull((String) params.get("type"), "input");
            if ("button".equals(type)) {
                //button body
                if (TextUtils.stringSet(body))
                    characters(body, false);
                else if (params.containsKey("label")) {
                    String label = (String) params.get("label");
                    if (TextUtils.stringSet(label))
                        characters(label, false);
                }
                end("button");
            } else if ("image".equals(type)) {
                if (TextUtils.stringSet(body))
                    characters(body, false);
                end("input");
            } else
                end("input");
        }
    }
}


