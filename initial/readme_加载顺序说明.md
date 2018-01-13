##Java虚拟机类加载顺序 （如评论所言，将文中写的“system classloader”有点误导，应该改成“AppClassLoader”，更方便理解，即应用类加载器）

1. 检测此Class是否载入过（即在cache中是否有此Class），如果有到8,如果没有到2 
2. 如果parent classloader不存在（没有parent，那parent一定是bootstrap classloader了），到4 
3. 请求parent classloader载入，如果成功到8，不成功到5 
4. 请求jvm从bootstrap classloader中载入，如果成功到8 
5. 寻找Class文件（从与此classloader相关的类路径中寻找）。如果找不到则到7. 
6. 从文件中载入Class，到8. 
7. 抛出ClassNotFoundException. 
8. 返回Class. 

##tomcat中class和jar的加载顺序

 由ClassLoader的双亲委托模式加载机制我们可以知道，假设两个包名和类名完全相同的class文件不再同一个jar包，如果一个class文件已经被加载java虚拟机里了，那么后面的相同的class文件就不会被加载了。
 
 
 > classloader 加载类用的是全盘负责委托机制。所谓全盘负责，即是当一个classloader加载一个Class的时候，这个Class所依赖的和引用的所有 Class也由这个classloader负责载入，除非是显式的使用另外一个classloader载入；委托机制则是先让parent（父）类加载器 (而不是super，它与parent classloader类不是继承关系)寻找，只有在parent找不到的时候才从自己的类路径中去寻找。此外类加载还采用了cache机制，也就是如果 cache中保存了这个Class就直接返回它，如果没有才从文件中读取和转换成Class，并存入cache，这就是为什么我们修改了Class但是必须重新启动JVM才能生效的原因。 