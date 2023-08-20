package Until;

import java.util.Arrays;

public class Replace_Json {
    //为JSON加双引号的工具类
    public String Method_ReplaceJSON(String Content){

        //                jsonStr = jsonStr.replace("{", "{\"");
//                jsonStr = jsonStr.replace(":", "\":\"");
//                jsonStr = jsonStr.replace(",", "\",\"");
//                jsonStr = jsonStr.replace("}", "\"}");
        //System.out.println(jsonStr);

        String result = Arrays.stream(Content.substring(1, Content.length() - 1).split(","))
                .map(v -> "\"" + v.replaceFirst(":", "\":\"") + "\"")
                .reduce("{", (a, b) -> a + b + ",")
                .toString();
        result = result.substring(0, result.length() - 1) + "}";
        return result;
    }
}
