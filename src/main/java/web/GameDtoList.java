package web;

import javax.validation.constraints.NotNull;
import java.util.List;

public class GameDtoList {
    @NotNull
    private List<GameDto> gameDtoList;

    public List<GameDto> getGameDtoList() {
        return gameDtoList;
    }

    public void setGameDtoList(List<GameDto> gameDtoList) {
        this.gameDtoList = gameDtoList;
    }
}
