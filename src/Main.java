public class Main {

    public static void main(String[] args) {
        AnimalThread turtle = (new AnimalThread("Черепашка-Пашка", 10));
        AnimalThread rabbit = (new AnimalThread(" Кролик-Толик ", 1));
        turtle.start();
        rabbit.start();
    }
}
class AnimalThread extends Thread {
    String Name;
    int championship;
    final int interval= 11;

    public AnimalThread(String PersonName, int priorityThread) {
        this.Name = PersonName;
        this.championship = priorityThread;
    }
    public void run() {
        Thread.currentThread().setPriority(championship);
        Thread.currentThread().setName(Name);
        int timeToStep = 1000 / (Thread.currentThread().getPriority());
        for (int i = 0; i < interval; i++){
            try {
                Thread.sleep(timeToStep);
                System.out.println(getName() + (" - ")+( i*100) + " м ");
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            if (i == interval / 2) {

                if (Thread.currentThread().getPriority() == 1) {
                    Thread.currentThread().setPriority(10);
                } else {
                    Thread.currentThread().setPriority(1);
                }
                timeToStep = 1000 / (Thread.currentThread().getPriority());
            }
            if (i == interval - 10) {
            }

        }
        System.out.println("Забег завершён");
        System.out.println("Черепашка-Пашка WINNER!!!");
    }
}