/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.demo.backend.nosql;

import com.google.appengine.api.datastore.Entity;
import com.zinglife.NewPhotoUpload.model.DemoUser;

/**
 * User entity class for NoSQL.
 *
 */
public class DemoUserNoSql extends DemoEntityNoSql  implements DemoUser {
  private static final String FIELD_NAME_NICKNAME = "nickname";
  private static final String FIELD_NAME_EMAIL = "email";

  public DemoUserNoSql(Entity entity) {
    super(entity);
  }

  public DemoUserNoSql(String kind, String userId) {
    super(kind, userId);
  }

  
  public String getUserId() {
    return entity.getKey().getName();
  }

  
  public String getEmail() {
    return (String) entity.getProperty(FIELD_NAME_EMAIL);
  }

  
  public void setEmail(String email) {
    entity.setProperty(FIELD_NAME_EMAIL, email);
  }

  
  public String getNickname() {
    return (String) entity.getProperty(FIELD_NAME_NICKNAME);
  }

  
  public void setNickname(String nickname) {
    entity.setProperty(FIELD_NAME_NICKNAME, nickname);
  }
}
