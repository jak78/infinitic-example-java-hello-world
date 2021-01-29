package hello.world.workflows;

import io.infinitic.workflows.Workflow;
import javax.annotation.Nullable;

public interface HelloWorld extends Workflow {
    String greet(@Nullable String name);
}