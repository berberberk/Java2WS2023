package pr4;

public class TestHuman {
    public static void main(String[] args){
        Human human = new Human("Тарас", 14, 'M');
        human.setAge(18);
        System.out.println(human);
        Human.Head humanHead = human.new Head();
        humanHead.think("Differential Equations");
        Human.Hand humanHand = human.new Hand();
        humanHand.setState(true);
        humanHand.getState();
        Human.Leg humanLeg = human.new Leg();
        humanLeg.setState(false);
        humanLeg.getState();
    }
}
