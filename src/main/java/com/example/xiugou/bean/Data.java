package com.example.xiugou.bean;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data {
    float refresh_row_factor;
    int refresh_rate;
    int max_delay;
    int port;
    String host;
    List<HostServer> host_server_list;
    List<HostServer> server_list;
    String token;
}
