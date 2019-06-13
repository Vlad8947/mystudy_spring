package _1_configuring.with_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("box") // add component-scan into config.xml if use it
public class Box {

    @Autowired(required = false)
    // @Qualifier("thing")
    private Thing thing;

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }
}
