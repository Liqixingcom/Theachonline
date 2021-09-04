package com.atguigu.test.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EduTeacher {

  private String id;
  private String name;
  private String intro;
  private String career;
  private long level;
  private String avatar;
  private long sort;
  private long isDeleted;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;


}
