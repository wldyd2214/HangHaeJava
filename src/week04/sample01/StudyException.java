package week04.sample01;

public class StudyException {
    public static void main(String[] args) {
        OurClass ourClass = new OurClass();

        // try ~ catch - finally 구문
        // try: 시도하다
        // catch: 붙잡다
        // finally: 마침내

        // 일단 try ~ 그리고, 예외가 발생하면 그걸 잡아(catch),
        // 그리고, 정상적으로 수행되는, 예외가 발생하든 결국, 마침내 수행돼야 하는 로직을 'finally' 수행해
        try {
            ourClass.thisMethodIsDangerous();
        } catch (OurBadException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("우리는 방금 예외를 handling 했습니다. 정상처리되든, 예외사항이 발생하든 여기를 거쳐요!");
        }

    }
}
