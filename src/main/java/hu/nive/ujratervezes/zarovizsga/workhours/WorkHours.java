package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class WorkHours {

    private static final String REGEX = ",";

    public String minWork(String path) {
        Path path1 = Path.of(path);
        WorkDay workDay = new WorkDay();

        try (BufferedReader br = Files.newBufferedReader(path1)) {
            int counter = 0;
            workDay = dataProcessing(workDay, br, counter);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found!", ioe);
        }


        return workDay.toString();
    }

    private WorkDay dataProcessing(WorkDay workDay, BufferedReader br, int counter) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {

            String[] array = line.split(REGEX);

            workDay = firstLine(workDay, counter, array);

            workDay = afterFirstLine(workDay, counter, array);

            counter++;
        }

        return workDay;
    }


    private WorkDay firstLine(WorkDay workDay, int counter, String[] array) {
        if (counter == 0) {
            workDay = getWorkDay(array);
        }
        return workDay;
    }


    private WorkDay afterFirstLine(WorkDay workDay, int counter, String[] array) {
        if (workDay.getHours() > Integer.parseInt(array[1]) && counter > 0) {
            workDay = getWorkDay(array);
        }
        return workDay;
    }

    private WorkDay getWorkDay(String[] array) {
        return new WorkDay(array[0], array[2], Integer.parseInt(array[1]));
    }
}
