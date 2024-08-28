package me.joao.dev_joao_digital_bank_2024.controller.dto;

import me.joao.dev_joao_digital_bank_2024.domain.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto (
        Long id,
        String name,
        AccountDto account,
        CardDto card,
        List<FeatureDto> features,
        List<NewsDto> news) {

    public UserDto(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(model.getCard()).map(CardDto::new).orElse(null),
//                ofNullable(model.getFeatures()).(FeatureDto::new).stream().toList(),
//                ofNullable(model.getFeatures()).map(FeatureDto::new).orElse(null),
                ofNullable(model.getFeatures())
                        .map(features -> features.stream().map(FeatureDto::new).collect(Collectors.toList()))
                        .orElse(null),
                ofNullable(model.getNews())
                        .map(news -> news.stream().map(NewsDto::new).collect(Collectors.toList())).orElse(null)
        );
    }

    public User toModel() {
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
        model.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));

        model.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(toList()));

//        model.setFeatures(ofNullable(this.features).stream().map(FeatureDto::new).tolist());
//        model.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toModel).collect(toList()));

        model.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toModel).collect(toList()));

        return model;

    }
}
