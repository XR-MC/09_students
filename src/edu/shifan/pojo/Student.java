package edu.shifan.pojo;

/**
 * 实体类
 */
public class Student {
    //私有成员字段
    private int stuNo;
    private String stuName;
    private boolean gender;
    private int age;
    private String tel;
    private int gradeId;
    private String address;
    private int state;

    //get/set访问器
    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", gradeId=" + gradeId +
                ", address='" + address + '\'' +
                ", state=" + state +
                '}';
    }
}
