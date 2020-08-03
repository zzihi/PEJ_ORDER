package PEJ.external;

import PEJ.Shipped;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

public class Delivery {

    private Long id;
    private Long orderId;
    private String deliveryStatus;
    private String prdId;
    private Integer prdQty;
    private Integer prdPrice;
    private String prdNm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }
    public Integer getPrdQty() {
        return prdQty;
    }

    public void setPrdQty(Integer prdQty) {
        this.prdQty = prdQty;
    }

    public Integer getPrdPrice() {
        return prdPrice;
    }

    public void setPrdPrice(Integer prdPrice) {
        this.prdPrice = prdPrice;
    }

    public String getPrdNm() {
        return prdNm;
    }

    public void setPrdNm(String prdNm) {
        this.prdNm = prdNm;
    }
}
