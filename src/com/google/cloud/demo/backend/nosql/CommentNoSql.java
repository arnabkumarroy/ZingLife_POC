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

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.zinglife.NewPhotoUpload.model.Comment;

/**
 * Comment entity for NoSQL.
 *
 */
public class CommentNoSql extends DemoEntityNoSql implements Comment {
  public static final String FIELD_NAME_PHOTO_ID = "photoId";
  public static final String FIELD_NAME_PHOTO_OWNER_ID = "ownerId";
  public static final String FIELD_NAME_TIMESTAMP = "timestamp";
  public static final String FIELD_NAME_CONTENT = "content";
  public static final String FIELD_NAME_COMMENT_OWNER_NAME = "owner";

  public CommentNoSql(Entity entity) {
    super(entity);
  }

  public CommentNoSql(Key parentKey, String kind) {
    super(parentKey, kind);
  }

  public static final String getKind() {
    return Comment.class.getSimpleName();
  }

  public String getContent() {
    return (String) entity.getProperty(FIELD_NAME_CONTENT);
  }

  public void setContent(String content) {
    entity.setProperty(FIELD_NAME_CONTENT, content);
  }

  
  public long getTimestamp() {
    Long timestamp = (Long) entity.getProperty(FIELD_NAME_TIMESTAMP);
    return timestamp == null ? 0 : timestamp;
  }

  
  public void setTimestamp(long timestamp) {
    entity.setProperty(FIELD_NAME_TIMESTAMP, timestamp);
  }

  
  public long getPhotoId() {
    Long photoId = (Long) entity.getProperty(FIELD_NAME_PHOTO_ID);
    return photoId == null ? 0 : photoId;
  }

  
  public void setPhotoId(long photoId) {
    entity.setProperty(FIELD_NAME_PHOTO_ID, photoId);
  }

  
  public String getPhotoOwnerId() {
    return (String) entity.getProperty(FIELD_NAME_PHOTO_OWNER_ID);
  }

  
  public void setPhotoOwnerId(String owner) {
    entity.setProperty(FIELD_NAME_PHOTO_OWNER_ID, owner);
  }

  public String getCommentOwnerName() {
    return (String) entity.getProperty(FIELD_NAME_COMMENT_OWNER_NAME);
  }

  
  public void setCommentOwnerName(String owner) {
    entity.setProperty(FIELD_NAME_COMMENT_OWNER_NAME, owner);
  }

  
  public Long getId() {
    return entity.getKey().getId();
  }

  public String getCommentOwnerId() {
    return entity.getParent().getName();
  }
}
