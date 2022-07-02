package com.example.xiugou.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HostServer {
    String host;
    String port;
    String wss_port;
    String ws_port;
}
