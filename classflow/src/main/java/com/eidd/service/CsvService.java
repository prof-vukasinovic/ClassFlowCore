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
        int firstLineEndIndex = csvContent.indexOf('\n');
        String lineClasse = csvContent.substring(0, firstLineEndIndex).trim();
        String csvElevesOnly = csvContent.substring(firstLineEndIndex + 1);
        CsvMapper csvMapper = new CsvMapper();
        try {
            CsvSchema schema = csvMapper.schemaFor(EleveExport.class)
                    .withColumnSeparator(';') 
                    .withNullValue("")
                    .withQuoteChar('\"');
            MappingIterator<EleveExport> it = csvMapper
                    .readerFor(EleveExport.class)
                    .with(schema)
                    .readValues(csvElevesOnly);
            List<EleveExport> listeEleves = it.readAll();
            GroupeExport groupe = new GroupeExport();
            groupe.setEleves(listeEleves);
            ClassRoomExport classRoom = new ClassRoomExport();
            classRoom.setEleves(groupe);
            List<TableExport> tables = new java.util.ArrayList<>();
            for(int i=0; i<listeEleves.size(); i++) {
                TableExport table = new TableExport(new PositionExport(i/7, i%7));
                tables.add(table);
            }
            classRoom.setTables(tables);
            String[] metadata = lineClasse.split(";");
            if(metadata.length > 0) classRoom.setNom(metadata[1]);
            classRoom.setId(Long.parseLong(metadata[0]));
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
            .withColumnSeparator(';')  
            .withNullValue("")         
            .withQuoteChar('\"');
            String headerClasse = classRoomExport.getId() + ";\"" + classRoomExport.getNom() + "\"\n";
            String csvString = '\uFEFF' + headerClasse + csvMapper.writer(schema).writeValueAsString(eleves);
            System.out.println(csvString);
            return csvString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
}
