package com.kgc.entity;

public class Collage {
    private Integer cid;

    private String cname;

    private String caddress;

    private String createtime;

    private String cpic;

    public Collage(Integer cid, String cname, String caddress, String createtime, String cpic) {
        this.cid = cid;
        this.cname = cname;
        this.caddress = caddress;
        this.createtime = createtime;
        this.cpic = cpic;
    }

    public Collage() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress == null ? null : caddress.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCpic() {
        return cpic;
    }

    public void setCpic(String cpic) {
        this.cpic = cpic == null ? null : cpic.trim();
    }

    @Override
    public String toString() {
        return "Collage{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", caddress='" + caddress + '\'' +
                ", createtime='" + createtime + '\'' +
                ", cpic='" + cpic + '\'' +
                '}';
    }
}