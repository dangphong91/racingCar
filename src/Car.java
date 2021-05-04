public class Car implements Runnable {
    String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int run = 0;
        long startTime = System.currentTimeMillis();
        while (run < Main.DISTANCE) {
            try {
                int speed = (int) (Math.random()*20);
                run += speed;
                String line = "]|";
                int percent = (run * 100) / Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i+= Main.STEP) {
                    if (percent >= i + Main.STEP) {
                        line += "-";
                    }
                    else if (percent >= i && percent < i + Main.STEP) {
                        line += "0="+this.name+"=0";
                    }
                    else {
                        line += "-";
                    }
                }
                line += "|[";
                System.out.println("Car " + this.name + ": " + line + " " + Math.min(Main.DISTANCE, run) + "KM");
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                System.out.println("Car " + this.name + " broken...");
                break;
            }
        }
        long entTime = System.currentTimeMillis();
        System.out.println("Car " + this.name + " Finish in " + (entTime - startTime)/1000 + "s");
    }
}
