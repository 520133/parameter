//package com.parameter.wechat;
//
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.Map;
//import java.util.SortedMap;
//import java.util.TreeMap;
//
//public class M1 {
//    private String placeUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//
//
//    public Map createOrder(String orderId, Integer price, String body, String ipAddress) throws IOException {
//        SortedMap<String, Object> parameters = new TreeMap<String, Object>();
//        parameters.put("appid", "wx6e6f2528aaa8ca56");
//        parameters.put("mch_id", "1601974465");//商铺id
//        parameters.put("body", body);//标题
//        parameters.put("nonce_str", WxUtils.gen32RandomString()); // 32 位随机字符串
//        parameters.put("notify_url", "http://www.weixin.qq.com/wxpay/pay.php");
//        parameters.put("out_trade_no", orderId);//订单id
//        parameters.put("total_fee", price.intValue());//价格
//        parameters.put("spbill_create_ip", ipAddress);//本地ip
//        parameters.put("trade_type", "APP");//app
//        parameters.put("sign", WxUtils.createSign(parameters, "90f5b8124bdd8aead31bdb8689607984")); // sign 必须在最后
//        String result = WxUtils.executeHttpPost(placeUrl, parameters); // 执行 HTTP 请求，获取接收的字符串（一段 XML）
//        System.out.println(result);
//        return WxUtils.createSign2(result, "f8d490bfe542606cbe4feea47dbb995f");
//    }
//
//
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(new M1().createOrder("20150806dddddddd12534q12126212", 150, "t11est","127.0.0.1"));;
//
//    }
//
//}
