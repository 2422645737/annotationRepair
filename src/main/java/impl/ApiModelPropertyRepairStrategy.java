package impl;

import entity.AbstractRegexMatcher;
import interfaces.RepairStrategy;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiModelPropertyRepairStrategy extends AbstractRegexMatcher implements RepairStrategy {

    public ApiModelPropertyRepairStrategy(String pattern) {
        super(pattern);
    }

    @Override
    public void repair(File file) {
        //读取文件内容
        StringBuffer newContent = new StringBuffer(readFile(file));

        //如果当前文件中没有依赖，则首先添加依赖
        if(newContent.indexOf("io.swagger.annotations.ApiModelProperty") == -1){
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModelProperty;\n");
        }
        String replace = newContent.toString();
                //replace(newContent.toString());
//        String compile = "\\s*\\/\\*\\*\\s*\\r\\n\\s*\\*\\s*([^\\r\\n]*)\\r\\n\\s*\\*\\/(((\\r\\n\\s*.*?)+)private\\s*([a-z]|[A-Z]|[0-9]|>|<|_)*\\s*([a-z]|[A-Z]|[0-9]|>|<|_)*;)";
//        Matcher matcher = Pattern.compile(compile).matcher(replace);
//
//        while(matcher.find()){
//            String group = matcher.group();
//            String comment = Pattern.compile(compile).matcher(group).replaceAll("$1");
//            System.out.println(group);
//            if(!group.contains("ApiModelProperty")){
//                String replace1 = group.replace("private", "@ApiModelProperty(value = \"" + comment + "\")\n\tprivate");
//                replace = replace.replace(group,replace1);
//            }
//        }

        //处理没有注释并且前面带有注解的参数（如果需要跳过注解修复ApiModelProperty，把这段代码放开，不然很影响效率）
        String compile = "\\s\\s@.*(((\\r\\n\\s*.*?)+)private\\s*([a-z]|[A-Z]|[0-9]|>|<|_)*\\s*(([a-z]|[A-Z]|[0-9]|>|<|_)*);)";
        Matcher matcher = Pattern.compile(compile).matcher(replace);
        while(matcher.find()){
            String group = matcher.group();
            String comment = Pattern.compile(compile).matcher(group).replaceAll("$5");
            System.out.println(group);
            if(!group.contains("ApiModelProperty")){
                String replace1 = group.replace("private", "@ApiModelProperty(value = \"" + comment + "\")\n\tprivate");
                replace = replace.replace(group,replace1);
            }
        }

        writeFile(replace,file);
    }
}