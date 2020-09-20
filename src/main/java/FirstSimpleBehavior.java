import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class FirstSimpleBehavior extends AbstractBehavior<String> {
    private FirstSimpleBehavior(ActorContext<String> context) {
        super(context);
    }

    public static Behavior<String> create(){
        return Behaviors.setup(FirstSimpleBehavior::new);

    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("say hello", () -> {
            System.out.println("Hello");
            return this;
        })
                .onMessageEquals("who", () -> {
                    System.out.println("My path is "+ getContext().getSelf().path());
                    return this;
                })
                .onMessageEquals("create child",() -> {
                    ActorRef<String> sedcondActor = getContext().spawn(FirstSimpleBehavior.create(), "secondActor");
                    sedcondActor.tell("who");
                    return this;
                })
                .onAnyMessage(m->{
                    System.out.println("I received the message "+ m);
                    return this;
                })
                .build();
    }
}
