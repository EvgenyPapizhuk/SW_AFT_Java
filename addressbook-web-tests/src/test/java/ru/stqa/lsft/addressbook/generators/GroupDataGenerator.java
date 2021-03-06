package ru.stqa.lsft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "target File")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<DateTestGroup> groups = generateGroups(count);
        if (format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(groups, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(groups, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<DateTestGroup> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try(Writer writer = new FileWriter(file);) {
            writer.write(json);
        }
    }

    private void saveAsXml(List<DateTestGroup> groups, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(DateTestGroup.class);
        String xml = xStream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<DateTestGroup> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (DateTestGroup group : groups) {
            writer.write(String.format("%s;%s;%s \r\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private List<DateTestGroup> generateGroups(int count) {
        List<DateTestGroup> groups = new ArrayList<DateTestGroup>();
        for (int i = 0; i < count; i++) {
            groups.add(new DateTestGroup().withName(String.format("test %s", i))
            .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
