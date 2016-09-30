package com.longshihan.tool.api;

import com.longshihan.tool.data.BaseResponse;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Administrator
 * @time 2016/9/30 16:56
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public interface JuheWeather {
    //http://op.juhe.cn/onebox/weather/query?cityname=%E6%B8%A9%E5%B7%9E&key
    // =f4b7cbeb87798c23d03e3e529f1fe902
    @POST("{weather}/{query}")
    Observable<BaseResponse> getWheather(
            @Path("weather") String weather,
            @Path("query") String query,
            @FieldMap Map<String,String> map);

}
