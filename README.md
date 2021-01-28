# karlExtension
> 整理开发过程中常用的 Kotlin扩展函数，便于其他项目中共同使用

### 使用方法
 1. 配置项目根目录 **build.gradle** 文件
 ```xml
 buildscript {
    ...
    repositories {
        google()
        jcenter()
        //add this line
        maven { url 'https://dl.bintray.com/liaodongxiaoxiao/maven' }
    }
    ...
}

allprojects {
    repositories {
        google()
        jcenter()
        //add this line
        maven { url 'https://dl.bintray.com/liaodongxiaoxiao/maven' }
    }
}

 ```
2. 配置**APP** module下的**app/build.gradle** 文件
```xml
dependencies {
  ...
  implementation 'com.karl.kotlin.extension:karl-ktx:1.0'
  ...
}
```
