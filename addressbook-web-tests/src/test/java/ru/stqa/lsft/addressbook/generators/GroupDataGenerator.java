package ru.stqa.lsft.addressbook.generators;

import ru.stqa.lsft.addressbook.model.DateTestGroup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<DateTestGroup> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<DateTestGroup> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (DateTestGroup group : groups) {
            writer.write(String.format("%s;%s;%s \r\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();

    }

    private static List<DateTestGroup> generateGroups(int count) {
        List<DateTestGroup> groups = new ArrayList<DateTestGroup>();
        for (int i = 0; i < count; i++) {
            groups.add(new DateTestGroup().withName(String.format("test %s", i))
            .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
