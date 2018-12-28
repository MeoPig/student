package com.sinuonan.bean;

import javax.persistence.*;

/**
 * @author liyue
 * @date 2018/12/28 11:22
 */
@Entity
@Table(name = "student_info", schema = "student")
public class StudentInfo {
    private String uuid;
    private String name;
    private Integer schoolId;
    private String gender;
    private String className;
    private Integer teacherId;

    @Id
    @Column(name = "uuid", nullable = false, length = 64)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "schoolId", nullable = true)
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 20)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "className", nullable = true, length = 20)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "teacherId", nullable = true)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentInfo that = (StudentInfo) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (schoolId != null ? !schoolId.equals(that.schoolId) : that.schoolId != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (schoolId != null ? schoolId.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        return result;
    }
}
