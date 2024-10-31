import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        PriorityQueue<pair> priorityQueue = new PriorityQueue<>((pair1, pair2) -> {
            if (pair1.getTime() != pair2.getTime()) {
                return Integer.compare(pair1.getTime(), pair2.getTime());
            } else {
                return Integer.compare(pair1.getParameters().getProcessingTime(), pair2.getParameters().getProcessingTime());
            }
        });
        int totalTimeOfProcessing = 0, availableTime = 0;
        while (tests > 0) {
            tests--;
            int id = sc.nextInt();
            int arrivalTime = sc.nextInt();
            int processingTime = sc.nextInt();
            int delay = totalTimeOfProcessing - arrivalTime;
            if(delay < 0){
                delay = 0;
            }
            if (arrivalTime >= availableTime) {
                availableTime = totalTimeOfProcessing;
            }
            totalTimeOfProcessing += processingTime;
            Parameters parameters = new Parameters(id, arrivalTime, processingTime, delay, delay + processingTime);
            priorityQueue.add(new pair(availableTime, parameters));
        }
        int sumOfProcessingTime = 0;
        while (!priorityQueue.isEmpty()) {
            pair task = priorityQueue.poll();
            Parameters p = task.getParameters();
            int delay = sumOfProcessingTime - p.getArrivalTime();
            if(delay < 0){
                delay = 0;
            }
            sumOfProcessingTime += p.getProcessingTime();
            p.setDelay(delay);
            p.setTurnAroundTime(delay + p.getProcessingTime());
            System.out.println(p.getId() + " " + p.getArrivalTime() + " " + p.getProcessingTime() + " " + p.getDelay() + " " + p.getTurnAroundTime());
        }
    }
}