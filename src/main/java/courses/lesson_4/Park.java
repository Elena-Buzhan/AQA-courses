package courses.lesson_4;

public class Park {
    public static class Attraction {
        private String nameAttraction;
        private String workingTime;
        private int price;

        public Attraction(String nameAttraction, String workingTime, int price) {
            this.nameAttraction = nameAttraction;
            this.workingTime = workingTime;
            this.price = price;
        }

        public String getNameAttraction() {
            return nameAttraction;
        }

        public String getWorkingTime() {
            return workingTime;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "nameAttraction='" + nameAttraction + '\'' +
                    ", workingTime='" + workingTime + '\'' +
                    ", price=" + price +
                    '}';
        }

    }

}
