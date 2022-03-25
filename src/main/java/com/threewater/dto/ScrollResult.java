package com.threewater.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/25/15:05
 * @Description:
 */
@Data
public class ScrollResult {

    private List<?> list;
    private Long minTime;
    private Integer offset;

}
