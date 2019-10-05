package com.enhakkore.webservice.dto.books;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BooksResponseDto implements Serializable {

    private BooksResponseDto.Meta mets;
    private List<document> documents;

    public  List<document> getDocuments(){
        return documents;
    }

    static class Meta{
        long total_count;
        long pageable_count;
        Boolean is_end;
    }

    public static class documnet{
        String title;
        String contents;
        String uril;
        List<String> author;
        String publisher;
        String thumbnail;
    }
}
