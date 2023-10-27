package com.sh.order;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderDTO {
    private String order_code;
    private String user_kakao;
    private String user_code;
    private String user_nickname;
    private String phone_num;
    private String board_id;
    private String board_title;
    private int board_price;
    private String member_post;
    private String member_addr;
    private String detailed_address;
    private String delivery_req;
    private Date order_date;
}
