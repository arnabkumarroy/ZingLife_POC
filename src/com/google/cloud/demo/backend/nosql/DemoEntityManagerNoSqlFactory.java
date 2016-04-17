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

import com.zinglife.NewPhotoUpload.model.CommentManager;
import com.zinglife.NewPhotoUpload.model.DemoEntityManagerFactory;
import com.zinglife.NewPhotoUpload.model.DemoUserManager;
import com.zinglife.NewPhotoUpload.model.PhotoManager;
import com.zinglife.NewPhotoUpload.view.ConfigManager;

/**
 * Entity manager factory implementation for NoSQL.
 *
 */
public class DemoEntityManagerNoSqlFactory implements DemoEntityManagerFactory {
  private DemoUserManagerNoSql demoUserManager;
  private PhotoManagerNoSql photoManager;
  private CommentManagerNoSql commentManager;
  private boolean initialized;

  public PhotoManager getPhotoManager() {
    return photoManager;
  }

  
  public CommentManager getCommentManager() {
    return commentManager;
  }

  
  public DemoUserManager getDemoUserManager() {
    return demoUserManager;
  }


  
  public void init(ConfigManager configManager) {
    if (!initialized) {
      demoUserManager = new DemoUserManagerNoSql();
      photoManager = new PhotoManagerNoSql(demoUserManager);
      commentManager = new CommentManagerNoSql(demoUserManager);
      initialized = true;
    } else {
      throw new IllegalStateException("Should not initialize the factory more than once.");
    }
  }
}
