package utils;


public class NewlyGeneratedOrderId{

    private static  String newOrderId;

    public static String getNewOrderId(){
        return newOrderId;
    }

    public static String setNewOrderId(String orderId){
        newOrderId=orderId;
        return orderId;
    }

}
