package com.longshihan.tool.data;

/**
 * @author Administrator
 * @time 2016/9/30 18:07
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class BaseResponse<T> {
    private String resultcode;
    private String reason;
    private T result;
    private int error_code;
}
