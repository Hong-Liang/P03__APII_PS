package com.example.p03__apii_ps;

public class Module {
    private String ModuleName;
    private String ModuleCode;

    public Module(String moduleName, String moduleCode) {
        ModuleName = moduleName;
        ModuleCode = moduleCode;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public String getModuleCode() {
        return ModuleCode;
    }

    public void setModuleCode(String moduleCode) {
        ModuleCode = moduleCode;
    }
}
