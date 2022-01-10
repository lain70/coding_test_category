package Etc;

public class MinusAmount {
    public long solution(long price, int money, long count) {
        long answer = (((count * (count + 1) / 2) * price) - money);
        return (answer > 0)?answer:0;
    }

}
