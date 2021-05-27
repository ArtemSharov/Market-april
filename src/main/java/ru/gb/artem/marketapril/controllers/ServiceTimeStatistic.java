package ru.gb.artem.marketapril.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.artem.marketapril.utils.AppLoggingAspect;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class ServiceTimeStatistic {
    private final AppLoggingAspect appLoggingAspect;

    @GetMapping
    public String getStatistic(){
       return appLoggingAspect.getStatistic();
    }

}
