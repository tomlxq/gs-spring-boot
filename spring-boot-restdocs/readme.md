spring官方推荐的restdoc去生成api文档。本文创建一个简单的springboot工程，将http接口通过Api文档暴露出来。
只需要通过 JUnit单元测试和Spring的MockMVC就可以生成文档。

Restdoc,通过单元测试生成api文档

restdocs是通过单元测试生存snippets文件，然后snippets根据插件生成htm文档的。

````
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class SpringBootRestdocsApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("home"));
    }

}
````

@AutoConfigureRestDocs注解开启了生成snippets文件，并指定了存放位置。

默认情况下，snippets是Asciidoctor格式的文件，包括request和reponse，另外其他两种httpie和curl两种流行的命令行的http请求模式。

到目前为止，只生成了Snippets文件，需要用Snippets文件生成文档。
adoc的书写格式，参考:http://docs.spring.io/spring-restdocs/docs/current/reference/html5/，这里不多讲解。

需要使用asciidoctor-maven-plugin插件，在其pom文件加上：
````
<plugin>
            <groupId>org.asciidoctor</groupId>
            <artifactId>asciidoctor-maven-plugin</artifactId>
            <version>1.5.3</version>
            <executions>
                <execution>
                    <id>generate-docs</id>
                    <phase>prepare-package</phase>
                    <goals>
                        <goal>process-asciidoc</goal>
                    </goals>
                    <configuration>
                        <sourceDocumentName>index.adoc</sourceDocumentName>
                        <backend>html</backend>
                        <attributes>
                            <snippets>${project.build.directory}/snippets</snippets>
                        </attributes>
                    </configuration>
                </execution>
            </executions>
        </plugin>
````

这时只需要通过mvnw package命令就可以生成文档了。 
在/target/generated-docs下有个index.html

