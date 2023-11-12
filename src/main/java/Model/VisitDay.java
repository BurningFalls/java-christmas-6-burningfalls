package Model;

public class VisitDay {
    private int visitDay;

    public VisitDay(String visitDayString) {
        visitDayString = visitDayString.strip();
        this.visitDay = validate(visitDayString);
    }

    public int validate(String visitDayString) {
        int visitDayInt = validateIsNumber(visitDayString);
        validate1To31(visitDayInt);
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

    public void validate1To31(int visitDayInt) {
        if (visitDayInt < 1 || visitDayInt > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    @Override
    public String toString() {
        return visitDay + "일";
    }
}
