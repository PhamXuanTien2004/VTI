package assignment.entity;

public class CPU {
    private int price;
    private  Processor processor;
    private Ram ram;

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public static class Processor{
        private int coreAmount;
        private String menufacturer;

        public float getCache(){
            return 4.3f;
        }
    }
    public static class Ram{
        private int memory;
        private String menufacturer;

        public float getClockSpeed(){
            return 5.5f;
        }
    }

}
