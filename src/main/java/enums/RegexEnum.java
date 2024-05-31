package enums;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 匹配正则枚举
 * @fileName: RegexEnum
 * @author: wanghui
 * @createAt: 2024/05/29 05:01:13
 * @updateBy:
 * @copyright: 众阳健康
 */
public class RegexEnum {
    public static List<Pair<String,String>> apiParamRegex = new ArrayList<>(16);
    static {
        /**
         * 修复ApiParam缺失的问题
         */
        //在(@Validated 前面添加ApiParam
        apiParamRegex.add(Pair.of("\\(\\s*@Validated","(@ApiParam(value = \"请求参数\",example = \"参数示例\") @Validated"));
        //在(@NotNull 前面添加ApiParam
        apiParamRegex.add(Pair.of("\\(\\s*@NotNull","(@ApiParam(value = \"请求参数\",example = \"参数示例\") @NotNull"));
        //在(@NotBlank 前面添加ApiParam
        apiParamRegex.add(Pair.of("\\(\\s*@NotNull","(@ApiParam(value = \"请求参数\",example = \"参数示例\") @NotNull"));
        //修复@RequestBody Object obj1
        apiParamRegex.add(Pair.of("([\\(|,]+)\\s*(@RequestBody|@RequestParam)\\s*(([a-z]|[A-Z]|[0-9]|>|<)+\\s*(([a-z]|[A-Z]|[0-9]|_)*))","$1$2 @ApiParam(value = \"$5\",example = \"示例参数\") $3"));
        //修复@RequestParam("你好") Object ofb2j1
        apiParamRegex.add(Pair.of("([\\(|,]+)\\s*((@RequestBody|@RequestParam)\\s*(\\(\\s*\\\"([^\\s]*)\\\"\\s*\\))+\\s*)(([a-z]|[A-Z]|[0-9]|>|<)+\\s*(([a-z]|[A-Z]|[0-9]|_)*))","$1$2@ApiParam(value = \"$5\",example = \"示例参数\") $6"));
        //修复@RequestParam(name = "你好") Object ofb2j1
        apiParamRegex.add(Pair.of("([\\(|,]+)\\s*((@RequestBody|@RequestParam)\\s*(\\((\\s*name\\s*=\\s*)+\\\"([^\\s]*)\\\"\\s*\\))+\\s*)(([a-z]|[A-Z]|[0-9]|>|<)+\\s*(([a-z]|[A-Z]|[0-9]|_)*))","$1$2@ApiParam(value = \"$6\",example = \"示例参数\") $7"));
        //修复无RequestBody和RequestParam，只有单纯一个参数的注解，比如 public ResponseResult getDataJson(MzPdfFileDTO mzPdfFileDTO) {}
        apiParamRegex.add(Pair.of("(public\\s*([a-z]|[A-Z]|>|<|_)+\\s*([a-z]|[A-Z]|>|<|_)+\\()(([a-z]|[A-Z]|>|<|_)+\\s*(([a-z]|[A-Z]|>|<|_)+)\\s*\\))","$1@ApiParam(value = \"$6\" , example = \"示例参数\") $4"));
        /**
         * 修复不标准情况
         */
        //修复@ApiParam(value = "abc")
        apiParamRegex.add(Pair.of("@ApiParam\\(\\s*value\\s*=\\s*(\\\"[^\\\"]*\\\")\\s*\\)","@ApiParam(value = $1,example = \"参数示例\")"));
        //修复@ApiParam("abc")
        apiParamRegex.add(Pair.of("@ApiParam\\(\\s*(\\\"[^\\\"]+\\\")\\s*\\)","@ApiParam(value = $1,example = \"参数示例\")"));
        //修复@ApiParam("")
        apiParamRegex.add(Pair.of("@ApiParam\\(\\s*(\\\"[^\\\"]*\\\")\\s*\\)","@ApiParam(value = \"请求参数\",example = \"参数示例\")"));

    }

    public static List<Pair<String,String>> apiModelRegex = new ArrayList<>(16);
    static {
        //处理有ApiModel注解，但是注解不规范的情况，例如ApiModel("abc")
        apiModelRegex.add(Pair.of("@ApiModel\\(\\s*\"([^\"]+)\"\\)","@ApiModel(description = \"$1\")"));
    }

    public static List<Pair<String,String>> apiModelPropertyRegex = new ArrayList<>();
    static {
        //处理没有ApiModelProperty注解的情况（有/**/标准注释）
        apiModelPropertyRegex.add(Pair.of("(\\/\\*\\*\\r\\n\\s*\\*([^\\r\\n]*)\\r\\n\\s*\\*\\/)\\r\\n\\s*private","$1\r\n\t@ApiModelProperty(value = \"$2\")\r\n\tprivate"));
        //处理ApiModelProperty(hidden = true)的情况（有/**/注释）
        apiModelPropertyRegex.add(Pair.of("(\\/\\*\\*\\r\\n\\s*\\*([^\\r\\n]*)\\r\\n\\s*\\*\\/)\\r\\n\\s*@ApiModelProperty\\(hidden\\s=\\strue\\)","$1\n\t@ApiModelProperty(value = \"$2\",hidden = true)"));
        //处理ApiModelProperty(hidden = true)的情况（无/**/注释）
        apiModelPropertyRegex.add(Pair.of("@ApiModelProperty\\(\\s*hidden\\s*=\\s*true\\s*\\)\\r\\n\\s*((private|protected|public)?\\s+([a-z]|[A-Z]|>|<)+\\s+(([a-z]|[A-Z]|[0-9]|_)+)\\s*;)","@ApiModelProperty(value = \"$4\",hidden = true)\n\t$1"));
        //处理ApiModelProperty("hello")的情况（无/**/注释）
        apiModelPropertyRegex.add(Pair.of("@ApiModelProperty\\(\\s*\"([^\"]+)\"\\)","@ApiModelProperty(value = \"$1\")"));
        //处理完全没有注解的情况
        apiModelPropertyRegex.add(Pair.of("([;|\\{]\\s*)(private\\s*([a-z]|[A-Z]|>|<|_)+\\s*(([a-z]|[A-Z]|[0-9]|>|<|_)+))","$1@ApiModelProperty(value = \"$4\")\n\t$2"));
        //TODO: 处理ApiModelProperty("")的情况（有/**/注释）
        //apiModelPropertyRegex.add(Pair.of("(\\/\\*\\*\\r\\n\\s*\\*([^\\r\\n]*)\\r\\n\\s*\\*\\/)\\r\\n\\s*@ApiModelProperty\\(\\s*\\\"\\s*\\\"\\s*\\)","$1\n\t@ApiModelProperty(value = \"$2\")"));
        //TODO: 处理ApiModelProperty("")的情况（无/**/注释）
        apiModelPropertyRegex.add(Pair.of("@ApiModelProperty\\(\\s*\\\"\\s*\\\"\\s*\\)\\r\\n\\s*((private|protected|public)?\\s+([a-z]|[A-Z]|>|<)+\\s+(([a-z]|[A-Z]|[0-9]|_)+)\\s*;)","@ApiModelProperty(value = \"$4\")\n\t$1"));
    }

    public static List<Pair<String,String>> apiOperationRegex = new ArrayList<>();
    static {
        //处理ApiOperation(value = "abc")数据
        apiOperationRegex.add(Pair.of("@ApiOperation\\(\\s*\"([^\"]+)\"\\s*\\)","@ApiOperation(value = \"$1\",notes = \"$1\")"));
        //处理@ApiOperation("abc")
        apiOperationRegex.add(Pair.of("@ApiOperation\\(value\\s*=\\s*(\"[^\"]*\")\\)","@ApiOperation(value = $1,notes = $1)"));

    }
}