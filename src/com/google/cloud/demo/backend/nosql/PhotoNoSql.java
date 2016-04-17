/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.demo.backend.nosql;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.zinglife.NewPhotoUpload.model.Photo;

/**
 * Photo entity for NoSQL.
 *
 */
public class PhotoNoSql extends DemoEntityNoSql implements Photo {
  static final String FIELD_NAME_OWNER_ID = "ownerId";
  static final String FIELD_NAME_OWNER_NICKNAME = "owner";
  static final String FIELD_NAME_TITLE = "title";
  static final String FIELD_NAME_SHARED = "shared";
  static final String FIELD_NAME_BLOB_KEY = "blobKey";
  static final String FIELD_NAME_UPLOAD_TIME = "uploadTime";
  static final String FIELD_NAME_ACTIVE = "active";


  public PhotoNoSql(Entity entity) {
    super(entity);
  }

  public PhotoNoSql(Key parentKey, String kind) {
    super(parentKey, kind);
    setActive(true);
    entity.setProperty(FIELD_NAME_OWNER_ID, parentKey.getName());
  }

  
  public BlobKey getBlobKey() {
    return (BlobKey) entity.getProperty(FIELD_NAME_BLOB_KEY);
  }

  
  public void setBlobKey(BlobKey blobKey) {
    entity.setProperty(FIELD_NAME_BLOB_KEY, blobKey);
  }

  
  public boolean isShared() {
    Boolean shared = (Boolean) entity.getProperty(FIELD_NAME_SHARED);
    return shared != null && shared;
  }

  
  public void setShared(boolean shared) {
    entity.setProperty(FIELD_NAME_SHARED, shared);
  }

  
  public String getTitle() {
    return (String) entity.getProperty(FIELD_NAME_TITLE);
  }

  
  public void setTitle(String title) {
    entity.setProperty(FIELD_NAME_TITLE, title);
  }

  public String getOwnerNickname() {
    return (String) entity.getProperty(FIELD_NAME_OWNER_NICKNAME);
  }

  
  public void setOwnerNickname(String nickename) {
    entity.setProperty(FIELD_NAME_OWNER_NICKNAME, nickename);
  }

  
  public String getOwnerId() {
    return (String) entity.getProperty(FIELD_NAME_OWNER_ID);
  }

  
  public long getUploadTime() {
    return (Long) entity.getProperty(FIELD_NAME_UPLOAD_TIME);
  }

  
  public void setUploadTime(long uploadTime) {
    entity.setProperty(FIELD_NAME_UPLOAD_TIME, uploadTime);
  }

  
  public Long getId() {
    return entity.getKey().getId();
  }

  
  public boolean isActive() {
    Boolean active = (Boolean) entity.getProperty(FIELD_NAME_ACTIVE);
    // By default, if not set false, a photo is active.
    return active != null && active;
  }

  
  public void setActive(boolean active) {
    entity.setProperty(FIELD_NAME_ACTIVE, active);
  }
}
