package com.example.p03__apii_ps;

import java.io.Serializable;

public class DailyGrade implements Serializable {
    private int Date;
    private String DG;
    private String ModuleCode;

    public DailyGrade(int date, String DG, String moduleCode) {
        Date = date;
        this.DG = DG;
        ModuleCode = moduleCode;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public String getDG() {
        return DG;
    }

    public void setDG(String DG) {
        this.DG = DG;
    }

    public String getModuleCode() {
        return ModuleCode;
    }

    public void setModuleCode(String moduleCode) {
        ModuleCode = moduleCode;
    }
}
