/*
 * Copyright 2011 JBoss Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.drools.guvnor.client.explorer;

import com.google.gwt.http.client.URL;
import com.google.gwt.place.shared.PlaceTokenizer;

public class IFramePerspectivePlace extends Perspective {


    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class Tokenizer implements PlaceTokenizer<IFramePerspectivePlace> {

        public String getToken(IFramePerspectivePlace place) {
            return URL.encode(place.getName());
        }

        public IFramePerspectivePlace getPlace(String token) {
            return new IFramePerspectivePlace();
        }
    }

}
