/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.server.mock;

import io.fabric8.mockwebserver.internal.WebSocketMessage;

public class OutputStreamMessage extends WebSocketMessage {

    private static final byte OUT_STREAM_ID = 1;

    public OutputStreamMessage(String body) {
        super(body);
    }

    public OutputStreamMessage(String body, boolean toBeRemoved) {
        super(body, toBeRemoved);
    }

    public OutputStreamMessage(Long delay, String body, boolean toBeRemoved) {
        super(delay, body, toBeRemoved);
    }

    @Override
    public byte[] getBytes() {
        byte[] original = getBody().getBytes();
        byte[] prefixed = new byte[original.length + 1];
        prefixed[0] = OUT_STREAM_ID;
        System.arraycopy(original, 0, prefixed, 1, original.length);
        return prefixed;
    }
}
