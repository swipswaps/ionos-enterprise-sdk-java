/*
 * Copyright (c) 2017, 1&1 IONOS Cloud GmbH
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by the <organization>.
 * 4. Neither the name of the 1&1 IONOS Cloud nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY 1&1 IONOS Cloud GmbH ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL 1&1 IONOS Cloud GmbH BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.ionosenterprise.sdk;

import com.ionosenterprise.rest.client.RestClient;
import com.ionosenterprise.rest.client.RestClientException;
import com.ionosenterprise.rest.domain.RequestStatus;
import com.ionosenterprise.rest.domain.Requests;
import com.ionosenterprise.util.Constant;

import java.io.IOException;
import java.util.Collections;

public class RequestApi extends AbstractBaseApi {

    public RequestApi(RestClient client) {
        super(client);
    }

    protected String getPathFormat() {
        return Constant.REQUESTS_RESOURCE_PATH_TEMPLATE;
    }

    /**
     * Retrieves the status of a specific request.
     *
     * @param url The unique ID of the request.
     * @return RequestStatus
     */
    public RequestStatus getRequestStatus(String url) throws RestClientException, IOException {
        if (url != null) {
            return client.get(url, Collections.EMPTY_MAP, RequestStatus.class);
        }
        return null;
    }

    /**
     * Retrieves all requests
     */
    public Requests listRequests() throws RestClientException, IOException {
        return client.get(getResourcePathBuilder().withDepth().build(), Collections.EMPTY_MAP, Requests.class);
    }

    /**
     * Retrieves a specific request
     *
     * @param requestId The unique ID of the request.
     */
    public com.ionosenterprise.rest.domain.Request getRequest(String requestId) throws RestClientException, IOException {
        return client.get(getResourcePathBuilder().appendPathSegment(requestId).withDepth().build(),
                Collections.EMPTY_MAP, com.ionosenterprise.rest.domain.Request.class);
    }

}
