package com.zander404.springandjavaerudio.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadResponseDTO implements Serializable {

    private String fileName;
    private String fileDownloadURI;
    private String fileType;
    private Long size;
}
