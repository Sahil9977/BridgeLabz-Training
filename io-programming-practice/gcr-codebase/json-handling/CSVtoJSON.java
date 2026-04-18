package json;


import com.fasterxml.jackson.dataformat.csv.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

public class CSVtoJSON  {
    public static void main(String[] args) throws Exception {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        MappingIterator<Map<String,String>> it = mapper
            .readerFor(Map.class)
            .with(schema)
            .readValues(new File("data.csv"));

        List<Map<String,String>> list = it.readAll();

        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(list);

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.json"));
        bw.write(json);
        bw.close();

        System.out.println("Converted CSV → JSON saved to output.json");
    }
}
