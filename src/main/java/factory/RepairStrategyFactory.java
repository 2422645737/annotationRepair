package factory;

import enums.RepairEnum;
import impl.ApiModelPropertyRepairStrategy;
import impl.ApiModelRepairStrategy;
import impl.ApiOperationRepairStrategy;
import impl.ApiParamRepairStrategy;
import interfaces.RepairStrategy;

import java.util.HashMap;
import java.util.Map;

public class RepairStrategyFactory {

    private static final Map<String, RepairStrategy> strategyMap = new HashMap<>();

    public static RepairStrategy build(String name){
        if(name == null){
            return null;
        }
        if(strategyMap.get(name) != null){
            return strategyMap.get(name);
        }
        if(name.equalsIgnoreCase(RepairEnum.API_PARAM)){
            strategyMap.put(RepairEnum.API_PARAM,new ApiParamRepairStrategy(RepairEnum.API_PARAM));
        }else if(name.equalsIgnoreCase(RepairEnum.API_MODEL)){
            strategyMap.put(RepairEnum.API_MODEL,new ApiModelRepairStrategy(RepairEnum.API_MODEL));
        }else if(name.equalsIgnoreCase(RepairEnum.API_MODEL_PROPERTY)){
            strategyMap.put(RepairEnum.API_MODEL_PROPERTY,new ApiModelPropertyRepairStrategy(RepairEnum.API_MODEL_PROPERTY));
        }else if(name.equalsIgnoreCase(RepairEnum.API_OPERATION)){
            strategyMap.put(RepairEnum.API_OPERATION,new ApiOperationRepairStrategy(RepairEnum.API_OPERATION));
        }
        return strategyMap.get(name);
    }
}