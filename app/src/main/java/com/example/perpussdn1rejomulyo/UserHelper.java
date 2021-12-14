package com.example.perpussdn1rejomulyo;

public class UserHelper {
    String name, datebirth, school, gender, usertype;

    public UserHelper(String name, String datebirth, String school, String gender, String usertype) {
        this.name = name;
        this.datebirth = datebirth;
        this.school = school;
        this.gender = gender;
        this.usertype = usertype;
    }

    public UserHelper() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
