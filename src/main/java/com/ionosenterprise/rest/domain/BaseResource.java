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

package com.ionosenterprise.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

public class BaseResource {

   private String id;
   private String type;
   private String href;
   private Metadata metadata;
   private String requestId;

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
    * @return the requestId
    */
   public String getRequestId() {
      return requestId;
   }

   /**
    * @param requestId the requestId to set
    */
   public void setRequestId(String requestId) {
      this.requestId = requestId;
   }

   @JsonIgnoreProperties(ignoreUnknown = true)
   public static class Metadata {

      private Date lastModifiedDate;
      private String lastModifiedBy;
      private String lastModifiedByUserId;
      private Date createdDate;
      private String createdBy;
      private String createdByUserId;
      private State state;
      private String etag;

      /**
       * @return the lastModifiedDate
       */
      public Date getLastModifiedDate() {
         return lastModifiedDate;
      }

      /**
       * @param lastModifiedDate the lastModifiedDate to set
       */
      public void setLastModifiedDate(Date lastModifiedDate) {
         this.lastModifiedDate = lastModifiedDate;
      }

      /**
       * @return the lastModifiedBy
       */
      public String getLastModifiedBy() {
         return lastModifiedBy;
      }

      /**
       * @param lastModifiedBy the lastModifiedBy to set
       */
      public void setLastModifiedBy(String lastModifiedBy) {
         this.lastModifiedBy = lastModifiedBy;
      }

      /**
       * @return the createdDate
       */
      public Date getCreatedDate() {
         return createdDate;
      }

      /**
       * @param createdDate the createdDate to set
       */
      public void setCreatedDate(Date createdDate) {
         this.createdDate = createdDate;
      }

      /**
       * @return the createdBy
       */
      public String getCreatedBy() {
         return createdBy;
      }

      /**
       * @param createdBy the createdBy to set
       */
      public void setCreatedBy(String createdBy) {
         this.createdBy = createdBy;
      }

      /**
       * @return the state
       */
      public State getState() {
         return state;
      }

      /**
       * @param state the state to set
       */
      public void setState(State state) {
         this.state = state;
      }

      /**
       * @return the etag
       */
      public String getEtag() {
         return etag;
      }

      /**
       * @param etag the etag to set
       */
      public void setEtag(String etag) {
         this.etag = etag;
      }

      /**
       *
       * @return the lastModifiedByUserId
       */
      public String getLastModifiedByUserId() {
         return lastModifiedByUserId;
      }

      /**
       *
       * @param lastModifiedByUserId the lastModifiedByUserId to be set
       */
      public void setLastModifiedByUserId(String lastModifiedByUserId) {
         this.lastModifiedByUserId = lastModifiedByUserId;
      }

      /**
       *
       * @return the createdByUserId
       */
      public String getCreatedByUserId() {
         return createdByUserId;
      }

      /**
       *
       * @param createdByUserId the createdByUserId to be set
       */
      public void setCreatedByUserId(String createdByUserId) {
         this.createdByUserId = createdByUserId;
      }
   }

   /**
    * Common properties for all resources holding Live Vertical Scaling features.
    */
   @JsonIgnoreProperties(ignoreUnknown = true)
   public class LvsProperties {

      private LicenceType licenceType;
      private Boolean cpuHotPlug;
      private Boolean cpuHotUnplug;
      private Boolean ramHotPlug;
      private Boolean ramHotUnplug;
      private Boolean nicHotPlug;
      private Boolean nicHotUnplug;
      private Boolean discVirtioHotPlug;
      private Boolean discVirtioHotUnplug;
      private Boolean discScsiHotPlug;
      private Boolean discScsiHotUnplug;

      public LicenceType getLicenceType() {
         return licenceType;
      }

      public void setLicenceType(LicenceType licenceType) {
         this.licenceType = licenceType;
      }

      public Boolean getCpuHotPlug() {
         return cpuHotPlug;
      }

      public void setCpuHotPlug(Boolean cpuHotPlug) {
         this.cpuHotPlug = cpuHotPlug;
      }

      public Boolean getCpuHotUnplug() {
         return cpuHotUnplug;
      }

      public void setCpuHotUnplug(Boolean cpuHotUnplug) {
         this.cpuHotUnplug = cpuHotUnplug;
      }

      public Boolean getRamHotPlug() {
         return ramHotPlug;
      }

      public void setRamHotPlug(Boolean ramHotPlug) {
         this.ramHotPlug = ramHotPlug;
      }

      public Boolean getRamHotUnplug() {
         return ramHotUnplug;
      }

      public void setRamHotUnplug(Boolean ramHotUnplug) {
         this.ramHotUnplug = ramHotUnplug;
      }

      public Boolean getNicHotPlug() {
         return nicHotPlug;
      }

      public void setNicHotPlug(Boolean nicHotPlug) {
         this.nicHotPlug = nicHotPlug;
      }

      public Boolean getNicHotUnplug() {
         return nicHotUnplug;
      }

      public void setNicHotUnplug(Boolean nicHotUnplug) {
         this.nicHotUnplug = nicHotUnplug;
      }

      public Boolean getDiscVirtioHotPlug() {
         return discVirtioHotPlug;
      }

      public void setDiscVirtioHotPlug(Boolean discVirtioHotPlug) {
         this.discVirtioHotPlug = discVirtioHotPlug;
      }

      public Boolean getDiscVirtioHotUnplug() {
         return discVirtioHotUnplug;
      }

      public void setDiscVirtioHotUnplug(Boolean discVirtioHotUnplug) {
         this.discVirtioHotUnplug = discVirtioHotUnplug;
      }

      public Boolean getDiscScsiHotPlug() {
         return discScsiHotPlug;
      }

      public void setDiscScsiHotPlug(Boolean discScsiHotPlug) {
         this.discScsiHotPlug = discScsiHotPlug;
      }

      public Boolean getDiscScsiHotUnplug() {
         return discScsiHotUnplug;
      }

      public void setDiscScsiHotUnplug(Boolean discScsiHotUnplug) {
         this.discScsiHotUnplug = discScsiHotUnplug;
      }
   }
}

