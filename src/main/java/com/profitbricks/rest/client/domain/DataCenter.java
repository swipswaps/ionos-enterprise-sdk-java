/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profitbricks.rest.client.domain;

import java.util.Date;

/**
 *
 * @author jasmin.gacic
 */
public class DataCenter {

   private String id;
   private String type;
   private Metadata metadata;
   private String href;

   private Properties properties = new Properties();
   private Entities entities = new Entities();

   /**
    * @return the id
    */
   public String getId() {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(String id) {
      this.id = id;
   }

   /**
    * @return the type
    */
   public String getType() {
      return type;
   }

   /**
    * @param type the type to set
    */
   public void setType(String type) {
      this.type = type;
   }

   /**
    * @return the metadata
    */
   public Metadata getMetadata() {
      return metadata;
   }

   /**
    * @param metadata the metadata to set
    */
   public void setMetadata(Metadata metadata) {
      this.metadata = metadata;
   }

   /**
    * @return the href
    */
   public String getHref() {
      return href;
   }

   /**
    * @param href the href to set
    */
   public void setHref(String href) {
      this.href = href;
   }

   /**
    * @return the properties
    */
   public Properties getProperties() {
      return properties;
   }

   /**
    * @param properties the properties to set
    */
   public void setProperties(Properties properties) {
      this.properties = properties;
   }

   /**
    * @return the entities
    */
   public Entities getEntities() {
      return entities;
   }

   /**
    * @param entities the entities to set
    */
   public void setEntities(Entities entities) {
      this.entities = entities;
   }

}
