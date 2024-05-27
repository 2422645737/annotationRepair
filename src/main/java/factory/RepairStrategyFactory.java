package factory;

import enums.RepairEnum;
import impl.ApiModelPropertyRepairStrategy;
import impl.ApiModelRepairStrategy;
import impl.ApiParamRepairStrategy;
import interfaces.RepairStrategy;

import java.util.HashMap;
import java.util.Map;

public class RepairStrategyFactory {

    private static Map<String, RepairStrategy> strategyMap = new HashMap<>();
    public static RepairStrategy build(String name){
        if(name == null){
            return null;
        }
        if(strategyMap.get(name) != null){
            return strategyMap.get(name);
        }
        if(name.equalsIgnoreCase(RepairEnum.API_PARAM)){
            RepairStrategy repairStrategy = new ApiParamRepairStrategy();
            strategyMap.put(RepairEnum.API_PARAM,repairStrategy);
        }else if(name.equalsIgnoreCase(RepairEnum.API_MODEL)){
            RepairStrategy repairStrategy = new ApiModelRepairStrategy();
            strategyMap.put(RepairEnum.API_MODEL,repairStrategy);
        }else if(name.equalsIgnoreCase(RepairEnum.API_MODEL_PROPERTY)){
            RepairStrategy repairStrategy = new ApiModelPropertyRepairStrategy();
            strategyMap.put(RepairEnum.API_MODEL_PROPERTY,repairStrategy);
        }
        return strategyMap.get(name);
    }
}
