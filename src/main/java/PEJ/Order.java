package PEJ;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String orderStatus="ORDERED";

    private String prdId;
    private Integer prdQty;
    private Integer prdPrice;
    private String prdNm;

    @PostPersist
    public void onPostPersist(){

        Ordered ordered = new Ordered();

        BeanUtils.copyProperties(this, ordered);
        ordered.publishAfterCommit();

    }


    @PreUpdate
    public void onPreUpdate(){
        System.out.println("orderCanceled.setOrderStatus(\"CANCELLED\")");
        if("CANCELLED".equals(this.orderStatus)){

            OrderCanceled orderCanceled = new OrderCanceled();
            BeanUtils.copyProperties(this, orderCanceled);
            orderCanceled.setOrderStatus("CANCELLED");
            orderCanceled.publishAfterCommit();

            PEJ.external.Delivery delivery = new PEJ.external.Delivery();
            delivery.setOrderId(orderCanceled.getOrderId());
            delivery.setDeliveryStatus("CANCELLED");

            OrderApplication.applicationContext.getBean(PEJ.external.DeliveryService.class)
                    .cancelDelivery(delivery);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
