package com.ztj.springbootdemo.properties;

import lombok.Data;

@Data
public class DBProperties {

    private String lan;
    private String databasePlatform;

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getDatabasePlatform() {
        return databasePlatform;
    }

    public void setDatabasePlatform(String databasePlatform) {
        this.databasePlatform = databasePlatform;
    }

}
