package com.raven.model;

import javax.swing.Icon;

public class ModelStaff {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelStaff(Icon icon, String name, String gender, String email, String status) {
        this.icon = icon;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    public ModelStaff() {
    }

    private Icon icon;
    private String name;
    private String gender;
    private String email;
    private String status;

    public Object[] toDataTable() {
        return new Object[]{icon, name, gender, email, status};
    }
}
