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
import com.ionosenterprise.rest.domain.Groups;
import com.ionosenterprise.util.Constant;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public class GroupApi extends AbstractBaseApi {

    public GroupApi(RestClient client) {
        super(client);
    }

    protected String getPathFormat() {
        return Constant.GROUPS_RESOURCE_PATH_TEMPLATE;
    }

    /**
     * Retrieve a list of Groups.
     *
     * @return Groups object with a list of Groups
     */
    public Groups getAllGroups() throws RestClientException, IOException {
        return client.get(getResourcePathBuilder().withDepth().build(), Collections.EMPTY_MAP, Groups.class);
    }

    /**
     * Retrieves the attributes of a specific group
     *
     * @param groupId The unique ID of the group.
     * @return Group object with properties and metadata
     */
    public com.ionosenterprise.rest.domain.Group getGroup(String groupId) throws RestClientException, IOException {
        return client.get(getResourcePathBuilder().appendPathSegment(groupId).withDepth().build(),
                Collections.EMPTY_MAP, com.ionosenterprise.rest.domain.Group.class);
    }

    /**
     * Deletes a specific group.
     *
     * @param groupId The unique ID of the group.
     * @return a String representing the requestId
     */
    public String deleteGroup(String groupId) throws RestClientException, IOException {
        return client.delete(getResourcePathBuilder().appendPathSegment(groupId).build(),HttpStatus.SC_ACCEPTED);
    }

    /**
     * Create a single Group, you can add child items to trigger a composite provision.
     *
     * @param  group object has the following properties:
     * <br>
     * name= A name that was given to the group.
     * <br>
     * createDataCenter= The group has permission to create virtual data centers.
     * <br>
     * createSnapshot= The group has permission to create snapshots.
     * <br>
     * reserveIp= The group has permission to reserve IP addresses.
     * <br>
     * accessActivityLog= The group has permission to access the activity log.
     * @return Group object with properties and metadata.
     */
    public com.ionosenterprise.rest.domain.Group createGroup(com.ionosenterprise.rest.domain.Group group)
            throws RestClientException, IOException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException {

        return client.create(getResourcePathBuilder().build(), group,
                com.ionosenterprise.rest.domain.Group.class, HttpStatus.SC_ACCEPTED);
    }

    /**
     * Updates a specific group.
     *
     * @param groupId The unique ID of the group.
     * @return Group object with properties and metadata
     */
    public com.ionosenterprise.rest.domain.Group updateGroup(String groupId, Object object)
            throws RestClientException, IOException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        return client.put(getResourcePathBuilder().appendPathSegment(groupId).build(),
                object, com.ionosenterprise.rest.domain.Group.class, HttpStatus.SC_ACCEPTED);
    }
}
