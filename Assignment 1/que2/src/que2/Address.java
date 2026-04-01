/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package que2;

/**
 *
 * @author root
 */


public class Address {
    // Fields
    private String name;
    private String homeAdd;
    private String phone;
    private String businessAdd;
    private String businessNo;
    private String fax;
    private String pager;
    private String mobile;

    // Constructor
    public Address(String name, String homeAdd, String phone, String businessAdd,
                   String businessNo, String fax, String pager, String mobile) {
        this.name = name;
        this.homeAdd = homeAdd;
        this.phone = phone;
        this.businessAdd = businessAdd;
        this.businessNo = businessNo;
        this.fax = fax;
        this.pager = pager;
        this.mobile = mobile;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getHomeAdd() {
        return homeAdd;
    }

    public String getPhone() {
        return phone;
    }

    public String getBusinessAdd() {
        return businessAdd;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public String getFax() {
        return fax;
    }

    public String getPager() {
        return pager;
    }

    public String getMobile() {
        return mobile;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHomeAdd(String homeAdd) {
        this.homeAdd = homeAdd;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBusinessAdd(String businessAdd) {
        this.businessAdd = businessAdd;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
