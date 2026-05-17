package lambda;

public class LambdaImplement  implements Lambda {
    @Override
    public void procString(String str, int num) {
        int lengthStr = str.length();
        if(lengthStr == num){
            System.out.println("str의 길이와, num 숫자는 같습니다.");
        }
    }
}
