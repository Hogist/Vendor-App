package com.example.vendor;

public class OrderListDataModel {

    private String OrderID;
    private String EnterpriseName;
    private String Quantity;
    private String OrderStatus;
    private String TotalOrderPrise;
    private String BreakfastItemList;
    private String LunchItemList;
    private String DinnerItemList;
    private  String SnacksItemList;
    private String CreatedDateTime;
    private String DeliveryAddress;

    public OrderListDataModel(String orderID, String enterpriseName, String quantity, String orderStatus,String totalOrderPrise,String breakfastItemList,String lunchItemList,
                              String dinnerItemList,String snacksItemList,String createdDateTime,String deliveryAddress) {
        OrderID = orderID;
        EnterpriseName =enterpriseName ;
        Quantity = quantity;
        OrderStatus = orderStatus;
        TotalOrderPrise = totalOrderPrise;
        BreakfastItemList = breakfastItemList;
        LunchItemList = lunchItemList;
        DinnerItemList = dinnerItemList;
        SnacksItemList = snacksItemList;
        CreatedDateTime = createdDateTime;
        DeliveryAddress = deliveryAddress;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getEnterpriseName() {
        return EnterpriseName;
    }


    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getTotalOrderPrise(){return TotalOrderPrise;}

    public void setTotalOrderPrise(String totalOrderPrise){TotalOrderPrise = totalOrderPrise;}

    public String getBreakfastItemList(){return BreakfastItemList;}

    public void setBreakfastItemList(String breakfastItemList){BreakfastItemList = breakfastItemList;}

    public String getLunchItemList(){return LunchItemList;}

    public void setLunchItemList(String lunchItemList){LunchItemList = lunchItemList;}

    public String getDinnerItemList(){return DinnerItemList;}
    public void setDinnerItemList(String dinnerItemList){DinnerItemList = dinnerItemList;}

    public String getSnacksItemList(){return SnacksItemList;}
    public void setSnacksItemList(String snacksItemList){SnacksItemList = snacksItemList;}

    public String getCreatedDateTime(){return CreatedDateTime;}
    public void setCreatedDateTime(String createdDateTime){CreatedDateTime = createdDateTime;}

    public String getDeliveryAddress(){return DeliveryAddress;}
    public void setDeliveryAddress(String dinnerItemList){DinnerItemList = dinnerItemList;}


}
