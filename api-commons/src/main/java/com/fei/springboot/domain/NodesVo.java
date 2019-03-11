package com.fei.springboot.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_nodes
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-26 09:49:13
 */
public class NodesVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //用户id
    private String userid;
    //手机号
    private String telephone;
    //标题
    private String title;
    //副标题
    private String subtitle;
    //日期
    private Date date;
    //对谁写的
    private String foruser;
    //类型，1日记，2网页
    private Integer type;
    //模板id
    private String templete;
    //配图
    private String titleimage;
    //是否显示
    private Integer isshow;
    //是否置顶
    private Integer istop;
    //扩展数据1
    private String ext1;
    //
    private String ext2;
    //
    private String ext3;
    //
    private String ext4;
    //
    private String ext5;
    //
    private String ext6;
    //
    private String ext7;
    //
    private String ext8;
    //
    private String ext9;
    //
    private String ext10;
    //
    private String ext11;
    //
    private String ext12;
    //
    private String ext13;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取：用户id
     */
    public String getUserid() {
        return userid;
    }
    /**
     * 设置：手机号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取：手机号
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：副标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 获取：副标题
     */
    public String getSubtitle() {
        return subtitle;
    }
    /**
     * 设置：日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取：日期
     */
    public Date getDate() {
        return date;
    }
    /**
     * 设置：对谁写的
     */
    public void setForuser(String foruser) {
        this.foruser = foruser;
    }

    /**
     * 获取：对谁写的
     */
    public String getForuser() {
        return foruser;
    }
    /**
     * 设置：类型，1日记，2网页
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：类型，1日记，2网页
     */
    public Integer getType() {
        return type;
    }
    /**
     * 设置：模板id
     */
    public void setTemplete(String templete) {
        this.templete = templete;
    }

    /**
     * 获取：模板id
     */
    public String getTemplete() {
        return templete;
    }
    /**
     * 设置：配图
     */
    public void setTitleimage(String titleimage) {
        this.titleimage = titleimage;
    }

    /**
     * 获取：配图
     */
    public String getTitleimage() {
        return titleimage;
    }
    /**
     * 设置：是否显示
     */
    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }

    /**
     * 获取：是否显示
     */
    public Integer getIsshow() {
        return isshow;
    }
    /**
     * 设置：是否置顶
     */
    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    /**
     * 获取：是否置顶
     */
    public Integer getIstop() {
        return istop;
    }
    /**
     * 设置：扩展数据1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * 获取：扩展数据1
     */
    public String getExt1() {
        return ext1;
    }
    /**
     * 设置：
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    /**
     * 获取：
     */
    public String getExt2() {
        return ext2;
    }
    /**
     * 设置：
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    /**
     * 获取：
     */
    public String getExt3() {
        return ext3;
    }
    /**
     * 设置：
     */
    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    /**
     * 获取：
     */
    public String getExt4() {
        return ext4;
    }
    /**
     * 设置：
     */
    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    /**
     * 获取：
     */
    public String getExt5() {
        return ext5;
    }
    /**
     * 设置：
     */
    public void setExt6(String ext6) {
        this.ext6 = ext6;
    }

    /**
     * 获取：
     */
    public String getExt6() {
        return ext6;
    }
    /**
     * 设置：
     */
    public void setExt7(String ext7) {
        this.ext7 = ext7;
    }

    /**
     * 获取：
     */
    public String getExt7() {
        return ext7;
    }
    /**
     * 设置：
     */
    public void setExt8(String ext8) {
        this.ext8 = ext8;
    }

    /**
     * 获取：
     */
    public String getExt8() {
        return ext8;
    }
    /**
     * 设置：
     */
    public void setExt9(String ext9) {
        this.ext9 = ext9;
    }

    /**
     * 获取：
     */
    public String getExt9() {
        return ext9;
    }
    /**
     * 设置：
     */
    public void setExt10(String ext10) {
        this.ext10 = ext10;
    }

    /**
     * 获取：
     */
    public String getExt10() {
        return ext10;
    }
    /**
     * 设置：
     */
    public void setExt11(String ext11) {
        this.ext11 = ext11;
    }

    /**
     * 获取：
     */
    public String getExt11() {
        return ext11;
    }
    /**
     * 设置：
     */
    public void setExt12(String ext12) {
        this.ext12 = ext12;
    }

    /**
     * 获取：
     */
    public String getExt12() {
        return ext12;
    }
    /**
     * 设置：
     */
    public void setExt13(String ext13) {
        this.ext13 = ext13;
    }

    /**
     * 获取：
     */
    public String getExt13() {
        return ext13;
    }
}
