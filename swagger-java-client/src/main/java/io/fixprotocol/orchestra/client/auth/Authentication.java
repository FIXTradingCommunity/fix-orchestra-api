

package io.fixprotocol.orchestra.client.auth;

import java.util.List;
import java.util.Map;

import io.fixprotocol.orchestra.client.Pair;

public interface Authentication {
    /**
     * Apply authentication settings to header and query params.
     *
     * @param queryParams List of query parameters
     * @param headerParams Map of header parameters
     */
    void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
