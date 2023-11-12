package Model;

public class VisitDay {
    int visitDay;

    public VisitDay(String visitDayString) {
        this.visitDay = validate(visitDayString);
    }

    public int validate(String visitDayString) {
        int visitDayInt = validateIsNumber(visitDayString);
        // validate1To31(visitDayInt);
        return visitDayInt;
    }

    public int validateIsNumber(String visitDayString) {
        int visitDayInt = 0;
        try {
            visitDayInt = Integer.parseInt(visitDayString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return visitDayInt;
    }
}
