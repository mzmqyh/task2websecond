package com.jnshu;

import org.apache.ibatis.jdbc.SQL;

public class StudentDynaSqlProvider {
        public String list() {
            return new SQL().SELECT("*").FROM("student").toString();
        }
        public String get() {
            return new SQL()
                    .SELECT("*")
                    .FROM("student")
                    .WHERE("id=#{id}")
                    .toString();
        }
        public String add(){
            return new SQL()
                    .INSERT_INTO("student")
                    .VALUES("name", "#{name}")
                    .toString();
        }
        public String update(){
            return new SQL()
                    .UPDATE("student")
                    .SET("name=#{name}","qq=#{qq}","number=#{number}","coachName=#{coachName}","dailyLink=#{dailyLink}","gradeColleage=#{gradeColleage}","update_at=#{update_at}" )
                    .WHERE("id=#{id}")
                    .toString();
        }
        public String delete(){
            return new SQL()
                    .DELETE_FROM("student")
                    .WHERE("id=#{id}")
                    .toString();
        }
    }
