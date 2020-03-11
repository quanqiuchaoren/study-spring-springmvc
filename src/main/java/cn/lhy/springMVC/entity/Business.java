package cn.lhy.springMVC.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Enzo Cotter on 2018/12/30.
 */
@Entity
public class Business {
    private int id;
    private String businessName;

    public Business() {
    }

    public Business(String businessName) {
        this.businessName = businessName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Business business = (Business) o;

        if (id != business.id) return false;
        if (businessName != null ? !businessName.equals(business.businessName) : business.businessName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
