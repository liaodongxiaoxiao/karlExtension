# karlExtension
> 整理开发过程中常用的 Kotlin扩展函数，便于其他项目中共同使用

### build AAR包
> gradlew.bat :lib:assembleRelease


### 使用方法
1.把**karl_ktx_version.aar**文件拷到**app/libs**文件夹下   



2.在app/build.gradle **dependencies{}** 中添加引用   
 ```xml
 dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar", "*.aar"])
    ...  
 }
```
