package com.eidd.service;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.eidd.DTO.*;
import java.util.List;

public class CsvService {
    public static ClassRoomExport importFromCsv(String csvContent) {
        if(csvContent.startsWith("\uFEFF")) {
            csvContent = csvContent.substring(1);
        }
        CsvMapper csvMapper = new CsvMapper();
        try {
            CsvSchema schema = csvMapper.schemaFor(EleveExport.class)
                    .withHeader()            
                    .withColumnSeparator(';') 
                    .withNullValue("")
                    .withQuoteChar('\"');
            MappingIterator<EleveExport> it = csvMapper
                    .readerFor(EleveExport.class)
                    .with(schema)
                    .readValues(csvContent);
            List<EleveExport> listeEleves = it.readAll();
            GroupeExport groupe = new GroupeExport();
            groupe.setEleves(listeEleves);
            ClassRoomExport classRoom = new ClassRoomExport();
            classRoom.setEleves(groupe);
            return classRoom;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    public static String exportToCsv(ClassRoomExport classRoomExport) {        
        List<EleveExport> eleves = classRoomExport.getEleves().getEleves();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        try {
            CsvSchema schema = csvMapper.schemaFor(EleveExport.class)
            .withHeader()
            .withColumnSeparator(';')  
            .withNullValue("")         
            .withQuoteChar('\"');
            String csvString = '\uFEFF' +csvMapper.writer(schema).writeValueAsString(eleves);
            System.out.println(csvString);
            return csvString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
}
