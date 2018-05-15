package com.anthem.platform.client.helloworld;
 
import javax.validation.constraints.NotNull;
 
import com.anthem.oss.nimbus.core.domain.definition.Domain;
import com.anthem.oss.nimbus.core.domain.definition.Domain.ListenerType;
import com.anthem.oss.nimbus.core.domain.definition.Model;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Page;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Section;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.TextBox;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Tile;
 
import lombok.Getter;
import lombok.Setter;
@Domain(value = "helloworld", includeListeners={ListenerType.websocket})
@Getter @Setter
public class ViewHelloWorld {
 
@Page(route="", defaultPage=true)
private Page_HelloWorld helloWorldPage;
 
@Model
@Getter @Setter
public static class Page_HelloWorld  {
 
 
    @Tile(title="Hello World Sample", size=Tile.Size.Medium)
    private Card_HelloWorld helloWorldCard;
 }



 The Card_HelloWorld defines the inner class.@NotNull it doesn't allows the null values
 
 
@Model
@Getter @Setter
public static class Card_HelloWorld  {
 
    @Section
    private Section_HelloWorld helloWorldSec;
}
 
 
@Model
@Getter @Setter
public static class Section_HelloWorld {
 
     @TextBox()  private String output;
     @TextBox(postEventOnChange=true) @NotNull private String type;
}


Create a new Application.java class to start up our spring boot project.

package com.anthem.platform.client.helloworld;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
 
 
@SpringBootApplication
 
public class Application {
 
    public static void main(String[] args) {
 
        SpringApplication.run(Application.class, args);
        System.out.println("**** Platform-helloworld ***** Started !!");
    }
 
 
}
