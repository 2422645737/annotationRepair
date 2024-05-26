import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Long> config = getConfig();
        for (Long aLong : config) {
            System.out.println(aLong);
        }
    }
    private static List<Long> getConfig(){
        String config = "{\"open\":\"1\",\"chargeClassIdList\":[111154548818487458478,2,3]}";
        try{
            JSONObject jsonObject = JSONObject.parseObject(config);
            String open = (String) jsonObject.get("open");

            if(NumberUtils.INTEGER_ZERO.toString().equals(open)){
                return new ArrayList<>();
            }
            //获取只允许开药的挂号类别
            JSONArray chargeClassIdList = jsonObject.getJSONArray("chargeClassIdList");
            if(null == chargeClassIdList || chargeClassIdList.size() == 0){
                return new ArrayList<>();
            }
            List<Long> result = new ArrayList<>();
            for (int i = 0; i < chargeClassIdList.size(); i++) {
                result.add(chargeClassIdList.getLong(i));
            }
            return result;
        }catch (Exception e){
            return new ArrayList<>();
        }

    }
}
