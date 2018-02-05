package com.mzd.drugstore.bean.generator;

public class MyLog {
    private String logId;

    private String useId;

    private String optionconent;

    private String tablename;

    private String tableId;

    private String createtime;

    private String optionip;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId == null ? null : useId.trim();
    }

    public String getOptionconent() {
        return optionconent;
    }

    public void setOptionconent(String optionconent) {
        this.optionconent = optionconent == null ? null : optionconent.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId == null ? null : tableId.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getOptionip() {
        return optionip;
    }

    public void setOptionip(String optionip) {
        this.optionip = optionip == null ? null : optionip.trim();
    }
}