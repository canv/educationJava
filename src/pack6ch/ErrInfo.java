// 215 page - Obj return
package pack6ch;

class Err {
    String errorMessage;
    int severityLevel;

    Err(String errorMessage, int severityLevel) {
        this.errorMessage = errorMessage;
        this.severityLevel = severityLevel;
    }
}


class ErrorInfo {
    private String[] errorList = {
            "Input error",
            "Output error",
            "No disk space",
            "Index out of range"
    };

    private int[] severityList = {3, 3, 2, 4};

    Err getErrorInfo(int i) {
        if (i >= 0 && i < errorList.length)
            return new Err(errorList[i], severityList[i]);
        else return new Err(
                "Unknown error code",
                0);
    }
}


public class ErrInfo {
    public static void main(String[] args) {
        ErrorInfo errorTest = new ErrorInfo();
        Err e;

        e = errorTest.getErrorInfo(2);
        System.out.println(e.errorMessage +
                ", level: " +
                e.severityLevel);

        e = errorTest.getErrorInfo(19);
        System.out.println(e.errorMessage +
                ", level: " +
                e.severityLevel);
    }
}