package me.joao.dev_joao_digital_bank_2024.controller.dto;

import me.joao.dev_joao_digital_bank_2024.domain.model.Card;

import java.math.BigDecimal;

public record CardDto(Long id, String number, BigDecimal limit) {

    public CardDto(Card model){
        this(model.getId(), model.getNumber(), model.getLimit());
    }

    public Card toModel(){
        Card model = new Card();
        model.setId(this.id);
        model.setNumber(this.number);
        model.setLimit(this.limit);
        return model;
    }

}
