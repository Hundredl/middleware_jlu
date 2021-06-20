package javaee.book.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServletUtils {
    public static Map<String, Object> getPostParams(HttpServletRequest req) throws IOException {
        // 返回参数
        Map<String, Object> params = new HashMap<>();
        // 获取内容格式
        String contentType = req.getContentType();
        if (contentType != null && !contentType.equals("")) {
            contentType = contentType.split(";")[0];
        }

        // form表单格式  表单形式可以从 ParameterMap中获取
        if ("appliction/x-www-form-urlencoded".equalsIgnoreCase(contentType)) {
            // 获取参数
            Map<String, String[]> parameterMap = req.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }

        // json格式 json格式需要从request的输入流中解析获取
        if ("application/json".equalsIgnoreCase(contentType)) {
            // 使用 commons-io中 IOUtils 类快速获取输入流内容
            String paramJson = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
            Map<String, Object> parseObject = JSON.parseObject(paramJson, Map.class);
            params.putAll(parseObject);
        }
        return params;
    }

    public static <T> void returnResp(HttpServletResponse resp, GlobalVar.RespMsg msg, T data) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Resp<T> result=new Resp<>();
        result.setMsg(msg.toString());
        result.setData(data);
        resp.getWriter().println(JSON.toJSON(result));
    }
}
