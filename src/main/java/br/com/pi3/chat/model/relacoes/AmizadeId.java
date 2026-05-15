package br.com.pi3.chat.model.relacoes;

import java.io.Serializable;
import java.util.Objects;

public class AmizadeId implements Serializable {

    private Long user1;
    private Long user2;

    public AmizadeId() {}

    public AmizadeId(Long user1, Long user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmizadeId)) return false;
        AmizadeId that = (AmizadeId) o;
        return Objects.equals(user1, that.user1) &&
                Objects.equals(user2, that.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}