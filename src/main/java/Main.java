import akka.actor.typed.ActorSystem;

public class Main {
//    public static void main(String[] args) {
//        ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(), "FirstActorSystem");
//        actorSystem.tell("Hallo are you there ");
//        actorSystem.tell("say hello");
//        actorSystem.tell("create child");
//
//        actorSystem.tell("who");
//    }

    public static void main(String[] args) {
            ActorSystem<String> bigPrimes = ActorSystem.create(ManagerBehavior.create(), "BigPrimes");
            bigPrimes.tell("start");

    }
}
