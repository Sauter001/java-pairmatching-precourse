package pairmatching.view;

public class OutputView {
    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void displayInitialized() {
        System.out.println("초기화 되었습니다.");
    }
}
