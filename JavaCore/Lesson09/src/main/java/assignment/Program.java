package assignment;

import assignment.entity.CPU;

public class Program {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        CPU.Processor processor = new CPU.Processor();
        cpu.setProcessor(processor);

        float cache = processor.getCache();
        System.out.println(cache);

        CPU.Ram ram = new CPU.Ram();
        cpu.setRam(ram);

        float clockSpeed = ram.getClockSpeed();
        System.out.println(clockSpeed);
    }
}
