package br.com.pi3.chat.DTO.amigo;

import java.util.List;

public class AmigoResponseBody {
    List<AmigoDTO> amigoDTOList;

    public AmigoResponseBody(List<AmigoDTO> amigoDTOList){
        this.amigoDTOList = amigoDTOList;
    }

    public List<AmigoDTO> getAmigoDTOList() {
        return amigoDTOList;
    }

    public void setAmigoDTOList(List<AmigoDTO> amigoDTOList) {
        this.amigoDTOList = amigoDTOList;
    }
}
