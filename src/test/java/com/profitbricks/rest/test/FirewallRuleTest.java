/*
 * Copyright 2015.
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
package com.profitbricks.rest.test;

import com.profitbricks.rest.client.RestClientException;
import com.profitbricks.rest.domain.DataCenter;
import com.profitbricks.rest.domain.FirewallRule;
import com.profitbricks.rest.domain.FirewallRules;
import com.profitbricks.rest.domain.Location;
import com.profitbricks.rest.domain.Nic;
import com.profitbricks.rest.domain.PBObject;
import com.profitbricks.rest.domain.Protocol;
import com.profitbricks.rest.domain.Server;
import com.profitbricks.sdk.ProfitbricksApi;
import java.io.IOException;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jasmin.gacic
 */
public class FirewallRuleTest {

   static ProfitbricksApi profitbricksApi = new ProfitbricksApi();
   static String dataCenterId;
   static String serverId;
   private static String nicId;
   private static String firewallRuleId;

   @BeforeClass
   public static void setUp() throws RestClientException, IOException, InterruptedException {
      DataCenter datacenter = new DataCenter();
      datacenter.getProperties().setName("SDK TEST FIREWALLRULES - Data Center");
      datacenter.getProperties().setLocation(Location.US_LAS_DEV.value());
      datacenter.getProperties().setDescription("SDK TEST Description");

      DataCenter newDatacenter = profitbricksApi.dataCenterApi.createDataCenter(datacenter);
      dataCenterId = newDatacenter.getId();

      Server server = new Server();
      server.getProperties().setName("SDK TEST FIREWALLRULES - Server");
      server.getProperties().setRam("1024");
      server.getProperties().setCores("4");

      Server newServer = profitbricksApi.serverApi.createServer(dataCenterId, server);

      assertNotNull(newServer);
      serverId = newServer.getId();

      Nic nic = new Nic();

      nic.getProperties().setName("SDK TEST FIREWALLRULES - Nic");
      nic.getProperties().setLan("1");

      nic.getEntities().setFirewallrules(null);

      Thread.sleep(5000);
      Nic newNic = profitbricksApi.nicApi.createNic(dataCenterId, serverId, nic);

      assertNotNull(newNic);
      nicId = newNic.getId();

      FirewallRule firewallRule = new FirewallRule();

      firewallRule.getProperties().setProtocol(Protocol.ICMP.toString());
      firewallRule.getProperties().setIcmpType("8");
      firewallRule.getProperties().setIcmpCode("0");
      firewallRule.getProperties().setName("SDK TEST FIREWALLRULES - FirewallRule");

      Thread.sleep(30000);
      FirewallRule newFirewallRule = profitbricksApi.firewallRuleApi.createFirewallRule(dataCenterId, serverId, nicId, firewallRule);

      assertNotNull(newFirewallRule);
      firewallRuleId = newFirewallRule.getId();
   }

   @Test
   public void orderedTest() throws RestClientException, IOException, InterruptedException {
      Thread.sleep(30000);
      getAllFirewallRules();
      getFirewallRule();
      updateFirewallRule();
   }

   public void getAllFirewallRules() throws RestClientException, IOException {
      FirewallRules fireWallRules = profitbricksApi.firewallRuleApi.getAllFirewallRules(dataCenterId, serverId, nicId);
      assertNotNull(fireWallRules);
   }

   public void getFirewallRule() throws RestClientException, IOException {
      FirewallRule firewallRule = profitbricksApi.firewallRuleApi.getFirewallRule(dataCenterId, serverId, nicId, firewallRuleId);
      assertNotNull(firewallRule);
   }

   public void updateFirewallRule() throws RestClientException, IOException {
      PBObject object = new PBObject();
      object.setName("SDK TEST FIREWALLRULES - FirewallRule - changed");

      FirewallRule firewallRule = profitbricksApi.firewallRuleApi.updateFirewWallRule(dataCenterId, serverId, nicId, firewallRuleId, object);

      assertEquals(object.getName(), firewallRule.getProperties().getName());
   }

   @AfterClass
   public static void cleanup() throws RestClientException, IOException {
      profitbricksApi.firewallRuleApi.deleteFirewallRule(dataCenterId, serverId, nicId, firewallRuleId);
      profitbricksApi.dataCenterApi.deleteDataCenter(dataCenterId);
   }

}
