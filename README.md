# 注解修复工具
修复因为注解不规范导致的编译失败问题


1、在修复注解的过程中，如果发现依赖缺失，会自动导入对应的注解依赖

2、在使用工具前，首先要确保本地分支是最新代码。

3、修复只针对于标准的类名称，比如`*DTO.java`,`*VO.java`,`*Controller.java`等

4、如果有不满足需求的修复方式，可以手动修改对应的正则，重新编译运行即可

5、修改完成之后，重新编译一下项目，因为可能存在部分注解修改的重复（主要是ApiParam）

# ApiParam修复

## 1、修复ApiParam缺失问题
**在代码中只对后缀为*Controller.java（不区分大小写）进行处理，不会对Feign和Service层造成影响**

使用正则表达式插入ApiParam参数，可以处理@RequestBody  @RequestParam  @NotNull  @Validate @NotBlank 修饰的参数
> 存在某些情况下，@ApiParam插入重复的情况，但是数量应该不多，需要单独修改
```java
//修复前
public ResponseResult<List> example(@RequestBody Param param){
    
}

//修复后
public ResponseResult<List> example(@ApiParam(value = "请求参数",example = "示例参数") @RequestBody Param param){

}
```

## 2、修复ApiParam("abcd")
```java
//修复前
public ResponseResult<List> example(@ApiParam("abcd") @RequestBody Param param){
    
}

//修复后
public ResponseResult<List> example(@ApiParam(value = "abcd",example = "示例参数") @RequestBody Param param){

}
```

## 3、修复ApiParam("")
```java
//修复前
public ResponseResult<List> example(@ApiParam("") @RequestBody Param param){
    
}

//修复后
public ResponseResult<List> example(@ApiParam(value = "请求参数",example = "示例参数") @RequestBody Param param){

}
```


## 4、修复ApiParam(value = "abcd")
```java
//修复前
public ResponseResult<List> example(@ApiParam(value = "abcd") @RequestBody Param param){
    
}

//修复后
public ResponseResult<List> example(@ApiParam(value = "abcd",example = "示例参数") @RequestBody Param param){

}
```


# ApiModel修复

**只对*DTO.java和*VO.java（不区分大小写）的文件进行处理，不会干扰到其他文件**
## 1、修复ApiModel缺失

修复前
```java

public class DemoDTO extends BaseDTO{
    
}
```
修复后
```java
import io.swagger.annotations.ApiParam;

@ApiModel("参数DTO")
public class DemoDTO extends BaseDTO{

}

```

## 2、修复ApiModel不规范
修复前
```java
@ApiModel("参数DTO")
public class DemoDTO extends BaseDTO{

}
```
修复后
```java
@ApiModel(description = "参数DTO")
public class DemoDTO extends BaseDTO{

}
```

## 3、修复ApiModel不规范
修复前
```java
@ApiModel("")
public class DemoDTO extends BaseDTO{

}
```
修复后
```java
@ApiModel(description = "参数DTO")
public class DemoDTO extends BaseDTO{

}
```

# ApiModelProperty修复

**只对*DTO.java和*VO.java（不区分大小写）的文件进行处理，不会干扰到其他文件**

## 1、修复ApiModelProperty缺失
> 对于没有标准注解的属性，会直接以属性名作为value
修复前
```java
public class DemoDTO extends BaseDTO{
    /**
     * 学科表主键
     */
    private Long subjectId;

    /**
     * 学科编码
     */
    private String subjectCode;

    /**
     * 学科名称
     */
    private String subjectName;
    
    private Integer subjectGrade;
}
```
修复后
```java
public class DemoDTO extends BaseDTO{
    /**
     * 学科表主键
     */
    @ApiModelProperty(value = "学科表主键")
    private Long subjectId;

    /**
     * 学科编码
     */
    @ApiModelProperty(value = "学科编码")
    private String subjectCode;

    /**
     * 学科名称
     */
    @ApiModelProperty(value = "学科名称")
    private String subjectName;

    @ApiModelProperty(value = "subjectGrade")
    private Integer subjectGrade;
}

```

## 2、修复ApiModelProperty("abcd")
修复前
```java
public class DemoDTO extends BaseDTO{

    @ApiModelProperty("学科表主键")
    private Long subjectId;
}
```
修复后
```java
public class DemoDTO extends BaseDTO{
    
    @ApiModelProperty(value = "学科表主键")
    private Long subjectId;
}
```

## 3、修复ApiModelProperty(hidden = true)
修复前
```java
public class DemoDTO extends BaseDTO{
    /**
     * 学科表主键
     */
    @ApiModelProperty(hidden = true)
    private Long subjectId;
}
```
修复后
```java
public class DemoDTO extends BaseDTO{
    /**
     * 学科表主键
     */
    @ApiModelProperty(value = "学科表主键",hidden = true)
    private Long subjectId;
}
```
# ApiOperation修复

## 1、修复ApiOperation缺失问题
**在代码中只对后缀为*Controller.java（不区分大小写）进行处理，不会对Feign和Service层造成影响**

暂无方案

## 2、修复ApiOperation("abcd")
```java
//修复前
@ApiOperation("abcd")
public ResponseResult<List> example(@ApiParam("abcd") @RequestBody Param param){
    
}

//修复后
@ApiOperation(value = "abcd",notes = "abcd")
public ResponseResult<List> example(@ApiParam(value = "abcd",example = "示例参数") @RequestBody Param param){

}
```

## 3、修复ApiOperation(value = "abcd")
```java
//修复前
@ApiOperation(value = "abcd")
public ResponseResult<List> example(@ApiParam("") @RequestBody Param param){
    
}

//修复后
@ApiOperation(value = "abcd",notes = "abcd")
public ResponseResult<List> example(@ApiParam(value = "请求参数",example = "示例参数") @RequestBody Param param){

}
```

